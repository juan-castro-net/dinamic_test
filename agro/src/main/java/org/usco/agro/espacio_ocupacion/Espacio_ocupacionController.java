package org.usco.agro.espacio_ocupacion;

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
public class Espacio_ocupacionController {

	@Autowired
	Espacio_ocupacionRepository espacio_ocupacionRepository;

	@PostMapping("/espacio_ocupacion")
	public ResponseEntity<String> createEspacio_ocupacion(@RequestBody Espacio_ocupacion espacio_ocupacion) {
		try {
			espacio_ocupacionRepository.create(
					new Espacio_ocupacion(espacio_ocupacion.getEspacio_id(), espacio_ocupacion.getActividad_ocupacion_id(), espacio_ocupacion.getFecha_inicio(), espacio_ocupacion.getFecha_fin(), espacio_ocupacion.getEstado()));
			return new ResponseEntity<>("Espacio_ocupacion creado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/espacio_ocupacion")
	public ResponseEntity<List<Espacio_ocupacion>> getAllEspacio_ocupacions() {
		try {
			ArrayList<Espacio_ocupacion> espacio_ocupacions = new ArrayList<Espacio_ocupacion>();

			espacio_ocupacionRepository.read().forEach(espacio_ocupacions::add);

			if (espacio_ocupacions.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(espacio_ocupacions, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/espacio_ocupacion/{id}")
	public ResponseEntity<String> updateEspacio_ocupacion(@PathVariable("id") int id,
			@RequestBody Espacio_ocupacion espacio_ocupacion) {
		try {
			espacio_ocupacionRepository.update(id,
					new Espacio_ocupacion(espacio_ocupacion.getEspacio_id(), espacio_ocupacion.getActividad_ocupacion_id(), espacio_ocupacion.getFecha_inicio(), espacio_ocupacion.getFecha_fin(), espacio_ocupacion.getEstado()));
			return new ResponseEntity<>("Espacio_ocupacion actualizado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/espacio_ocupacion/{id}")
	public ResponseEntity<String> deleteEspacio_ocupacion(@PathVariable("id") int id) {
		try {
			espacio_ocupacionRepository.delete(id);
			return new ResponseEntity<>("Espacio_ocupacion eliminado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
