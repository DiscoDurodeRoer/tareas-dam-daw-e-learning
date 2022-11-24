-- 1
alter table tarjeta add totalgastado number(8,2) default 0 NOT NULL;

-- 2

alter table compra drop constraint chk_compra;
alter table compra add constraint chk_compra check ( (extract(day from fecha) >= 15 and extract(month from fecha) = 12) or (extract(day from fecha) <= 31 and extract(month from fecha) = 1) );

-- 3

alter table compra drop constraint chk_compra;

-- 4

alter table compra drop constraint fk_cif;
alter table comercio drop primary key;
alter table comercio drop unique(nombre);
alter table comercio add primary key(nombre);
alter table comercio add  unique(CIF);
alter table compra add constraint fk_cif FOREIGN KEY (CIF) REFERENCES comercio(CIF);


-- 5

alter table tarjeta rename column num to numtarjeta;

alter table compra drop constraint fk_tarjeta;
alter table compra add constraint fk_tarjeta FOREIGN KEY (numtarjeta) REFERENCES tarjeta(numtarjeta) on delete cascade;

-- 6

-- B:C Esto borraria todos los registros de compra que se hayan hecho con la tajeta que se elimina
-- B:N Cuando se borra un titular, todos los titulares con ese campo titular pasarian a null

-- 7

rename tarjeta to tarjeta2;
alter table compra drop constraint fk_tarjeta;
alter table compra add constraint fk_tarjeta FOREIGN KEY (numtarjeta) REFERENCES tarjeta2(numtarjeta) on delete cascade;

-- 8

alter table tarjeta2 drop constraint fk_titular;
drop table titular;