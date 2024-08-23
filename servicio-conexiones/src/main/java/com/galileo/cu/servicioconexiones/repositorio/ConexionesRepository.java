package com.galileo.cu.servicioconexiones.repositorio;

import com.galileo.cu.commons.models.Conexiones;
import com.galileo.cu.commons.models.UnidadesUsuarios;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@RepositoryRestResource(collectionResourceRel = "conexiones", path = "conexiones")
public interface ConexionesRepository extends PagingAndSortingRepository<Conexiones, Long> {

    Conexiones findFirstConexionesByServicioIsLike(String nombre_servicio);
    
    @Query("SELECT c FROM Conexiones c WHERE (:servicio ='' or c.servicio like %:servicio%) "
           +"AND (:ipServicio ='' or c.ipServicio like %:ipServicio%)"
           + "and ((:fechaFin!=null and :fechaInicio!=null and c.fechaCreacion between :fechaInicio and :fechaFin) "
			+ "or (:fechaFin=null and :fechaInicio!=null and c.fechaCreacion >=:fechaInicio) "
			+ "or (:fechaFin=null and :fechaInicio=null)) ")
	public Page<Conexiones> filtrar(String servicio,String ipServicio,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaInicio, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaFin, Pageable p);

	Conexiones findConexionesByIpServicio(String ip_servicio);
}
