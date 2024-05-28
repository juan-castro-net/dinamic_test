package org.usco.agro.actividad_ocupacion;

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
public class Actividad_ocupacionController {

	@Autowired
	Actividad_ocupacionRepository actividad_ocupacionRepository;

	@PostMapping("/actividad_ocupacion")
	public ResponseEntity<String> createActividad_ocupacion(@RequestBody Actividad_ocupacion actividad_ocupacion) {
		try {
			actividad_ocupacionRepository.create(
					new Actividad_ocupacion(actividad_ocupacion.getNombre(), actividad_ocupacion.getTipo_actividad_id(), actividad_ocupacion.getEvaluacion()));
			return new ResponseEntity<>("Actividad_ocupacion creado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/actividad_ocupacion")
	public ResponseEntity<List<Actividad_ocupacion>> getAllActividad_ocupacions() {
		try {
			ArrayList<Actividad_ocupacion> actividad_ocupacions = new ArrayList<Actividad_ocupacion>();

			actividad_ocupacionRepository.read().forEach(actividad_ocupacions::add);

			if (actividad_ocupacions.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(actividad_ocupacions, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/actividad_ocupacion/{id}")
	public ResponseEntity<String> updateActividad_ocupacion(@PathVariable("id") int id,
			@RequestBody Actividad_ocupacion actividad_ocupacion) {
		try {
			actividad_ocupacionRepository.update(id,
					new Actividad_ocupacion(actividad_ocupacion.getNombre(), actividad_ocupacion.getTipo_actividad_id(), actividad_ocupacion.getEvaluacion()));
			return new ResponseEntity<>("Actividad_ocupacion actualizado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/actividad_ocupacion/{id}")
	public ResponseEntity<String> deleteActividad_ocupacion(@PathVariable("id") int id) {
		try {
			actividad_ocupacionRepository.delete(id);
			return new ResponseEntity<>("Actividad_ocupacion eliminado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
