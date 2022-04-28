update servicio
set fecha_inicio = :fechaInicio,
	fecha_fin = :fechaFin,
	precio = :precio,
	id_tipo_servicio =:idTipoServicio,
	id_vehiculo =:idVehiculo,
	precio =:precio
where id = :id