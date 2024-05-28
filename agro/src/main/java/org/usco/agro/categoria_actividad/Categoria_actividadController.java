package org.usco.agro.categoria_actividad;

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
public class Categoria_actividadController {

	@Autowired
	Categoria_actividadRepository categoria_actividadRepository;

	@PostMapping("/categoria_actividad")
	public ResponseEntity<String> createCategoria_actividad(@RequestBody Categoria_actividad categoria_actividad) {
		try {
			categoria_actividadRepository.create(
					new Categoria_actividad(categoria_actividad.getNombre(), categoria_actividad.getDescripcion(), categoria_actividad.getEstado()));
			return new ResponseEntity<>("Categoria_actividad creado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/categoria_actividad")
	public ResponseEntity<List<Categoria_actividad>> getAllCategoria_actividads() {
		try {
			ArrayList<Categoria_actividad> categoria_actividads = new ArrayList<Categoria_actividad>();

			categoria_actividadRepository.read().forEach(categoria_actividads::add);

			if (categoria_actividads.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(categoria_actividads, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/categoria_actividad/{id}")
	public ResponseEntity<String> updateCategoria_actividad(@PathVariable("id") int id,
			@RequestBody Categoria_actividad categoria_actividad) {
		try {
			categoria_actividadRepository.update(id,
					new Categoria_actividad(categoria_actividad.getNombre(), categoria_actividad.getDescripcion(), categoria_actividad.getEstado()));
			return new ResponseEntity<>("Categoria_actividad actualizado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/categoria_actividad/{id}")
	public ResponseEntity<String> deleteCategoria_actividad(@PathVariable("id") int id) {
		try {
			categoria_actividadRepository.delete(id);
			return new ResponseEntity<>("Categoria_actividad eliminado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
