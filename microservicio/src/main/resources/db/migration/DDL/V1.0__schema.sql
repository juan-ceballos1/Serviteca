create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);



create table tiposervicio (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 primary key (id)
);

create table vehiculo (
 id int(11) not null auto_increment,
 matricula varchar(100) not null,
 marca varchar(100) not null,
 modelo varchar(100) not null,
 primary key (id)
);

create table servicio (
 id int(11) not null auto_increment,
 id_tipo_servicio int(11) not null,
 id_vehiculo int(11) not null,
 fecha_inicio datetime null,
 fecha_fin datetime null,
 precio double not null,
 primary key (id),
 FOREIGN KEY (id_tipo_servicio) REFERENCES tiposervicio(id),
 FOREIGN KEY (id_vehiculo) REFERENCES vehiculo(id)
);