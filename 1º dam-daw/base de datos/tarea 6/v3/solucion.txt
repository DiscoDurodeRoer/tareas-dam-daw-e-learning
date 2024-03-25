-- 1

create or replace function existe_pedido(p_numpedido pedidos.num%type)
return boolean
 as v_numpedidos number(8,0) := 0;
begin

    select count(*) into v_numpedidos
    from pedidos
    where num = p_numpedido;

    return v_numpedidos > 0;

end;
/

declare 
 v_numpedido pedidos.num%type := &codigo;
 v_existe Boolean := false;
begin

    if existe_pedido(v_numpedido) then
        DBMS_OUTPUT.PUT_LINE('El pedido existe');
    else
        DBMS_OUTPUT.PUT_LINE('El pedido no existe');
    end if;

end;
/

-- 2

create or replace function datos_pedido(p_numpedido pedidos.num%type)
return pedidos%rowtype
 as v_pedido pedidos%rowtype;
begin

    select * into v_pedido
    from pedidos
    where num = p_numpedido;

    return v_pedido;

exception
    when no_data_found then
        return null;

end;
/

declare 
 v_numpedido pedidos.num%type := &codigo;
 v_pedido pedidos%rowtype;
begin

    v_pedido := datos_pedido(v_numpedido);

    if v_pedido.num is not null then
        DBMS_OUTPUT.PUT_LINE('NUM: ' || v_pedido.num);
        DBMS_OUTPUT.PUT_LINE('FECHA: ' || v_pedido.fecha);
        DBMS_OUTPUT.PUT_LINE('GASTOS_ENVIO: ' || v_pedido.gastos_envio);
        DBMS_OUTPUT.PUT_LINE('FECHA_PREVISTA: ' || v_pedido.fecha_prevista);
        DBMS_OUTPUT.PUT_LINE('TOTAL: ' || v_pedido.total);
        DBMS_OUTPUT.PUT_LINE('CLIENTE: ' || v_pedido.cliente);
    else
        DBMS_OUTPUT.PUT_LINE('El pedido no existe');
    end if;

end;
/

-- 3

create or replace procedure datos_cliente(p_codigocliente clientes.codigo%type)
 as v_cliente clientes%rowtype;
begin

    select * into v_cliente
    from clientes
    where codigo = p_codigocliente;
    
    DBMS_OUTPUT.PUT_LINE('CODIGO: ' || v_cliente.codigo);
    DBMS_OUTPUT.PUT_LINE('NOMBRE: ' || v_cliente.nombre);
    DBMS_OUTPUT.PUT_LINE('APELLIDOS: ' || v_cliente.apellidos);
    DBMS_OUTPUT.PUT_LINE('EDAD: ' || v_cliente.edad);
    
exception
    when no_data_found then
        DBMS_OUTPUT.PUT_LINE('El cliente no existe');

end;
/

declare 
 v_codigocliente clientes.codigo%type := &codigo;
begin
    datos_cliente(v_codigocliente);
end;
/

-- 4

create or replace procedure lineas_pedido(v_numpedido pedidos.num%type)
 as 
cursor c_lineas is
SELECT l.num as num, 
    p.nombre as NombreProducto, 
    p.precio as precio, 
    l.cantidad as cantidad,
    l.importe as importe
FROM lineas l, productos p
WHERE l.producto = p.codigo
AND numpedido = v_numpedido;
v_row c_lineas%rowtype;
begin

    open c_lineas;
    
    fetch c_lineas into v_row;
    if c_lineas%notfound then
        DBMS_OUTPUT.PUT_LINE('No hay lineas');
    else
        DBMS_OUTPUT.PUT_LINE(
            'Nº Linea ' || CHR(9) || 
            'NombreProducto' || CHR(9) || 
            'precio' || CHR(9) || 
            'cantidad' || CHR(9) || 
            'importe');
            
        loop
            fetch c_lineas into v_row;
            exit when c_lineas%notfound;
            
            DBMS_OUTPUT.PUT_LINE(
                CHR(9) || v_row.num || CHR(9) || CHR(9) || 
                v_row.NombreProducto || CHR(9) || CHR(9) || CHR(9) || 
                v_row.precio || CHR(9) ||  CHR(9) || 
                v_row.cantidad || CHR(9) ||  CHR(9) || 
                v_row.importe);
        
        end loop;
            
    end if;
    
    
    close c_lineas;

end;
/

declare 
 v_numpedido pedidos.num%type := &codigo;
begin
    lineas_pedido(v_numpedido);
end;
/

-- 5

declare
  v_numpedido pedidos.num%type := &codigo;
  v_datos pedidos%rowtype := null;
begin
    
    if existe_pedido(v_numpedido) = TRUE then
        DBMS_OUTPUT.PUT_LINE('PEDIDO:');
        DBMS_OUTPUT.PUT_LINE('NUM: ' || v_datos.num);
        DBMS_OUTPUT.PUT_LINE('FECHA: ' || v_datos.fecha);
        DBMS_OUTPUT.PUT_LINE('GASTOS DE ENVIO: ' || v_datos.gastos_envio);
        DBMS_OUTPUT.PUT_LINE('FECHA PREVISTA: ' || v_datos.fecha_prevista);
        DBMS_OUTPUT.PUT_LINE('TOTAL: ' || v_datos.total);
        DBMS_OUTPUT.PUT_LINE('CLIENTE: ' || v_datos.cliente);
    
        v_datos := datos_pedido(v_numpedido);
    
        DBMS_OUTPUT.PUT_LINE('CLIENTE:');
        datos_cliente(v_datos.cliente);
    
        DBMS_OUTPUT.PUT_LINE('LINEAS:');
        lineas_pedido(v_numpedido);
    else
        DBMS_OUTPUT.PUT_LINE('No existe el pedido');
    end if;
    
    
end;
/

-- 6

-- Hecho

-- 7

create or replace trigger actualizar_importe_lineas
BEFORE INSERT OR UPDATE ON LINEAS
FOR EACH ROW
DECLARE
    v_precio_producto PRODUCTOS.PRECIO%TYPE;
BEGIN
    SELECT PRECIO INTO v_precio_producto
    FROM PRODUCTOS
    WHERE CODIGO = :NEW.PRODUCTO;

    :NEW.IMPORTE := :NEW.CANTIDAD * v_precio_producto;
END;
/

insert into lineas (num, numpedido, producto, cantidad) values(2, 14, 1002, 1);

-- 8

create or replace trigger actualizar_importe_pedido
after insert or update or delete on lineas
begin

    update pedidos p
    set total = (select sum(importe)
                    from lineas
                    where numpedido = p.num);
    
end;
/

insert into lineas (num, numpedido, producto, cantidad) values(3, 14, 1003, 1);