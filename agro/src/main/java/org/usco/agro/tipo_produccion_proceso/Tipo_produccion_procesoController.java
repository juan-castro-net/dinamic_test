package org.usco.agro.tipo_produccion_proceso;

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
public class Tipo_produccion_procesoController {

	@Autowired
	Tipo_produccion_procesoRepository tipo_produccion_procesoRepository;

	@PostMapping("/tipo_produccion_proceso")
	public ResponseEntity<String> createTipo_produccion_proceso(@RequestBody Tipo_produccion_proceso tipo_produccion_proceso) {
		try {
			tipo_produccion_procesoRepository.create(
					new Tipo_produccion_proceso(tipo_produccion_proceso.getTipo_produccion_id(), tipo_produccion_proceso.getProceso_id(), tipo_produccion_proceso.getDescripcion(), tipo_produccion_proceso.getEstado()));
			return new ResponseEntity<>("Tipo_produccion_proceso creado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/tipo_produccion_proceso")
	public ResponseEntity<List<Tipo_produccion_proceso>> getAllTipo_produccion_procesos() {
		try {
			ArrayList<Tipo_produccion_proceso> tipo_produccion_procesos = new ArrayList<Tipo_produccion_proceso>();

			tipo_produccion_procesoRepository.read().forEach(tipo_produccion_procesos::add);

			if (tipo_produccion_procesos.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(tipo_produccion_procesos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/tipo_produccion_proceso/{id}")
	public ResponseEntity<String> updateTipo_produccion_proceso(@PathVariable("id") int id,
			@RequestBody Tipo_produccion_proceso tipo_produccion_proceso) {
		try {
			tipo_produccion_procesoRepository.update(id,
					new Tipo_produccion_proceso(tipo_produccion_proceso.getTipo_produccion_id(), tipo_produccion_proceso.getProceso_id(), tipo_produccion_proceso.getDescripcion(), tipo_produccion_proceso.getEstado()));
			return new ResponseEntity<>("Tipo_produccion_proceso actualizado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/tipo_produccion_proceso/{id}")
	public ResponseEntity<String> deleteTipo_produccion_proceso(@PathVariable("id") int id) {
		try {
			tipo_produccion_procesoRepository.delete(id);
			return new ResponseEntity<>("Tipo_produccion_proceso eliminado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
