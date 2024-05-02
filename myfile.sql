DROP DATABASE IF EXISTS pruebas1;
DROP DATABASE IF EXISTS pruebas1;
CREATE DATABASE pruebas1
 WITH
 OWNER = pruebas1
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
 OWNER TO pruebas1;
GRANT insert, select, update, delete ON TABLE estado TO pruebas_admin;
GRANT select ON TABLE estado TO pruebas_client;

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
 OWNER TO pruebas1;
GRANT insert, select, update, delete ON TABLE pais TO pruebas_admin;
GRANT select ON TABLE pais TO pruebas_client;

DROP TABLE IF EXISTS public.departamento;
CREATE TABLE IF NOT EXISTS public.departamento (
	id serial,
	nombre character varying (25),
	pais int,
	codigo int,
	acronimo character varying (3),
CONSTRAINT departamento_pkey PRIMARY KEY (id),
CONSTRAINT departamento_pais_id_fkey FOREIGN KEY (pais)
	REFERENCES public.pais (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
)
WITH (
OIDS=FALSE
);
ALTER TABLE IF EXISTS public.departamento
 OWNER TO pruebas1;
GRANT insert, select, update, delete ON TABLE departamento TO pruebas_admin;
GRANT select ON TABLE departamento TO pruebas_client;

DROP TABLE IF EXISTS public.municipio;
CREATE TABLE IF NOT EXISTS public.municipio (
	id serial,
	nombre character varying (25),
	departamento int,
	codigo character varying (10),
	acronimo character varying (3),
CONSTRAINT municipio_pkey PRIMARY KEY (id),
CONSTRAINT municipio_departamento_id_fkey FOREIGN KEY (departamento)
	REFERENCES public.departamento (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
)
WITH (
OIDS=FALSE
);
ALTER TABLE IF EXISTS public.municipio
 OWNER TO pruebas1;
GRANT insert, select, update, delete ON TABLE municipio TO pruebas_admin;
GRANT select ON TABLE municipio TO pruebas_client;

DROP TABLE IF EXISTS public.tipoentidad;
CREATE TABLE IF NOT EXISTS public.tipoentidad (
	id serial,
	nombre character varying (50),
	estado int,
CONSTRAINT tipoentidad_pkey PRIMARY KEY (id),
CONSTRAINT tipoentidad_estado_id_fkey FOREIGN KEY (estado)
	REFERENCES public.estado (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
)
WITH (
OIDS=FALSE
);
ALTER TABLE IF EXISTS public.tipoentidad
 OWNER TO pruebas1;
GRANT insert, select, update, delete ON TABLE tipoentidad TO pruebas_admin;
GRANT select ON TABLE tipoentidad TO pruebas_client;

DROP TABLE IF EXISTS public.entidad;
CREATE TABLE IF NOT EXISTS public.entidad (
	id serial,
	nombre character varying (50),
	municipio int,
	codigo character varying (10),
	tipoentidad int,
	estado int,
	comuna character varying (50),
	geolocalizacion character varying (100),
CONSTRAINT entidad_pkey PRIMARY KEY (id),
CONSTRAINT entidad_municipio_id_fkey FOREIGN KEY (municipio)
	REFERENCES public.municipio (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION,
CONSTRAINT entidad_tipoentidad_id_fkey FOREIGN KEY (tipoentidad)
	REFERENCES public.tipoentidad (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION,
CONSTRAINT entidad_estado_id_fkey FOREIGN KEY (estado)
	REFERENCES public.estado (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
)
WITH (
OIDS=FALSE
);
ALTER TABLE IF EXISTS public.entidad
 OWNER TO pruebas1;
GRANT insert, select, update, delete ON TABLE entidad TO pruebas_admin;
GRANT select ON TABLE entidad TO pruebas_client;

DROP TABLE IF EXISTS public.perfil;
CREATE TABLE IF NOT EXISTS public.perfil (
	id serial,
	nombre character varying (100),
	descripcion character varying (255),
	estado int,
	codigo character varying (20),
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
 OWNER TO pruebas1;
GRANT insert, select, update, delete ON TABLE perfil TO pruebas_admin;
GRANT select ON TABLE perfil TO pruebas_client;

DROP TABLE IF EXISTS public.tipo_identificacion;
CREATE TABLE IF NOT EXISTS public.tipo_identificacion (
	id serial,
	nombre character varying (100),
CONSTRAINT tipo_identificacion_pkey PRIMARY KEY (id)
)
WITH (
OIDS=FALSE
);
ALTER TABLE IF EXISTS public.tipo_identificacion
 OWNER TO pruebas1;
GRANT insert, select, update, delete ON TABLE tipo_identificacion TO pruebas_admin;
GRANT select ON TABLE tipo_identificacion TO pruebas_client;

DROP TABLE IF EXISTS public.persona;
CREATE TABLE IF NOT EXISTS public.persona (
	id serial,
	nombre character varying (50),
	apellido character varying (50),
	tipo_identificacion int,
	num_identificacion character varying (20),
	genero character,
	fecha_nacimiento date,
	email character varying (255),
	direccion character varying (255),
	celular character varying (10),
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
 OWNER TO pruebas1;
GRANT insert, select, update, delete ON TABLE persona TO pruebas_admin;
GRANT select ON TABLE persona TO pruebas_client;

DROP TABLE IF EXISTS public.usuario;
CREATE TABLE IF NOT EXISTS public.usuario (
	id serial,
	login_username character varying (50),
	persona int,
	estado int,
CONSTRAINT usuario_pkey PRIMARY KEY (id),
CONSTRAINT usuario_persona_id_fkey FOREIGN KEY (persona)
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
 OWNER TO pruebas1;
GRANT insert, select, update, delete ON TABLE usuario TO pruebas_admin;
GRANT select ON TABLE usuario TO pruebas_client;

DROP TABLE IF EXISTS public.usuario_perfil;
CREATE TABLE IF NOT EXISTS public.usuario_perfil (
	id serial,
	usuario int,
	perfil int,
	estado int,
CONSTRAINT usuario_perfil_pkey PRIMARY KEY (id),
CONSTRAINT usuario_perfil_usuario_id_fkey FOREIGN KEY (usuario)
	REFERENCES public.usuario (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION,
CONSTRAINT usuario_perfil_perfil_id_fkey FOREIGN KEY (perfil)
	REFERENCES public.perfil (id) MATCH SIMPLE
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
 OWNER TO pruebas1;
GRANT insert, select, update, delete ON TABLE usuario_perfil TO pruebas_admin;
GRANT select ON TABLE usuario_perfil TO pruebas_client;

DROP TABLE IF EXISTS public.sesion;
CREATE TABLE IF NOT EXISTS public.sesion (
	id serial,
	usuario int,
	fecha_hora_start timestamp,
	fecha_hora_end timestamp,
	ip character varying (100),
CONSTRAINT sesion_pkey PRIMARY KEY (id),
CONSTRAINT sesion_usuario_id_fkey FOREIGN KEY (usuario)
	REFERENCES public.usuario (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
)
WITH (
OIDS=FALSE
);
ALTER TABLE IF EXISTS public.sesion
 OWNER TO pruebas1;
GRANT insert, select, update, delete ON TABLE sesion TO pruebas_admin;
GRANT select ON TABLE sesion TO pruebas_client;

DROP TABLE IF EXISTS public.modulo;
CREATE TABLE IF NOT EXISTS public.modulo (
	id serial,
	nombre character varying (50),
	descripcion character varying (100),
	estado int,
	url character varying (255),
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
 OWNER TO pruebas1;
GRANT insert, select, update, delete ON TABLE modulo TO pruebas_admin;
GRANT select ON TABLE modulo TO pruebas_client;

DROP TABLE IF EXISTS public.tipo_permiso;
CREATE TABLE IF NOT EXISTS public.tipo_permiso (
	id serial,
	nombre character varying (10),
CONSTRAINT tipo_permiso_pkey PRIMARY KEY (id)
)
WITH (
OIDS=FALSE
);
ALTER TABLE IF EXISTS public.tipo_permiso
 OWNER TO pruebas1;
GRANT insert, select, update, delete ON TABLE tipo_permiso TO pruebas_admin;
GRANT select ON TABLE tipo_permiso TO pruebas_client;

DROP TABLE IF EXISTS public.permisos;
CREATE TABLE IF NOT EXISTS public.permisos (
	id serial,
	perfil int,
	modulo int,
	tipo_permiso int,
CONSTRAINT permisos_pkey PRIMARY KEY (id),
CONSTRAINT permisos_perfil_id_fkey FOREIGN KEY (perfil)
	REFERENCES public.perfil (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION,
CONSTRAINT permisos_modulo_id_fkey FOREIGN KEY (modulo)
	REFERENCES public.modulo (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION,
CONSTRAINT permisos_tipo_permiso_id_fkey FOREIGN KEY (tipo_permiso)
	REFERENCES public.tipo_permiso (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
)
WITH (
OIDS=FALSE
);
ALTER TABLE IF EXISTS public.permisos
 OWNER TO pruebas1;
GRANT insert, select, update, delete ON TABLE permisos TO pruebas_admin;
GRANT select ON TABLE permisos TO pruebas_client;

DROP TABLE IF EXISTS public.panelcontrol;
CREATE TABLE IF NOT EXISTS public.panelcontrol (
	id serial,
	nombre character varying (100),
	descripcion character varying (255),
	estado int,
CONSTRAINT panelcontrol_pkey PRIMARY KEY (id),
CONSTRAINT panelcontrol_estado_id_fkey FOREIGN KEY (estado)
	REFERENCES public.estado (id) MATCH SIMPLE
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
)
WITH (
OIDS=FALSE
);
ALTER TABLE IF EXISTS public.panelcontrol
 OWNER TO pruebas1;
GRANT insert, select, update, delete ON TABLE panelcontrol TO pruebas_admin;
GRANT select ON TABLE panelcontrol TO pruebas_client;

DROP TABLE IF EXISTS public.panelcontrol_menu;
CREATE TABLE IF NOT EXISTS public.panelcontrol_menu (
	id serial,
	nombre character varying (100),
CONSTRAINT panelcontrol_menu_pkey PRIMARY KEY (id)
)
WITH (
OIDS=FALSE
);
ALTER TABLE IF EXISTS public.panelcontrol_menu
 OWNER TO pruebas1;
GRANT insert, select, update, delete ON TABLE panelcontrol_menu TO pruebas_admin;
GRANT select ON TABLE panelcontrol_menu TO pruebas_client;
