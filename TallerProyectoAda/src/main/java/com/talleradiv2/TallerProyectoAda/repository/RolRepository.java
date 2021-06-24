package com.talleradiv2.TallerProyectoAda.repository;

import com.talleradiv2.TallerProyectoAda.Model.Direccion;
import com.talleradiv2.TallerProyectoAda.Model.Rol;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;


public interface RolRepository extends CrudRepository<Rol,Integer> {

    @Query(value = "select * from rol where id_rol in (select id_rol from user_role where id_user= :userId)",nativeQuery = true)
    Collection<Rol> getRolByUser(@Param("userId") String userId);



   /* @Query(value = "select id_proveedor from user_role where id_user= :userId",nativeQuery = true)
    Collection<Proveedor> getProveedorByRol(@Param("id_proveedor")String userId);
*/

}
