package org.usco.agro.actividad_programacion;

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
public class Actividad_programacionController {

	@Autowired
	Actividad_programacionRepository actividad_programacionRepository;

	@PostMapping("/actividad_programacion")
	public ResponseEntity<String> createActividad_programacion(@RequestBody Actividad_programacion actividad_programacion) {
		try {
			actividad_programacionRepository.create(
					new Actividad_programacion(actividad_programacion.getNombre(), actividad_programacion.getFecha_inicio(), actividad_programacion.getFecha_fin(), actividad_programacion.getTipo_produccion_proceso_id(), actividad_programacion.getDescripcion(), actividad_programacion.getEstado()));
			return new ResponseEntity<>("Actividad_programacion creado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/actividad_programacion")
	public ResponseEntity<List<Actividad_programacion>> getAllActividad_programacions() {
		try {
			ArrayList<Actividad_programacion> actividad_programacions = new ArrayList<Actividad_programacion>();

			actividad_programacionRepository.read().forEach(actividad_programacions::add);

			if (actividad_programacions.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(actividad_programacions, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/actividad_programacion/{id}")
	public ResponseEntity<String> updateActividad_programacion(@PathVariable("id") int id,
			@RequestBody Actividad_programacion actividad_programacion) {
		try {
			actividad_programacionRepository.update(id,
					new Actividad_programacion(actividad_programacion.getNombre(), actividad_programacion.getFecha_inicio(), actividad_programacion.getFecha_fin(), actividad_programacion.getTipo_produccion_proceso_id(), actividad_programacion.getDescripcion(), actividad_programacion.getEstado()));
			return new ResponseEntity<>("Actividad_programacion actualizado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/actividad_programacion/{id}")
	public ResponseEntity<String> deleteActividad_programacion(@PathVariable("id") int id) {
		try {
			actividad_programacionRepository.delete(id);
			return new ResponseEntity<>("Actividad_programacion eliminado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
