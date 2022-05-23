-- Tabla familia: Contiene las familias a las que pertenecen los productos
CREATE TABLE FAMILIA(
    codfamilia number(3,0) PRIMARY KEY,
    denofamilia varchar2(50) UNIQUE NOT NULL
);

-- Tabla producto: contendrá información general sobre los productos que distribuye una empresa  a las tiendas
CREATE TABLE PRODUCTO(
    codproducto number(5,0) PRIMARY KEY,
    denoproducto varchar2(20) NOT NULL,
    descripcion varchar2(100),
    preciobase number(6,2) not null,
    porcreposicion number(3, 0),
    unidadesminimas number(4, 0) not null,
    codfamilia number(3,0) not null,
    CONSTRAINT FK_FAMILIA FOREIGN KEY (codfamilia) REFERENCES FAMILIA(codfamilia),
    CONSTRAINT CHK_PRECIO_BASE CHECK (preciobase > 0),
    CONSTRAINT CHK_REPOSICION CHECK (porcreposicion > 0),
    CONSTRAINT CHK_UNIDADES_MINIMAS CHECK (unidadesminimas > 0)
);

-- Tabla tienda: contendrá información básica sobre las tiendas que distribuyen los productos
CREATE TABLE TIENDA(
    codtienda number(3,0) PRIMARY KEY,
    denotienda varchar2(20) not null,
    telefono varchar2(11),
    codigopostal varchar2(5) not null,
    provincia varchar2(5) not null
);

-- Tabla stock: Contendrá para cada tienda el número de unidades disponibles de cada producto.
-- La clave primaria está formada por la concatenación de los campos codtienda y codproducto.
CREATE TABLE STOCK(
    codtienda number(3,0),
    codproducto number(3,0),
    unidades number(6,0) not null,
    PRIMARY KEY(codtienda, codproducto),
    CONSTRAINT FK_TIENDA FOREIGN KEY (codtienda) REFERENCES TIENDA(codtienda),
    CONSTRAINT FK_PRODUCTO FOREIGN KEY (codproducto) REFERENCES PRODUCTO(codproducto),
    CONSTRAINT CHK_UNIDADES_STOCK CHECK (unidadesminimas > 0)
);




















