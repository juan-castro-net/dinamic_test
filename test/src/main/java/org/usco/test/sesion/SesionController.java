package org.usco.test.sesion;

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
public class SesionController {

	@Autowired
	SesionRepository sesionRepository;

	@PostMapping("/sesion")
	public ResponseEntity<String> createSesion(@RequestBody Sesion sesion) {
		try {
			sesionRepository.create(
					new Sesion(sesion.getUsuario(), sesion.getFecha_hora_start(), sesion.getFecha_hora_end(), sesion.getIp()));
			return new ResponseEntity<>("Sesion creado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/sesion")
	public ResponseEntity<List<Sesion>> getAllSesions() {
		try {
			ArrayList<Sesion> sesions = new ArrayList<Sesion>();

			sesionRepository.read().forEach(sesions::add);

			if (sesions.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(sesions, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/sesion/{id}")
	public ResponseEntity<String> updateSesion(@PathVariable("id") int id,
			@RequestBody Sesion sesion) {
		try {
			sesionRepository.update(id,
					new Sesion(sesion.getUsuario(), sesion.getFecha_hora_start(), sesion.getFecha_hora_end(), sesion.getIp()));
			return new ResponseEntity<>("Sesion actualizado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/sesion/{id}")
	public ResponseEntity<String> deleteSesion(@PathVariable("id") int id) {
		try {
			sesionRepository.delete(id);
			return new ResponseEntity<>("Sesion eliminado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
