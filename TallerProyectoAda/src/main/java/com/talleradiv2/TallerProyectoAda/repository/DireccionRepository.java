package com.talleradiv2.TallerProyectoAda.repository;


import com.talleradiv2.TallerProyectoAda.Model.Direccion;
import com.talleradiv2.TallerProyectoAda.Model.Vehiculo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface DireccionRepository extends CrudRepository<Direccion,Integer> {

   /*  @Query(value = "select id_direccion from id_user= :userId",nativeQuery = true)
     Collection<Direccion> getDireccionByUserId(@Param("id_direccion")int id_direccion);*/

}
