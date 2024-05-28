package org.usco.agro.almacen_salida;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class Almacen_salidaController {

	@Autowired
	Almacen_salidaRepository almacen_salidaRepository;

	@PostMapping("/almacen_salida")
	public ResponseEntity<String> createAlmacen_salida(@RequestBody Almacen_salida almacen_salida) {
		try {
			almacen_salidaRepository.create(
					new Almacen_salida(almacen_salida.getFecha(), almacen_salida.getEmpresa_id(), almacen_salida.getAlmacen_id(), almacen_salida.getDescripcion(), almacen_salida.getEstado()));
			return new ResponseEntity<>("Almacen_salida creado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/almacen_salida")
	public ResponseEntity<List<Almacen_salida>> getAllAlmacen_salidas() {
		try {
			ArrayList<Almacen_salida> almacen_salidas = new ArrayList<Almacen_salida>();

			almacen_salidaRepository.read().forEach(almacen_salidas::add);

			if (almacen_salidas.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(almacen_salidas, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/almacen_salida/{id}")
	public ResponseEntity<String> updateAlmacen_salida(@PathVariable("id") int id,
			@RequestBody Almacen_salida almacen_salida) {
		try {
			almacen_salidaRepository.update(id,
					new Almacen_salida(almacen_salida.getFecha(), almacen_salida.getEmpresa_id(), almacen_salida.getAlmacen_id(), almacen_salida.getDescripcion(), almacen_salida.getEstado()));
			return new ResponseEntity<>("Almacen_salida actualizado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/almacen_salida/{id}")
	public ResponseEntity<String> deleteAlmacen_salida(@PathVariable("id") int id) {
		try {
			almacen_salidaRepository.delete(id);
			return new ResponseEntity<>("Almacen_salida eliminado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
