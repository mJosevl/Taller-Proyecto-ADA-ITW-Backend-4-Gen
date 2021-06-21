package com.talleradiv2.TallerProyectoAda.Controller;

import com.talleradiv2.TallerProyectoAda.Model.*;
import com.talleradiv2.TallerProyectoAda.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping(path = "taller/proyecto/")
public class MainController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Autowired
    private CotizacionRepository cotizacionRepository;

    @Autowired
    private DireccionRepository direccionRepository;

    @Autowired
    private PresupuestoRepository presupuestoRepository;

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Autowired
    private OrdenDeTrabajoRepository ordenDeTrabajoRepository;


    @Autowired
    private RepuestosRepository repuestosRepository;

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private ResourceRepository resourceRepository;


    /////////////////////////////////////////////READ////////////////////////////////////////////////////////////


    @GetMapping(path = "user/{userId}/cliente/all")
    public @ResponseBody
    ResponseEntity<Response> getAllClientes(@PathVariable("userId") String userId) {
        Response response = new Response();
        Collection<Rol> roles = rolRepository.getRolByUser(userId);

        for (Rol rol : roles) {
            if (rol.getId_rol() == 1) {
                response.setObject(clienteRepository.findAll());
                response.setMensaje("Lista de clientes ");
                return ResponseEntity.ok(response);
            }

        }
        response.setMensaje("Acceso restringido");
        return ResponseEntity.ok(response);
    }


    @GetMapping(path = "colaborador/all")
    public @ResponseBody
    Iterable<Colaborador> getAllcolaboradores() {
        return colaboradorRepository.findAll();
    }

    @GetMapping(path = "user/{userId}/colaborador/all")
    public @ResponseBody
    ResponseEntity<Response> getAllColaborador(@PathVariable("userId") String userId) {
        Response response = new Response();
        Collection<Rol> roles = rolRepository.getRolByUser(userId);

        for (Rol rol : roles) {
            if (rol.getId_rol() == 1) {
                response.setObject(colaboradorRepository.findAll());
                response.setMensaje("Consulta realizada con exito");
                return ResponseEntity.ok(response);
            }

        }
        response.setMensaje("Acceso restringido");
        return ResponseEntity.ok(response);
    }


    @GetMapping(path = "proveedor/all")
    public @ResponseBody
    Iterable<Proveedor> getAllproveedores() {
        return proveedorRepository.findAll();
    }

    @GetMapping(path = "user/{userId}/proveedor/all")
    public @ResponseBody
    ResponseEntity<Response> getAllProveedor(@PathVariable("userId") String userId) {
        Response response = new Response();
        Collection<Rol> roles = rolRepository.getRolByUser(userId);

        for (Rol rol : roles) {
            if (rol.getId_rol() == 1) {
                response.setObject(proveedorRepository.findAll());
                response.setMensaje("Consulta realizada con exito");
                return ResponseEntity.ok(response);
            }

        }
        response.setMensaje("Acceso restringido");
        return ResponseEntity.ok(response);
    }



    @GetMapping(path = "user/{userId}/direccion/all")
    public @ResponseBody
    ResponseEntity<Response> getAllDireccion(@PathVariable("userId") String userId) {
        Response response = new Response();
        Collection<Rol> roles = rolRepository.getRolByUser(userId);

        for (Rol rol : roles) {
            if (rol.getId_rol() == 1) {
                response.setObject(direccionRepository.findAll());
                response.setMensaje("Consulta realizada con exito");
                return ResponseEntity.ok(response);
            }

        }
        response.setMensaje("Acceso restringido");
        return ResponseEntity.ok(response);
    }


    @GetMapping(path = "user/{userId}/repuestos/all")
    public @ResponseBody
    ResponseEntity<Response> getAllRepuestos(@PathVariable("userId") String userId) {
        Response response = new Response();
        Collection<Rol> roles = rolRepository.getRolByUser(userId);

        for (Rol rol : roles) {
            if (rol.getId_rol() == 1) {
                response.setObject(repuestosRepository.findAll());
                response.setMensaje("Consulta realizada con exito");
                return ResponseEntity.ok(response);
            }

        }
        response.setMensaje("Acceso restringido");
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "user/{userId}/presupuesto/all")
    public @ResponseBody
    ResponseEntity<Response> getAllPresupuesto(@PathVariable("userId") String userId) {
        Response response = new Response();
        Collection<Rol> roles = rolRepository.getRolByUser(userId);
        System.out.println(roles.size());
        for (Rol rol : roles) {
            if (rol.getId_rol() == 1) {
                response.setObject(presupuestoRepository.findAll());
                response.setMensaje("Consulta realizada con exito");
                return ResponseEntity.ok(response);
            }

        }
        response.setMensaje("Acceso restringido");
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "user/{userId}/cotizacion/all")
    public @ResponseBody
    ResponseEntity<Response> getAllCotizacion(@PathVariable("userId") String userId) {
        Response response = new Response();
        Collection<Rol> roles = rolRepository.getRolByUser(userId);

        for (Rol rol : roles) {
            if (rol.getId_rol() == 1) {
                response.setObject(cotizacionRepository.findAll());
                response.setMensaje("Consulta realizada con exito");
                return ResponseEntity.ok(response);
            }

        }
        response.setMensaje("Acceso restringido");
        return ResponseEntity.ok(response);
    }


    @GetMapping(path = "user/{userId}/orden_de_trabajo/all")
    public @ResponseBody
    ResponseEntity<Response> getAllOrdenDeTrabajo(@PathVariable("userId") String userId) {
        Response response = new Response();
        Collection<Rol> roles = rolRepository.getRolByUser(userId);

        for (Rol rol : roles) {
            if (rol.getId_rol() == 1) {
                response.setObject(ordenDeTrabajoRepository.findAll());
                response.setMensaje("Consulta realizada con exito");
                return ResponseEntity.ok(response);
            }

        }
        response.setMensaje("Acceso restringido");
        return ResponseEntity.ok(response);
    }


    @GetMapping(path = "user/{userId}/vehiculo/{patente}")
    public @ResponseBody
    ResponseEntity<Response> getVehiculoByPatente(@PathVariable("userId") String userId,
                                  @PathVariable("patente") String patente) {

        Response response = new Response();
        Collection<Rol> roles = rolRepository.getRolByUser(userId);

        for (Rol rol : roles) {
            if (rol.getId_rol() == 1 || rol.getId_rol() == 2 ) {
                response.setObject(vehiculoRepository.getVehiculoBypatente(patente));
                response.setMensaje("Consulta realizada con exito");
                return ResponseEntity.ok(response);
            }

        }
        response.setMensaje("Acceso restringido");
        return ResponseEntity.ok(response);
    }




/////////////////////////////////////////////CREATE////////////////////////////////////////////////////////////

    @PostMapping(path = "direccion/create", consumes = "application/json", produces = "application/json")
    public Direccion createAdress(@RequestBody Direccion nDireccion) {
        return direccionRepository.save(nDireccion);
    }



    @PostMapping(path = "user/{id_user}/colaborador/create",consumes = "application/json",produces = "application/json")
    public Colaborador createColaborador(@RequestBody Colaborador newColaborador,
                                         @Param("UserId") String userId) {
        Collection<Rol> rolCollection = rolRepository.getRolByUser(userId);
        for (Rol rol : rolCollection) {
            if (rol.getId_rol() == 1) {
                colaboradorRepository.save(newColaborador);
               
            }


        }return newColaborador;

    }
    @PostMapping(path = "user/{id_user}/cliente/create",consumes = "application/json",produces = "application/json")
    public Cliente createCliente(@RequestBody Cliente newCliente,
                                         @Param("UserId") String userId) {
        Collection<Rol> rolCollection = rolRepository.getRolByUser(userId);
        for (Rol rol : rolCollection) {
            if (rol.getId_rol() == 1 || rol.getId_rol() ==2 ) {
                clienteRepository.save(newCliente);

            }


        }return newCliente;

    }
    @PostMapping(path = "user/{id_user}/vehiculos/create",consumes = "application/json",produces = "application/json")
    public Vehiculo createVehiculo(@RequestBody Vehiculo newVehiculo,
                                         @Param("UserId") String userId) {
        Collection<Rol> rolCollection = rolRepository.getRolByUser(userId);
        for (Rol rol : rolCollection) {
            if (rol.getId_rol() == 1) {
                vehiculoRepository.save(newVehiculo);

            }


        }return newVehiculo;

    }



    /////////////////////////////////////////////UPDATE////////////////////////////////////////////////////////////
    @PutMapping(path = "direccion/update")
    public Direccion updateDireccion(@RequestBody Direccion updateDireccion){

        return direccionRepository.save(updateDireccion);}

  @PutMapping(path = "user/{userId}/direccion/all")

    public Direccion updateDireccion(@PathVariable("id_user") String userId,
                                     @PathVariable ("id_direccion") int id_direccion) {

       Collection<Rol>rols=rolRepository.getRolByUser(userId);
       for (Rol roles: rols){
           if (roles.getId_rol() == 1 || roles.getId_rol() ==2) {
            direccionRepository.findById(id_direccion);

        }
       }return null ;
    }




    @PutMapping(path = "cliente/update")
    public Cliente updateCliente(@RequestBody Cliente updateCliente,
                                 @PathVariable ("id_cliente") String userId){
        Collection<Rol>rols=rolRepository.getRolByUser(userId);
        for (Rol roles: rols){
            if (roles.getId_rol() == 1 || roles.getId_rol() ==2) {
         clienteRepository.save(updateCliente);
            }
        }return null;
    }

    @PutMapping(path = "colaborador/update")
    public Colaborador updateColaborador(@RequestBody Colaborador updateColaborador){

        return colaboradorRepository.save(updateColaborador);}

    @PutMapping(path = "proveedor/update")
    public Proveedor updateProveedor(@RequestBody Proveedor updateProveedor){

        return proveedorRepository.save(updateProveedor);}


    /////////////////////////////////////////////DELETE////////////////////////////////////////////////////////////

    @DeleteMapping(path = "user/{id_user}/direccion/delete/{id_direccion}")
    public @ResponseBody
    String deleteDireccionById(@PathVariable("id_user")String id_user,
                               @PathVariable ("id_direccion") int id_direccion) {

        Collection<Rol> rolByUser = rolRepository.getRolByUser(id_user);
        for (Rol rol : rolByUser) {
            if (rol.getName().equals("administrador")) {
                direccionRepository.deleteById(id_direccion);
                return "La dirección fue eliminada, direccion:" + id_direccion;
            }
        }

        return "Usuario no autorizado para borrar direcciones";
    }

    @DeleteMapping(path = "user/{id_user}/cliente/delete/{id_direccion}")
    public @ResponseBody
    String deleteClienteById(@PathVariable("id_user")String id_user,
                             @PathVariable ("id_cliente") int id_cliente) {

        Collection<Rol> rolByUser = rolRepository.getRolByUser(id_user);
        for (Rol rol : rolByUser) {
            if (rol.getName().equals("administrador")) {
                clienteRepository.deleteById(id_cliente);
                return "El registro fue eliminado, id :" + id_cliente;
            }
        }

        return "Usuario no autorizado para borrar registro de clientes";
    }


    @DeleteMapping(path = "user/{id_user}/colaborador/delete/{id_colaborador}")
    public @ResponseBody
    String deleteColaboradorById(@PathVariable("id_user")String id_user,
                                 @PathVariable ("id_colaborador") int id_colaborador) {

        Collection<Rol> rolByUser = rolRepository.getRolByUser(id_user);
        for (Rol rol : rolByUser) {
            if (rol.getName().equals("administrador")) {
                colaboradorRepository.deleteById(id_colaborador);
                return "El registro fue eliminado, id :" + id_colaborador;
            }
        }

        return "Usuario no autorizado para borrar el registro";
    }

    @DeleteMapping(path = "user/{id_user}/proveedor/delete/{id_proveedor}")
    public @ResponseBody
    String deleteProveedorById(@PathVariable("id_user")String id_user,
                               @PathVariable ("id_proveedor") int id_proveedor) {

        Collection<Rol> rolByUser = rolRepository.getRolByUser(id_user);
        for (Rol rol : rolByUser) {
            if (rol.getName().equals("administrador")) {
                proveedorRepository.deleteById(id_proveedor);
                return "El registro fue eliminado, id :" + id_proveedor;
            }
        }

        return "Usuario no autorizado para borrar el registro de proveedores";
    }

}

