package org.usco.agro.proceso;

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
public class ProcesoController {

	@Autowired
	ProcesoRepository procesoRepository;

	@PostMapping("/proceso")
	public ResponseEntity<String> createProceso(@RequestBody Proceso proceso) {
		try {
			procesoRepository.create(
					new Proceso(proceso.getTipo_produccion_id(), proceso.getNombre(), proceso.getDescripcion(), proceso.getEstado()));
			return new ResponseEntity<>("Proceso creado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/proceso")
	public ResponseEntity<List<Proceso>> getAllProcesos() {
		try {
			ArrayList<Proceso> procesos = new ArrayList<Proceso>();

			procesoRepository.read().forEach(procesos::add);

			if (procesos.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(procesos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/proceso/{id}")
	public ResponseEntity<String> updateProceso(@PathVariable("id") int id,
			@RequestBody Proceso proceso) {
		try {
			procesoRepository.update(id,
					new Proceso(proceso.getTipo_produccion_id(), proceso.getNombre(), proceso.getDescripcion(), proceso.getEstado()));
			return new ResponseEntity<>("Proceso actualizado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/proceso/{id}")
	public ResponseEntity<String> deleteProceso(@PathVariable("id") int id) {
		try {
			procesoRepository.delete(id);
			return new ResponseEntity<>("Proceso eliminado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
