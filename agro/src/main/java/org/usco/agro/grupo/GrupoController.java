package org.usco.agro.grupo;

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
public class GrupoController {

	@Autowired
	GrupoRepository grupoRepository;

	@PostMapping("/grupo")
	public ResponseEntity<String> createGrupo(@RequestBody Grupo grupo) {
		try {
			grupoRepository.create(
					new Grupo(grupo.getNombre(), grupo.getEmpresa_id(), grupo.getDescripcion(), grupo.getEstado()));
			return new ResponseEntity<>("Grupo creado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/grupo")
	public ResponseEntity<List<Grupo>> getAllGrupos() {
		try {
			ArrayList<Grupo> grupos = new ArrayList<Grupo>();

			grupoRepository.read().forEach(grupos::add);

			if (grupos.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(grupos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/grupo/{id}")
	public ResponseEntity<String> updateGrupo(@PathVariable("id") int id,
			@RequestBody Grupo grupo) {
		try {
			grupoRepository.update(id,
					new Grupo(grupo.getNombre(), grupo.getEmpresa_id(), grupo.getDescripcion(), grupo.getEstado()));
			return new ResponseEntity<>("Grupo actualizado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/grupo/{id}")
	public ResponseEntity<String> deleteGrupo(@PathVariable("id") int id) {
		try {
			grupoRepository.delete(id);
			return new ResponseEntity<>("Grupo eliminado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
