DROP DATABASE IF EXISTS agro;
DROP DATABASE IF EXISTS agro;
CREATE DATABASE agro
 WITH
 OWNER = agro
 ENCODING = 'UTF8'
 TABLESPACE = pg_default
 CONNECTION LIMIT = -1;

DROP TABLE IF EXISTS public.estado;
CREATE TABLE IF NOT EXISTS public.estado (
	id serial,
	nombre character varying (100),
	descripcion character varying (255),
CONSTRAINT estado_pkey PRIMARY KEY (id)
)
WITH (
OIDS=FALSE
);
ALTER TABLE IF EXISTS public.estado
 OWNER TO agro;
GRANT insert, select, update, delete ON TABLE estado TO agro_admin;
GRANT select ON TABLE estado TO agro_client;

DROP TABLE IF EXISTS public.pais;
CREATE TABLE IF NOT EXISTS public.pais (
	id serial,
	nombre character varying (25),
	codigo int,
	acronimo character varying (3),
CONSTRAINT pais_pkey PRIMARY KEY (id)
)
WITH (
OIDS=FALSE
);
ALTER TABLE IF EXISTS public.pais
 OWNER TO agro;
GRANT insert, select, update, delete ON TABLE pais TO agro_admin;
GRANT select ON TABLE pais TO agro_client;

DROP TABLE IF EXISTS public.departamento;
CREATE TABLE IF NOT EXISTS public.departamento (
	id serial,
	nombre character varying (25),
	pais_id int,
	codigo int,
	acronimo character varying (3),
CONSTRAINT departamento_pkey PRIMARY KEY (id),
CONSTRAINT departamento_pais_id_fkey FOREIGN KEY (pais_id)
	REFERENCES public.pais (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
)
WITH (
OIDS=FALSE
);
ALTER TABLE IF EXISTS public.departamento
 OWNER TO agro;
GRANT insert, select, update, delete ON TABLE departamento TO agro_admin;
GRANT select ON TABLE departamento TO agro_client;

DROP TABLE IF EXISTS public.municipio;
CREATE TABLE IF NOT EXISTS public.municipio (
	id serial,
	nombre character varying (25),
	departamento_id int,
	codigo int,
	acronimo character varying (3),
CONSTRAINT municipio_pkey PRIMARY KEY (id),
CONSTRAINT municipio_departamento_id_fkey FOREIGN KEY (departamento_id)
	REFERENCES public.departamento (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
)
WITH (
OIDS=FALSE
);
ALTER TABLE IF EXISTS public.municipio
 OWNER TO agro;
GRANT insert, select, update, delete ON TABLE municipio TO agro_admin;
GRANT select ON TABLE municipio TO agro_client;

DROP TABLE IF EXISTS public.tipo_identificacion;
CREATE TABLE IF NOT EXISTS public.tipo_identificacion (
	id serial,
	nombre character varying (100),
	descripcion character varying (255),
	estado_id int,
CONSTRAINT tipo_identificacion_pkey PRIMARY KEY (id),
CONSTRAINT tipo_identificacion_estado_id_fkey FOREIGN KEY (estado_id)
	REFERENCES public.estado (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
)
WITH (
OIDS=FALSE
);
ALTER TABLE IF EXISTS public.tipo_identificacion
 OWNER TO agro;
GRANT insert, select, update, delete ON TABLE tipo_identificacion TO agro_admin;
GRANT select ON TABLE tipo_identificacion TO agro_client;

DROP TABLE IF EXISTS public.persona;
CREATE TABLE IF NOT EXISTS public.persona (
	id serial,
	tipo_identificacion int,
<<<<<<< HEAD
	num_identificacion character varying (20),
	genero boolean,
=======
	identificacion character varying (20),
	nombre character varying (100),
	apellido character varying (100),
	genero character,
>>>>>>> 9f28555 (v1)
	fecha_nacimiento date,
	estrato int,
	direccion character varying (255),
	email_personal character varying (100),
	celular int,
	estado int,
CONSTRAINT persona_pkey PRIMARY KEY (id),
CONSTRAINT persona_tipo_identificacion_id_fkey FOREIGN KEY (tipo_identificacion)
	REFERENCES public.tipo_identificacion (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION,
CONSTRAINT persona_estado_id_fkey FOREIGN KEY (estado)
	REFERENCES public.estado (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
)
WITH (
OIDS=FALSE
);
ALTER TABLE IF EXISTS public.persona
 OWNER TO agro;
GRANT insert, select, update, delete ON TABLE persona TO agro_admin;
GRANT select ON TABLE persona TO agro_client;

DROP TABLE IF EXISTS public.usuario;
CREATE TABLE IF NOT EXISTS public.usuario (
	id serial,
	persona_id int,
	email character varying (100),
	password character varying (255),
	estado int,
CONSTRAINT usuario_pkey PRIMARY KEY (id),
CONSTRAINT usuario_persona_id_fkey FOREIGN KEY (persona_id)
	REFERENCES public.persona (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION,
CONSTRAINT usuario_estado_id_fkey FOREIGN KEY (estado)
	REFERENCES public.estado (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
)
WITH (
OIDS=FALSE
);
ALTER TABLE IF EXISTS public.usuario
 OWNER TO agro;
GRANT insert, select, update, delete ON TABLE usuario TO agro_admin;
GRANT select ON TABLE usuario TO agro_client;

DROP TABLE IF EXISTS public.perfil;
CREATE TABLE IF NOT EXISTS public.perfil (
	id serial,
	nombre character varying (100),
	descripcion character varying (255),
	estado int,
CONSTRAINT perfil_pkey PRIMARY KEY (id),
CONSTRAINT perfil_estado_id_fkey FOREIGN KEY (estado)
	REFERENCES public.estado (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
)
WITH (
OIDS=FALSE
);
ALTER TABLE IF EXISTS public.perfil
 OWNER TO agro;
GRANT insert, select, update, delete ON TABLE perfil TO agro_admin;
GRANT select ON TABLE perfil TO agro_client;

DROP TABLE IF EXISTS public.usuario_perfil;
CREATE TABLE IF NOT EXISTS public.usuario_perfil (
	id serial,
	usuario_id int,
	perfil_id int,
	estado int,
CONSTRAINT usuario_perfil_pkey PRIMARY KEY (id),
CONSTRAINT usuario_perfil_usuario_id_fkey FOREIGN KEY (usuario_id)
	REFERENCES public.usuario (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION,
CONSTRAINT usuario_perfil_perfil_Id_fkey FOREIGN KEY (perfil_id)
	REFERENCES public.perfil (Id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION,
CONSTRAINT usuario_perfil_estado_id_fkey FOREIGN KEY (estado)
	REFERENCES public.estado (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
)
WITH (
OIDS=FALSE
);
ALTER TABLE IF EXISTS public.usuario_perfil
 OWNER TO agro;
GRANT insert, select, update, delete ON TABLE usuario_perfil TO agro_admin;
GRANT select ON TABLE usuario_perfil TO agro_client;

DROP TABLE IF EXISTS public.modulo;
CREATE TABLE IF NOT EXISTS public.modulo (
	id serial,
	nombre character varying (100),
	url character varying (255),
	descripcion character varying (255),
	estado int,
CONSTRAINT modulo_pkey PRIMARY KEY (id),
CONSTRAINT modulo_estado_id_fkey FOREIGN KEY (estado)
	REFERENCES public.estado (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
)
WITH (
OIDS=FALSE
);
ALTER TABLE IF EXISTS public.modulo
 OWNER TO agro;
GRANT insert, select, update, delete ON TABLE modulo TO agro_admin;
GRANT select ON TABLE modulo TO agro_client;

DROP TABLE IF EXISTS public.metodo;
CREATE TABLE IF NOT EXISTS public.metodo (
	id serial,
	nombre character varying (100),
	descripcion character varying (255),
	estado int,
CONSTRAINT metodo_pkey PRIMARY KEY (id),
CONSTRAINT metodo_estado_id_fkey FOREIGN KEY (estado)
	REFERENCES public.estado (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
)
WITH (
OIDS=FALSE
);
ALTER TABLE IF EXISTS public.metodo
 OWNER TO agro;
GRANT insert, select, update, delete ON TABLE metodo TO agro_admin;
GRANT select ON TABLE metodo TO agro_client;

DROP TABLE IF EXISTS public.modulo_metodo;
CREATE TABLE IF NOT EXISTS public.modulo_metodo (
	id serial,
	modulo_id int,
	metodo_id int,
	uri character varying (255),
	estado int,
CONSTRAINT modulo_metodo_pkey PRIMARY KEY (id),
CONSTRAINT modulo_metodo_modulo_id_fkey FOREIGN KEY (modulo_id)
	REFERENCES public.modulo (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION,
CONSTRAINT modulo_metodo_metodo_id_fkey FOREIGN KEY (metodo_id)
	REFERENCES public.metodo (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION,
CONSTRAINT modulo_metodo_estado_id_fkey FOREIGN KEY (estado)
	REFERENCES public.estado (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
)
WITH (
OIDS=FALSE
);
ALTER TABLE IF EXISTS public.modulo_metodo
 OWNER TO agro;
GRANT insert, select, update, delete ON TABLE modulo_metodo TO agro_admin;
GRANT select ON TABLE modulo_metodo TO agro_client;

DROP TABLE IF EXISTS public.permisos;
CREATE TABLE IF NOT EXISTS public.permisos (
	id serial,
	modulo_metodo_id int,
	rol character varying (50),
	metodo_id int,
CONSTRAINT permisos_pkey PRIMARY KEY (id),
CONSTRAINT permisos_modulo_metodo_id_fkey FOREIGN KEY (modulo_metodo_id)
	REFERENCES public.modulo_metodo (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION,
CONSTRAINT permisos_metodo_id_fkey FOREIGN KEY (metodo_id)
	REFERENCES public.metodo (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
)
WITH (
OIDS=FALSE
);
ALTER TABLE IF EXISTS public.permisos
 OWNER TO agro;
GRANT insert, select, update, delete ON TABLE permisos TO agro_admin;
GRANT select ON TABLE permisos TO agro_client;

DROP TABLE IF EXISTS public.sesion;
CREATE TABLE IF NOT EXISTS public.sesion (
	id serial,
	usuario_id int,
	fecha_hora_start timestamp,
	fecha_hora_end timestamp,
	direccion_ip character varying (50),
CONSTRAINT sesion_pkey PRIMARY KEY (id),
CONSTRAINT sesion_usuario_id_fkey FOREIGN KEY (usuario_id)
	REFERENCES public.usuario (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
)
WITH (
OIDS=FALSE
);
ALTER TABLE IF EXISTS public.sesion
 OWNER TO agro;
GRANT insert, select, update, delete ON TABLE sesion TO agro_admin;
GRANT select ON TABLE sesion TO agro_client;

DROP TABLE IF EXISTS public.empresa;
CREATE TABLE IF NOT EXISTS public.empresa (
	id serial,
	tipo_identificacion int,
	identificacion int,
	nombre character varying (100),
	descripcion character varying (255),
	estado int,
CONSTRAINT empresa_pkey PRIMARY KEY (id),
CONSTRAINT empresa_tipo_identificacion_id_fkey FOREIGN KEY (tipo_identificacion)
	REFERENCES public.tipo_identificacion (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION,
CONSTRAINT empresa_estado_id_fkey FOREIGN KEY (estado)
	REFERENCES public.estado (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
)
WITH (
OIDS=FALSE
);
ALTER TABLE IF EXISTS public.empresa
 OWNER TO agro;
GRANT insert, select, update, delete ON TABLE empresa TO agro_admin;
GRANT select ON TABLE empresa TO agro_client;

DROP TABLE IF EXISTS public.grupo;
CREATE TABLE IF NOT EXISTS public.grupo (
	id serial,
	nombre character varying (100),
	empresa_id int,
	descripcion character varying (255),
	estado int,
CONSTRAINT grupo_pkey PRIMARY KEY (id),
CONSTRAINT grupo_empresa_id_fkey FOREIGN KEY (empresa_id)
	REFERENCES public.empresa (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION,
CONSTRAINT grupo_estado_id_fkey FOREIGN KEY (estado)
	REFERENCES public.estado (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
)
WITH (
OIDS=FALSE
);
ALTER TABLE IF EXISTS public.grupo
 OWNER TO agro;
GRANT insert, select, update, delete ON TABLE grupo TO agro_admin;
GRANT select ON TABLE grupo TO agro_client;

DROP TABLE IF EXISTS public.tipo_sede;
CREATE TABLE IF NOT EXISTS public.tipo_sede (
	id serial,
	nombre character varying (100),
	descripcion character varying (255),
	estado int,
CONSTRAINT tipo_sede_pkey PRIMARY KEY (id),
CONSTRAINT tipo_sede_estado_id_fkey FOREIGN KEY (estado)
	REFERENCES public.estado (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
)
WITH (
OIDS=FALSE
);
ALTER TABLE IF EXISTS public.tipo_sede
 OWNER TO agro;
GRANT insert, select, update, delete ON TABLE tipo_sede TO agro_admin;
GRANT select ON TABLE tipo_sede TO agro_client;

DROP TABLE IF EXISTS public.sede;
CREATE TABLE IF NOT EXISTS public.sede (
	id serial,
	grupo_id int,
	tipo_sede_id int,
	nombre character varying (100),
	municipio_id int,
	geolocalizacion character varying (255),
	coordenadas character varying (255),
	area double precision,
	comuna character varying (100),
	descripcion character varying (255),
	estado int,
CONSTRAINT sede_pkey PRIMARY KEY (id),
CONSTRAINT sede_grupo_id_fkey FOREIGN KEY (grupo_id)
	REFERENCES public.grupo (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION,
CONSTRAINT sede_tipo_sede_id_fkey FOREIGN KEY (tipo_sede_id)
	REFERENCES public.tipo_sede (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION,
CONSTRAINT sede_estado_id_fkey FOREIGN KEY (estado)
	REFERENCES public.estado (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
)
WITH (
OIDS=FALSE
);
ALTER TABLE IF EXISTS public.sede
 OWNER TO agro;
GRANT insert, select, update, delete ON TABLE sede TO agro_admin;
GRANT select ON TABLE sede TO agro_client;

DROP TABLE IF EXISTS public.tipo_bloque;
CREATE TABLE IF NOT EXISTS public.tipo_bloque (
	id serial,
	nombre character varying (100),
	descripcion character varying (255),
	estado int,
CONSTRAINT tipo_bloque_pkey PRIMARY KEY (id),
CONSTRAINT tipo_bloque_estado_id_fkey FOREIGN KEY (estado)
	REFERENCES public.estado (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
)
WITH (
OIDS=FALSE
);
ALTER TABLE IF EXISTS public.tipo_bloque
 OWNER TO agro;
GRANT insert, select, update, delete ON TABLE tipo_bloque TO agro_admin;
GRANT select ON TABLE tipo_bloque TO agro_client;

DROP TABLE IF EXISTS public.bloque;
CREATE TABLE IF NOT EXISTS public.bloque (
	id serial,
	sede_id int,
	tipo_bloque_id int,
	nombre character varying (100),
	geolocalizacion character varying (255),
	coordenadas character varying (255),
	numero_pisos int,
	descripcion character varying (255),
	estado int,
CONSTRAINT bloque_pkey PRIMARY KEY (id),
CONSTRAINT bloque_sede_id_fkey FOREIGN KEY (sede_id)
	REFERENCES public.sede (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION,
CONSTRAINT bloque_tipo_bloque_id_fkey FOREIGN KEY (tipo_bloque_id)
	REFERENCES public.tipo_bloque (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION,
CONSTRAINT bloque_estado_id_fkey FOREIGN KEY (estado)
	REFERENCES public.estado (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
)
WITH (
OIDS=FALSE
);
ALTER TABLE IF EXISTS public.bloque
 OWNER TO agro;
GRANT insert, select, update, delete ON TABLE bloque TO agro_admin;
GRANT select ON TABLE bloque TO agro_client;

DROP TABLE IF EXISTS public.tipo_espacio;
CREATE TABLE IF NOT EXISTS public.tipo_espacio (
	id serial,
	nombre character varying (100),
	descripcion character varying (255),
	estado int,
CONSTRAINT tipo_espacio_pkey PRIMARY KEY (id),
CONSTRAINT tipo_espacio_estado_id_fkey FOREIGN KEY (estado)
	REFERENCES public.estado (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
)
WITH (
OIDS=FALSE
);
ALTER TABLE IF EXISTS public.tipo_espacio
 OWNER TO agro;
GRANT insert, select, update, delete ON TABLE tipo_espacio TO agro_admin;
GRANT select ON TABLE tipo_espacio TO agro_client;

DROP TABLE IF EXISTS public.espacio;
CREATE TABLE IF NOT EXISTS public.espacio (
	id serial,
	bloque_id int,
	tipo_espacio_id int,
	nombre character varying (100),
	geolocacizacion character varying (255),
	coordenadas character varying (255),
	descripcion character varying (255),
	estado int,
CONSTRAINT espacio_pkey PRIMARY KEY (id),
CONSTRAINT espacio_bloque_id_fkey FOREIGN KEY (bloque_id)
	REFERENCES public.bloque (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION,
CONSTRAINT espacio_tipo_espacio_id_fkey FOREIGN KEY (tipo_espacio_id)
	REFERENCES public.tipo_espacio (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION,
CONSTRAINT espacio_estado_id_fkey FOREIGN KEY (estado)
	REFERENCES public.estado (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
)
WITH (
OIDS=FALSE
);
ALTER TABLE IF EXISTS public.espacio
 OWNER TO agro;
GRANT insert, select, update, delete ON TABLE espacio TO agro_admin;
GRANT select ON TABLE espacio TO agro_client;

DROP TABLE IF EXISTS public.categoria_actividad;
CREATE TABLE IF NOT EXISTS public.categoria_actividad (
	id serial,
	nombre character varying (100),
	descripcion character varying (255),
	estado int,
CONSTRAINT categoria_actividad_pkey PRIMARY KEY (id),
CONSTRAINT categoria_actividad_estado_id_fkey FOREIGN KEY (estado)
	REFERENCES public.estado (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
)
WITH (
OIDS=FALSE
);
ALTER TABLE IF EXISTS public.categoria_actividad
 OWNER TO agro;
GRANT insert, select, update, delete ON TABLE categoria_actividad TO agro_admin;
GRANT select ON TABLE categoria_actividad TO agro_client;

DROP TABLE IF EXISTS public.tipo_actividad;
CREATE TABLE IF NOT EXISTS public.tipo_actividad (
	id serial,
	categoria_actividad_id int,
	nombre character varying (100),
	descripcion character varying (255),
	estado int,
CONSTRAINT tipo_actividad_pkey PRIMARY KEY (id),
CONSTRAINT tipo_actividad_categoria_actividad_id_fkey FOREIGN KEY (categoria_actividad_id)
	REFERENCES public.categoria_actividad (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION,
CONSTRAINT tipo_actividad_estado_id_fkey FOREIGN KEY (estado)
	REFERENCES public.estado (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
)
WITH (
OIDS=FALSE
);
ALTER TABLE IF EXISTS public.tipo_actividad
 OWNER TO agro;
GRANT insert, select, update, delete ON TABLE tipo_actividad TO agro_admin;
GRANT select ON TABLE tipo_actividad TO agro_client;

DROP TABLE IF EXISTS public.actividad_ocupacion;
CREATE TABLE IF NOT EXISTS public.actividad_ocupacion (
	id serial,
	nombre character varying (100),
	tipo_actividad_id int,
	evaluacion character varying (255),
CONSTRAINT actividad_ocupacion_pkey PRIMARY KEY (id),
CONSTRAINT actividad_ocupacion_tipo_actividad_id_fkey FOREIGN KEY (tipo_actividad_id)
	REFERENCES public.tipo_actividad (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
)
WITH (
OIDS=FALSE
);
ALTER TABLE IF EXISTS public.actividad_ocupacion
 OWNER TO agro;
GRANT insert, select, update, delete ON TABLE actividad_ocupacion TO agro_admin;
GRANT select ON TABLE actividad_ocupacion TO agro_client;

DROP TABLE IF EXISTS public.espacio_ocupacion;
CREATE TABLE IF NOT EXISTS public.espacio_ocupacion (
	id serial,
	espacio_id int,
	actividad_ocupacion_id int,
	fecha_inicio date,
	fecha_fin date,
	estado int,
CONSTRAINT espacio_ocupacion_pkey PRIMARY KEY (id),
CONSTRAINT espacio_ocupacion_espacio_id_fkey FOREIGN KEY (espacio_id)
	REFERENCES public.espacio (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION,
CONSTRAINT espacio_ocupacion_actividad_ocupacion_id_fkey FOREIGN KEY (actividad_ocupacion_id)
	REFERENCES public.actividad_ocupacion (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION,
CONSTRAINT espacio_ocupacion_estado_id_fkey FOREIGN KEY (estado)
	REFERENCES public.estado (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
)
WITH (
OIDS=FALSE
);
ALTER TABLE IF EXISTS public.espacio_ocupacion
 OWNER TO agro;
GRANT insert, select, update, delete ON TABLE espacio_ocupacion TO agro_admin;
GRANT select ON TABLE espacio_ocupacion TO agro_client;

DROP TABLE IF EXISTS public.almacen;
CREATE TABLE IF NOT EXISTS public.almacen (
	id serial,
	nombre character varying (100),
	sede_id int,
	geolocalizacion character varying (255),
	coordenadas character varying (255),
	descripcion character varying (255),
	estado int,
CONSTRAINT almacen_pkey PRIMARY KEY (id),
CONSTRAINT almacen_sede_id_fkey FOREIGN KEY (sede_id)
	REFERENCES public.sede (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION,
CONSTRAINT almacen_estado_id_fkey FOREIGN KEY (estado)
	REFERENCES public.estado (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
)
WITH (
OIDS=FALSE
);
ALTER TABLE IF EXISTS public.almacen
 OWNER TO agro;
GRANT insert, select, update, delete ON TABLE almacen TO agro_admin;
GRANT select ON TABLE almacen TO agro_client;

DROP TABLE IF EXISTS public.producto_categoria;
CREATE TABLE IF NOT EXISTS public.producto_categoria (
	id serial,
	nombre character varying (100),
	descripcion character varying (255),
	estado int,
CONSTRAINT producto_categoria_pkey PRIMARY KEY (id),
CONSTRAINT producto_categoria_estado_id_fkey FOREIGN KEY (estado)
	REFERENCES public.estado (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
)
WITH (
OIDS=FALSE
);
ALTER TABLE IF EXISTS public.producto_categoria
 OWNER TO agro;
GRANT insert, select, update, delete ON TABLE producto_categoria TO agro_admin;
GRANT select ON TABLE producto_categoria TO agro_client;

DROP TABLE IF EXISTS public.producto;
CREATE TABLE IF NOT EXISTS public.producto (
	id serial,
	nombre character varying (100),
	producto_categoria_id int,
CONSTRAINT producto_pkey PRIMARY KEY (id),
CONSTRAINT producto_producto_categoria_id_fkey FOREIGN KEY (producto_categoria_id)
	REFERENCES public.producto_categoria (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
)
WITH (
OIDS=FALSE
);
ALTER TABLE IF EXISTS public.producto
 OWNER TO agro;
GRANT insert, select, update, delete ON TABLE producto TO agro_admin;
GRANT select ON TABLE producto TO agro_client;

DROP TABLE IF EXISTS public.producto_presentacion;
CREATE TABLE IF NOT EXISTS public.producto_presentacion (
	id serial,
	producto_id int,
	nombre character varying (100),
	descripcion character varying (255),
	estado int,
CONSTRAINT producto_presentacion_pkey PRIMARY KEY (id),
CONSTRAINT producto_presentacion_producto_id_fkey FOREIGN KEY (producto_id)
	REFERENCES public.producto (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION,
CONSTRAINT producto_presentacion_estado_id_fkey FOREIGN KEY (estado)
	REFERENCES public.estado (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
)
WITH (
OIDS=FALSE
);
ALTER TABLE IF EXISTS public.producto_presentacion
 OWNER TO agro;
GRANT insert, select, update, delete ON TABLE producto_presentacion TO agro_admin;
GRANT select ON TABLE producto_presentacion TO agro_client;

DROP TABLE IF EXISTS public.producto_presentacion;
CREATE TABLE IF NOT EXISTS public.producto_presentacion (
	id serial,
	producto_id int,
	nombre character varying (100),
	descripcion character varying (255),
	estado int,
CONSTRAINT producto_presentacion_pkey PRIMARY KEY (id),
CONSTRAINT producto_presentacion_producto_id_fkey FOREIGN KEY (producto_id)
	REFERENCES public.producto (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION,
CONSTRAINT producto_presentacion_estado_id_fkey FOREIGN KEY (estado)
	REFERENCES public.estado (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
)
WITH (
OIDS=FALSE
);
ALTER TABLE IF EXISTS public.producto_presentacion
 OWNER TO agro;
GRANT insert, select, update, delete ON TABLE producto_presentacion TO agro_admin;
GRANT select ON TABLE producto_presentacion TO agro_client;

DROP TABLE IF EXISTS public.proveedor;
CREATE TABLE IF NOT EXISTS public.proveedor (
	id serial,
	empresa_id int,
	fecha_creacion date,
	estado int,
CONSTRAINT proveedor_pkey PRIMARY KEY (id),
CONSTRAINT proveedor_empresa_id_fkey FOREIGN KEY (empresa_id)
	REFERENCES public.empresa (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION,
CONSTRAINT proveedor_estado_id_fkey FOREIGN KEY (estado)
	REFERENCES public.estado (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
)
WITH (
OIDS=FALSE
);
ALTER TABLE IF EXISTS public.proveedor
 OWNER TO agro;
GRANT insert, select, update, delete ON TABLE proveedor TO agro_admin;
GRANT select ON TABLE proveedor TO agro_client;

DROP TABLE IF EXISTS public.almacen_entrada;
CREATE TABLE IF NOT EXISTS public.almacen_entrada (
	id serial,
	proveedor_id int,
	fecha date,
	descripcion character varying (255),
	estado int,
CONSTRAINT almacen_entrada_pkey PRIMARY KEY (id),
CONSTRAINT almacen_entrada_proveedor_id_fkey FOREIGN KEY (proveedor_id)
	REFERENCES public.proveedor (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION,
CONSTRAINT almacen_entrada_estado_id_fkey FOREIGN KEY (estado)
	REFERENCES public.estado (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
)
WITH (
OIDS=FALSE
);
ALTER TABLE IF EXISTS public.almacen_entrada
 OWNER TO agro;
GRANT insert, select, update, delete ON TABLE almacen_entrada TO agro_admin;
GRANT select ON TABLE almacen_entrada TO agro_client;

DROP TABLE IF EXISTS public.almacen_entrada_item;
CREATE TABLE IF NOT EXISTS public.almacen_entrada_item (
	id serial,
	almacen_entrada_id int,
	producto_id int,
	producto_presentacion_id int,
	cantidad int,
	precio double precision,
	estado int,
CONSTRAINT almacen_entrada_item_pkey PRIMARY KEY (id),
CONSTRAINT almacen_entrada_item_almacen_entrada_id_fkey FOREIGN KEY (almacen_entrada_id)
	REFERENCES public.almacen_entrada (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION,
CONSTRAINT almacen_entrada_item_producto_id_fkey FOREIGN KEY (producto_id)
	REFERENCES public.producto (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION,
CONSTRAINT almacen_entrada_item_producto_presentacion_id_fkey FOREIGN KEY (producto_presentacion_id)
	REFERENCES public.producto_presentacion (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION,
CONSTRAINT almacen_entrada_item_estado_id_fkey FOREIGN KEY (estado)
	REFERENCES public.estado (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
)
WITH (
OIDS=FALSE
);
ALTER TABLE IF EXISTS public.almacen_entrada_item
 OWNER TO agro;
GRANT insert, select, update, delete ON TABLE almacen_entrada_item TO agro_admin;
GRANT select ON TABLE almacen_entrada_item TO agro_client;

DROP TABLE IF EXISTS public.almacen_salida;
CREATE TABLE IF NOT EXISTS public.almacen_salida (
	id serial,
	fecha date,
	empresa_id int,
	almacen_id int,
	descripcion character varying (255),
	estado int,
CONSTRAINT almacen_salida_pkey PRIMARY KEY (id),
CONSTRAINT almacen_salida_empresa_id_fkey FOREIGN KEY (empresa_id)
	REFERENCES public.empresa (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION,
CONSTRAINT almacen_salida_almacen_id_fkey FOREIGN KEY (almacen_id)
	REFERENCES public.almacen (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION,
CONSTRAINT almacen_salida_estado_id_fkey FOREIGN KEY (estado)
	REFERENCES public.estado (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
)
WITH (
OIDS=FALSE
);
ALTER TABLE IF EXISTS public.almacen_salida
 OWNER TO agro;
GRANT insert, select, update, delete ON TABLE almacen_salida TO agro_admin;
GRANT select ON TABLE almacen_salida TO agro_client;

DROP TABLE IF EXISTS public.almacen_salida_item;
CREATE TABLE IF NOT EXISTS public.almacen_salida_item (
	id serial,
	almacen_salida_id int,
	producto_id int,
	producto_presentacion_id int,
	cantidad int,
	precio double precision,
	estado int,
CONSTRAINT almacen_salida_item_pkey PRIMARY KEY (id),
CONSTRAINT almacen_salida_item_almacen_salida_id_fkey FOREIGN KEY (almacen_salida_id)
	REFERENCES public.almacen_salida (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION,
CONSTRAINT almacen_salida_item_producto_id_fkey FOREIGN KEY (producto_id)
	REFERENCES public.producto (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION,
CONSTRAINT almacen_salida_item_producto_presentacion_id_fkey FOREIGN KEY (producto_presentacion_id)
	REFERENCES public.producto_presentacion (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION,
CONSTRAINT almacen_salida_item_estado_id_fkey FOREIGN KEY (estado)
	REFERENCES public.estado (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
)
WITH (
OIDS=FALSE
);
ALTER TABLE IF EXISTS public.almacen_salida_item
 OWNER TO agro;
GRANT insert, select, update, delete ON TABLE almacen_salida_item TO agro_admin;
GRANT select ON TABLE almacen_salida_item TO agro_client;

DROP TABLE IF EXISTS public.espacio_actividad;
CREATE TABLE IF NOT EXISTS public.espacio_actividad (
	id serial,
	espacio_id int,
	tipo_actividad_id int,
	fecha_hora timestamp,
	cantidad int,
	unidad int,
	precio double precision,
	evaluacion character varying (255),
	descripcion character varying (255),
	estado int,
CONSTRAINT espacio_actividad_pkey PRIMARY KEY (id),
CONSTRAINT espacio_actividad_espacio_id_fkey FOREIGN KEY (espacio_id)
	REFERENCES public.espacio (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION,
CONSTRAINT espacio_actividad_tipo_actividad_id_fkey FOREIGN KEY (tipo_actividad_id)
	REFERENCES public.tipo_actividad (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION,
CONSTRAINT espacio_actividad_estado_id_fkey FOREIGN KEY (estado)
	REFERENCES public.estado (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
)
WITH (
OIDS=FALSE
);
ALTER TABLE IF EXISTS public.espacio_actividad
 OWNER TO agro;
GRANT insert, select, update, delete ON TABLE espacio_actividad TO agro_admin;
GRANT select ON TABLE espacio_actividad TO agro_client;
