update asistencia
set fecha_inicio = :fechaInicio,
	fecha_fin = :fechaFin,
	id_tipo_asistencia =:idTipoAsistencia,
	id_vehiculo =:idVehiculo,
	precio =:precio
where id = :id