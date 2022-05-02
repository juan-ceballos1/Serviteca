insert into tipoasistencia(
    nombre
) values ('LAVA');

insert into vehiculo(
    matricula, marca,modelo
) values ('12345','NISSAN','CENTRA');

insert into asistencia(
    id_tipo_asistencia
    ,id_vehiculo,fecha_inicio, fecha_fin,precio
) values (1,1,'2022-05-03T18:15:56.331372800','2022-05-03T18:15:56.331372800',2000);