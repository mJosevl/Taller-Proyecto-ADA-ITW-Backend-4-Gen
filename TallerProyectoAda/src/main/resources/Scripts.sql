CREATE TABLE IF NOT EXISTS direccion (
    id_direccion INT NOT NULL AUTO_INCREMENT,
    calle VARCHAR(45) NOT NULL,
    numero int NOT NULL,
    comuna VARCHAR(45) NOT NULL,
    ciudad VARCHAR(45) NOT NULL,
    PRIMARY KEY (id_direccion)

    );

    	CREATE TABLE IF NOT EXISTS proveedor (
    id_proveedor INT NOT NULL AUTO_INCREMENT,
    nombre_empresa VARCHAR(45) NOT NULL,
    rut INT NOT NULL,
    id_direccion INT NOT NULL,
	telefono INT NOT NOT NULL,
	celular INT NOT NULL,
	correo VARCHAR(45) NOT NULL,
    PRIMARY KEY (id_proveedor),
    CONSTRAINT fk_direccion_proveedor FOREIGN KEY (id_direccion)
        REFERENCES direccion (id_direccion)
);

CREATE TABLE IF NOT EXISTS cliente (
    id_cliente INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(45) NOT NULL,
	apellido VARCHAR(45) NOT NULL,
	telefono INT NOT NOT NULL,
    celular INT NOT NULL,
    id_direccion INT NOT NULL,
    rut INT NOT NULL,
	correo VARCHAR(45) NOT NULL,
    PRIMARY KEY (id_cliente),
    CONSTRAINT fk_direccion_cliente
	FOREIGN KEY (id_direccion)
        REFERENCES direccion (id_direccion) );

    CREATE TABLE IF NOT EXISTS colaborador (
    id_colaborador INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(45) NOT NULL,
	apellido VARCHAR(45) NOT NULL,
	telefono INT NOT NULL,
    celular INT NOT NULL,
    id_direccion INT NOT NULL,
    rut INT NOT NULL,
    funcion VARCHAR(45) NOT NULL,
    jornada VARCHAR(45) NOT NULL,
	correo VARCHAR(45) NOT NULL,
    PRIMARY KEY (id_colaborador),
    CONSTRAINT fk_direccion_colaborador FOREIGN KEY (id_colaborador)
        REFERENCES direccion (id_direccion)
        );

CREATE TABLE IF NOT EXISTS vehiculo (
    id_vehiculo INT NOT NULL AUTO_INCREMENT,
    marca  VARCHAR(45) NOT NULL,
	modelo VARCHAR(45) NOT NULL,
	año INT NOT NULL,
    tipo VARCHAR(45) NOT NULL,
    color VARCHAR(45) NOT NULL,
    patente VARCHAR(45) NOT NULL,
	id_cliente INT NOT NULL,
    PRIMARY KEY (id_vehiculo),
    CONSTRAINT fk_cliente_vehiculo FOREIGN KEY (id_cliente)
        REFERENCES cliente (id_cliente)
        );

		CREATE TABLE IF NOT EXISTS repuestos (
    id_repuestos INT NOT NULL AUTO_INCREMENT,
    tipo  VARCHAR(50) NOT NULL,
	valor DOUBLE NOT NULL,
	id_proveedor INT NOT NULL,
    PRIMARY KEY (id_repuestos),
    CONSTRAINT fk_proveedor_repuestos FOREIGN KEY (id_proveedor)
        REFERENCES proveedor (id_proveedor)
        );

		CREATE TABLE IF NOT EXISTS presupuesto(
		id_presupuesto int NOT NULL AUTO_INCREMENT,
		id_repuestos int NOT NULL,
		tipo_daño VARCHAR(150)NOT NULL,
		mo_pintura  VARCHAR(150)NOT NULL,
		mo_chapa VARCHAR(150)NOT NULL,
		mo_detailing VARCHAR(150)NOT NULL,
		mo_mecanica VARCHAR(150)NOT NULL,
		mo_otros_servicios VARCHAR(150)NOT NULL,
		valor DOUBLE NOT NULL,

		PRIMARY KEY (id_presupuesto),

		 CONSTRAINT fk_repuestos_presupuesto
		 FOREIGN KEY (id_repuestos)
        REFERENCES repuestos(id_repuestos)
        );

		)

    CREATE TABLE IF NOT EXISTS cotizacion(
    id_cotizacion INT NOT NULL AUTO_INCREMENT,
    id_cliente INT NOT NULL,
	fecha date NOT NULL,
	id_presupuesto INT NOT NULL,
	valor_neto DOUBLE NOT NULL,
	iva DOUBLE NOT NULL,
	valor_total DOUBLE NOT NULL,
	tipo_pago VARCHAR(50) NOT NULL,
	observaciones VARCHAR(120) NOT NULL,


    PRIMARY KEY (id_cotizacion),

    CONSTRAINT fk_cliente_cotizacion
	FOREIGN KEY (id_cliente)
     REFERENCES cliente (id_cliente) ,


	 CONSTRAINT fk_presupuesto_cotizacion,
	FOREIGN KEY (id_presupuesto)
        REFERENCES presupuesto (id_presupuesto)

        );

	 CREATE TABLE IF NOT EXISTS orden_de_trabajo(
	 id_orden_de_trabajo INT NOT NULL AUTO_INCREMENT,
    id_cotizacion INT NOT NULL ,
	fecha_de_inicio DATE NOT NULL,
	fecha_de_termino DATE NOT NULL,
	fecha_de_entrega DATE NOT NULL,
	id_colaborador INT NOT NULL,
	detalle  VARCHAR(120) NOT NULL,
	valor_final DOUBLE NOT NULL,

    PRIMARY KEY (id_orden_de_trabajo),

    CONSTRAINT fk_cotizacion_orden_de_trabajo
	FOREIGN KEY (id_cotizacion)
     REFERENCES cotizacion(id_cotizacion),

        );



		recursos disponibles

INSERT INTO taller_version2.resource (id_resource, name) VALUES ('1', 'crear');
INSERT INTO taller_version2.resource (id_resource, name) VALUES ('2', 'actualizar');
INSERT INTO taller_version2.resource (id_resource, name) VALUES ('3', 'consultar');
INSERT INTO taller_version2.resource (id_resource, name) VALUES ('4', 'borrar');

insertar usuario


insertar rol por usuario
INSERT INTO taller_version2.user_role (id_user, id_rol) VALUES (5, 1);
INSERT INTO taller_version2.user_role (id_user, id_rol) VALUES (6, 2);
INSERT INTO taller_version2.user_role (id_user, id_rol) VALUES (8, 3);


		rol por recursos

		INSERT INTO aerolinea.role_resource (id_rol, id_resource) VALUES (1, 1);
      INSERT INTO aerolinea.role_resource (id_rol, id_resource) VALUES (1, 2);
       INSERT INTO aerolinea.role_resource (id_rol, id_resource) VALUES (1, 3);


	   quien puede hacer que cosa

INSERT INTO taller_version2.role_resource (id_rol, id_resource) VALUES (1, 1);
INSERT INTO taller_version2.role_resource (id_rol, id_resource) VALUES (1, 2);
INSERT INTO taller_version2.role_resource (id_rol, id_resource) VALUES (1, 3);
INSERT INTO taller_version2.role_resource (id_rol, id_resource) VALUES (1, 4);
INSERT INTO taller_version2.role_resource (id_rol, id_resource) VALUES (2, 1);
INSERT INTO taller_version2.role_resource (id_rol, id_resource) VALUES (2, 2);
INSERT INTO taller_version2.role_resource (id_rol, id_resource) VALUES (2, 3);
INSERT INTO taller_version2.role_resource (id_rol, id_resource) VALUES (3, 3);
