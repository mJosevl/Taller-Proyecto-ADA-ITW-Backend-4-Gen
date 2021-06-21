package com.talleradiv2.TallerProyectoAda.repository;

import com.talleradiv2.TallerProyectoAda.Model.Vehiculo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface VehiculoRepository extends CrudRepository<Vehiculo,Integer> {
    @Query(value = "select * from Vehiculo where patente like %:patente%", nativeQuery = true)
    Iterable<Vehiculo> getVehiculoBypatente(@Param("patente") String nombre);

}
