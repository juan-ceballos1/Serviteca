select asistencia.id,asistencia.id_tipo_asistencia,asistencia.id_vehiculo,asistencia.fecha_inicio,asistencia.fecha_fin,asistencia.precio,tipoasistencia.id,tipoasistencia.nombre,vehiculo.id,vehiculo.matricula,vehiculo.marca,vehiculo.modelo
from asistencia join tipoasistencia
on asistencia.id_tipo_asistencia=tipoasistencia.id
join vehiculo on asistencia.id_vehiculo=vehiculo.id