-- 1

create or replace procedure clasificarPorEdad(p_edad number)
as
begin
        if p_edad >= 0 and p_edad <= 3 then
            dbms_output.put_line('Edad infantil');
        elsif p_edad >= 4 and p_edad < 16 then
            dbms_output.put_line('Edad escolar');
        elsif p_edad >= 16 and p_edad <= 65 then
            dbms_output.put_line('Edad de trabajar');
        elsif p_edad >= 66 and p_edad <= 100 then
            dbms_output.put_line('Edad de jubilacion');
        else
            dbms_output.put_line('Valor erroneo');
        end if;
       
end;
/

declare
    v_edad number(3) := &edad;
begin
    clasificarPorEdad(v_edad);
end;
/

-- 2

create or replace procedure mostrarNumeros(p_n1 number, p_n2 number)
as
    mayor number;
    menor number;
begin
       
        if p_n1 > p_n2 then
            mayor := p_n1;
            menor := p_n2;
        else
            mayor := p_n2;
            menor := p_n1;
        end if;
        
        for v_i in menor..mayor
        loop
            dbms_output.put_line(v_i);
        end loop;
        
       
end;
/

declare
    v_n1 number(3) := &n1;
    v_n2 number(3) := &n2;
begin
    mostrarNumeros(v_n1, v_n2);
end;
/

-- 3

create or replace function ultimaReserva(p_cod_cliente reserva.codcliente%type)
return Date
as
    v_ultima_reserva reserva.fechainicio%type;
begin
    
    select to_date(max(fechainicio)) into v_ultima_reserva
    from reserva
    where codcliente = p_cod_cliente;
    
    return v_ultima_reserva;

end;
/


declare
    v_cod_cliente reserva.codcliente%type := &codcliente;
    v_ultima_reserva Date;
begin

    v_ultima_reserva := ultimaReserva(v_cod_cliente);

    if v_ultima_reserva is null then
        dbms_output.put_line('No existe el cliente');
    else
        dbms_output.put_line(v_ultima_reserva);
    end if;

end;
/

--4

create or replace procedure sumaReservas
as
   v_total number(8,2) := 0;
   cursor c_reservas is
    select preciototal
    from reserva
    where EXTRACT(YEAR FROM fechainicio) = EXTRACT(YEAR FROM sysdate) - 1;
    registro c_reservas%rowtype;
begin
   
   for registro in c_reservas loop
    v_total := v_total + registro.preciototal;
   end loop;
   
   dbms_output.put_line(v_total);
   
end;
/

begin
    sumaReservas();
end;
/

-- 5

create or replace trigger compruebaFecha
before insert or update on reserva for each row
begin
    
    if :new.fechainicio > :new.fechafin then
        :new.fechafin := :new.fechainicio + 1;
    end if;
    
end;
/

insert into reserva values(1, 
to_date('01/01/24', 'DD/MM/YY'), 
to_date('01/01/23', 'DD/MM/YY'),
100,
'C001');

update reserva 
set fechafin = to_date('01/01/23', 'DD/MM/YY') 
where numero = 1;
