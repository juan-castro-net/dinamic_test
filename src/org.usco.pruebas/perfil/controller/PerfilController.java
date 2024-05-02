package org.usco.pruebas.perfil;

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
public class PerfilController {

	@Autowired
	PerfilRepository perfilRepository;

	@PostMapping("/perfil")
	public ResponseEntity<String> createPerfil(@RequestBody Perfil perfil) {
		try {
			perfilRepository.create(
					new Perfil(perfil.getNombre(), perfil.getDescripcion(), perfil.getEstado(), perfil.getCodigo()));
			return new ResponseEntity<>("Perfil creado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/perfil")
	public ResponseEntity<List<Perfil>> getAllPerfils() {
		try {
			ArrayList<Perfil> perfils = new ArrayList<Perfil>();

			perfilRepository.read().forEach(perfils::add);

			if (perfils.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(perfils, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/perfil/{id}")
	public ResponseEntity<String> updatePerfil(@PathVariable("id") int id,
			@RequestBody Perfil perfil) {
		try {
			perfilRepository.update(id,
					new Perfil(perfil.getNombre(), perfil.getDescripcion(), perfil.getEstado(), perfil.getCodigo()));
			return new ResponseEntity<>("Perfil actualizado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/perfil/{id}")
	public ResponseEntity<String> deletePerfil(@PathVariable("id") int id) {
		try {
			perfilRepository.delete(id);
			return new ResponseEntity<>("Perfil eliminado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
