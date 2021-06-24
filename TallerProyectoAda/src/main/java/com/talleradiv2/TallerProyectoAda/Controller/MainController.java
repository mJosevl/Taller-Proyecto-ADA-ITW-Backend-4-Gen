package com.talleradiv2.TallerProyectoAda.Controller;

import com.talleradiv2.TallerProyectoAda.Model.*;
import com.talleradiv2.TallerProyectoAda.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.ls.LSOutput;

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

    @GetMapping(path = "user/{userId}/vehiculo/all")
    public @ResponseBody
    ResponseEntity<Response> getVehiculoAllbyId(@PathVariable("userId") String userId) {

        Response response = new Response();
        Collection<Rol> roles = rolRepository.getRolByUser(userId);

        for (Rol rol : roles) {
            if (rol.getId_rol() == 1 || rol.getId_rol() == 2) {
                response.setObject(vehiculoRepository.findAll());
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
            if (rol.getId_rol() == 1 || rol.getId_rol() == 2) {
                response.setObject(vehiculoRepository.getVehiculoBypatente(patente));
                response.setMensaje("Consulta realizada con exito");
                return ResponseEntity.ok(response);
            }

        }
        response.setMensaje("Acceso restringido");
        return ResponseEntity.ok(response);
    }


/////////////////////////////////////////////CREATE////////////////////////////////////////////////////////////

    @PostMapping(path = "direccion/create")
    public Direccion createAdress(@RequestBody Direccion nDireccion) {
        return direccionRepository.save(nDireccion);
    }

    @PostMapping(path = "user/{userId}/direccion/create")
    public @ResponseBody
    ResponseEntity<Response> createDireccion(@PathVariable("userId") String userId,
                                             @RequestBody Direccion newDireccion) {

        Response response = new Response();
        Collection<Rol> roles = rolRepository.getRolByUser(userId);

        for (Rol rol : roles) {
            if (rol.getId_rol() == 1 || rol.getId_rol() == 2) {
                response.setObject(direccionRepository.save(newDireccion));
                response.setMensaje("Direccion  creada con exito");
                return ResponseEntity.ok(response);
            }

        }
        response.setMensaje("Acceso restringido");
        return ResponseEntity.ok(response);
    }

     @PostMapping(path = "user/{userId}/cliente/create")
    public @ResponseBody
    ResponseEntity<Response> createCliente(@PathVariable("userId") String userId,
                                             @RequestBody Cliente newCliente) {

        Response response = new Response();
        Collection<Rol> roles = rolRepository.getRolByUser(userId);

        for (Rol rol : roles) {
            if (rol.getId_rol() == 1 || rol.getId_rol() == 2) {
                response.setObject(clienteRepository.save(newCliente));
                response.setMensaje("Se ha creado el registro del cliente con exito");
                return ResponseEntity.ok(response);
            }

        }
        response.setMensaje("Acceso restringido");
        return ResponseEntity.ok(response);
    }
    @PostMapping(path = "user/{userId}/vehiculo/create")
    public @ResponseBody
    ResponseEntity<Response> createVehiculo(@PathVariable("userId") String userId,
                                              @RequestBody Vehiculo newVehiculo) {

        Response response = new Response();
        Collection<Rol> roles = rolRepository.getRolByUser(userId);

        for (Rol rol : roles) {
            if (rol.getId_rol() == 1 || rol.getId_rol() == 2) {
                response.setObject(vehiculoRepository.save(newVehiculo));
                response.setMensaje("Nuevo vehículo registrado");
                return ResponseEntity.ok(response);
            }

        }
        response.setMensaje("Acceso restringido");
        return ResponseEntity.ok(response);
    }

    @PostMapping(path = "user/{userId}/cotizacion/create")
    public @ResponseBody
    ResponseEntity<Response> createCotizacion(@PathVariable("userId") String userId,
                                             @RequestBody Cotizacion newCotizacion) {

        Response response = new Response();
        Collection<Rol> roles = rolRepository.getRolByUser(userId);

        for (Rol rol : roles) {
            if (rol.getId_rol() == 1 || rol.getId_rol() == 2) {
                response.setObject(cotizacionRepository.save(newCotizacion));
                response.setMensaje("Cotizacion  valida por 15 días");
                return ResponseEntity.ok(response);
            }

        }
        response.setMensaje("Acceso restringido");
        return ResponseEntity.ok(response);
    }
    /////////////////////////////////////////////UPDATE////////////////////////////////////////////////////////////
    @PutMapping(path = "direccion/update")
    public Direccion updateDireccion(@RequestBody Direccion updateDireccion) {

        return direccionRepository.save(updateDireccion);
    }

    @PutMapping(path = "user/{userId}/direccion/update")
    ResponseEntity<Response> updateDireccion(@PathVariable("userId") String userId,
                                             @RequestBody Direccion upDireccion) {

        Response response = new Response();
        Collection<Rol> roles = rolRepository.getRolByUser(userId);

        for (Rol rol : roles) {
            if (rol.getId_rol() == 1 || rol.getId_rol() == 2) {
                response.setObject(direccionRepository.save(upDireccion));
                response.setMensaje("Direccion  actualizada con exito");
                return ResponseEntity.ok(response);
            }

        }
        response.setMensaje("Acceso restringido");
        return ResponseEntity.ok(response);
    }


    @PutMapping(path = "user/{userId}/cliente/update")
    ResponseEntity<Response> updateCliente(@PathVariable("userId") String userId,
                                             @RequestBody Cliente upCliente) {

        Response response = new Response();
        Collection<Rol> roles = rolRepository.getRolByUser(userId);

        for (Rol rol : roles) {
            if (rol.getId_rol() == 1 || rol.getId_rol() == 2) {
                response.setObject(clienteRepository.save(upCliente));
                response.setMensaje("Cliente  actualizado con exito");
                return ResponseEntity.ok(response);
            }

        }
        response.setMensaje("Acceso restringido");
        return ResponseEntity.ok(response);
    }


    @PutMapping(path = "user/{id_user}/proveedor/update")
    ResponseEntity<Response> updateProveedor(@PathVariable("userId") String userId,
                                             @RequestBody Proveedor upProveedor) {

        Response response = new Response();
        Collection<Rol> roles = rolRepository.getRolByUser(userId);

        for (Rol rol : roles) {
            if (rol.getId_rol() == 1 || rol.getId_rol() == 2) {
                response.setObject(proveedorRepository.save(upProveedor));
                response.setMensaje("Proveedor  actualizado con exito");
                return ResponseEntity.ok(response);
            }

        }
        response.setMensaje("Acceso restringido");
        return ResponseEntity.ok(response);
    }



    /////////////////////////////////////////////DELETE////////////////////////////////////////////////////////////

    @DeleteMapping(path = "user/{id_user}/direccion/delete/{id_direccion}")
    public @ResponseBody
    String deleteDireccionById(@PathVariable("id_user") String id_user,
                               @PathVariable("id_direccion") int id_direccion) {

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
    String deleteClienteById(@PathVariable("id_user") String id_user,
                             @PathVariable("id_cliente") int id_cliente) {

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
    String deleteColaboradorById(@PathVariable("id_user") String id_user,
                                 @PathVariable("id_colaborador") int id_colaborador) {

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
    String deleteProveedorById(@PathVariable("id_user") String id_user,
                               @PathVariable("id_proveedor") int id_proveedor) {

        Collection<Rol> rolByUser = rolRepository.getRolByUser(id_user);
        for (Rol rol : rolByUser) {
            if (rol.getName().equals("administrador")) {
                proveedorRepository.deleteById(id_proveedor);
                return "El registro fue eliminado, id :" + id_proveedor;
            }
        }

        return "Usuario no autorizado para borrar el registro de proveedores";
    }

    @DeleteMapping(path = "user/{id_user}/cotizacion/delete/{id_cotizacion}")
    public @ResponseBody
    String deleteCotizacionById(@PathVariable("id_user") String id_user,
                               @PathVariable("id_cotizacion") int id_cotizacion) {

        Collection<Rol> rolByUser = rolRepository.getRolByUser(id_user);
        for (Rol rol : rolByUser) {
            if (rol.getName().equals("administrador")) {
                cotizacionRepository.deleteById(id_cotizacion);
                return "El registro fue eliminado, id :" + id_cotizacion;
            }
        }

        return "Usuario no autorizado para borrar cotizaciones";
    }


}

