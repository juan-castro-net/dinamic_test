package org.usco.agro.tipo_actividad;

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
public class Tipo_actividadController {

	@Autowired
	Tipo_actividadRepository tipo_actividadRepository;

	@PostMapping("/tipo_actividad")
	public ResponseEntity<String> createTipo_actividad(@RequestBody Tipo_actividad tipo_actividad) {
		try {
			tipo_actividadRepository.create(
					new Tipo_actividad(tipo_actividad.getCategoria_actividad_id(), tipo_actividad.getProceso_id(), tipo_actividad.getNombre(), tipo_actividad.getDescripcion(), tipo_actividad.getEstado()));
			return new ResponseEntity<>("Tipo_actividad creado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/tipo_actividad")
	public ResponseEntity<List<Tipo_actividad>> getAllTipo_actividads() {
		try {
			ArrayList<Tipo_actividad> tipo_actividads = new ArrayList<Tipo_actividad>();

			tipo_actividadRepository.read().forEach(tipo_actividads::add);

			if (tipo_actividads.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(tipo_actividads, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/tipo_actividad/{id}")
	public ResponseEntity<String> updateTipo_actividad(@PathVariable("id") int id,
			@RequestBody Tipo_actividad tipo_actividad) {
		try {
			tipo_actividadRepository.update(id,
					new Tipo_actividad(tipo_actividad.getCategoria_actividad_id(), tipo_actividad.getProceso_id(), tipo_actividad.getNombre(), tipo_actividad.getDescripcion(), tipo_actividad.getEstado()));
			return new ResponseEntity<>("Tipo_actividad actualizado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/tipo_actividad/{id}")
	public ResponseEntity<String> deleteTipo_actividad(@PathVariable("id") int id) {
		try {
			tipo_actividadRepository.delete(id);
			return new ResponseEntity<>("Tipo_actividad eliminado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
