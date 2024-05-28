package org.usco.agro.evaluacion;

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
public class EvaluacionController {

	@Autowired
	EvaluacionRepository evaluacionRepository;

	@PostMapping("/evaluacion")
	public ResponseEntity<String> createEvaluacion(@RequestBody Evaluacion evaluacion) {
		try {
			evaluacionRepository.create(
					new Evaluacion(evaluacion.getNombre(), evaluacion.getDescripcion(), evaluacion.getEstado()));
			return new ResponseEntity<>("Evaluacion creado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/evaluacion")
	public ResponseEntity<List<Evaluacion>> getAllEvaluacions() {
		try {
			ArrayList<Evaluacion> evaluacions = new ArrayList<Evaluacion>();

			evaluacionRepository.read().forEach(evaluacions::add);

			if (evaluacions.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(evaluacions, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/evaluacion/{id}")
	public ResponseEntity<String> updateEvaluacion(@PathVariable("id") int id,
			@RequestBody Evaluacion evaluacion) {
		try {
			evaluacionRepository.update(id,
					new Evaluacion(evaluacion.getNombre(), evaluacion.getDescripcion(), evaluacion.getEstado()));
			return new ResponseEntity<>("Evaluacion actualizado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/evaluacion/{id}")
	public ResponseEntity<String> deleteEvaluacion(@PathVariable("id") int id) {
		try {
			evaluacionRepository.delete(id);
			return new ResponseEntity<>("Evaluacion eliminado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
