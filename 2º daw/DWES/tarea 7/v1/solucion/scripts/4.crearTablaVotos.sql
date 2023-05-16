-- Seleccionamos la base de datos "proyectoT7"
use proyectoT7;

create table votos(
    id int auto_increment primary key,
    cantidad int default 0,
    idPr int not null,
    idUs varchar(20) not null,
    constraint fk_votos_usu foreign key(idUs) references usuarios(usuario) on delete cascade on update cascade,
    constraint fk_votos_pro foreign key(idPr) references productos(id) on delete cascade on update cascade
);