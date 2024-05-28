package org.usco.agro.espacio_actividad;

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
public class Espacio_actividadController {

	@Autowired
	Espacio_actividadRepository espacio_actividadRepository;

	@PostMapping("/espacio_actividad")
	public ResponseEntity<String> createEspacio_actividad(@RequestBody Espacio_actividad espacio_actividad) {
		try {
			espacio_actividadRepository.create(
					new Espacio_actividad(espacio_actividad.getEspacio_id(), espacio_actividad.getTipo_actividad_id(), espacio_actividad.getFecha_hora(), espacio_actividad.getCantidad(), espacio_actividad.getUnidad(), espacio_actividad.getPrecio(), espacio_actividad.getEvaluacion(), espacio_actividad.getDescripcion(), espacio_actividad.getEstado()));
			return new ResponseEntity<>("Espacio_actividad creado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/espacio_actividad")
	public ResponseEntity<List<Espacio_actividad>> getAllEspacio_actividads() {
		try {
			ArrayList<Espacio_actividad> espacio_actividads = new ArrayList<Espacio_actividad>();

			espacio_actividadRepository.read().forEach(espacio_actividads::add);

			if (espacio_actividads.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(espacio_actividads, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/espacio_actividad/{id}")
	public ResponseEntity<String> updateEspacio_actividad(@PathVariable("id") int id,
			@RequestBody Espacio_actividad espacio_actividad) {
		try {
			espacio_actividadRepository.update(id,
					new Espacio_actividad(espacio_actividad.getEspacio_id(), espacio_actividad.getTipo_actividad_id(), espacio_actividad.getFecha_hora(), espacio_actividad.getCantidad(), espacio_actividad.getUnidad(), espacio_actividad.getPrecio(), espacio_actividad.getEvaluacion(), espacio_actividad.getDescripcion(), espacio_actividad.getEstado()));
			return new ResponseEntity<>("Espacio_actividad actualizado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/espacio_actividad/{id}")
	public ResponseEntity<String> deleteEspacio_actividad(@PathVariable("id") int id) {
		try {
			espacio_actividadRepository.delete(id);
			return new ResponseEntity<>("Espacio_actividad eliminado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
