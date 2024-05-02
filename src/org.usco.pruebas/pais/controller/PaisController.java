package org.usco.pruebas.pais;

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
public class PaisController {

	@Autowired
	PaisRepository paisRepository;

	@PostMapping("/pais")
	public ResponseEntity<String> createPais(@RequestBody Pais pais) {
		try {
			paisRepository.create(
					new Pais(pais.getNombre(), pais.getCodigo(), pais.getAcronimo()));
			return new ResponseEntity<>("Pais creado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/pais")
	public ResponseEntity<List<Pais>> getAllPaiss() {
		try {
			ArrayList<Pais> paiss = new ArrayList<Pais>();

			paisRepository.read().forEach(paiss::add);

			if (paiss.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(paiss, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/pais/{id}")
	public ResponseEntity<String> updatePais(@PathVariable("id") int id,
			@RequestBody Pais pais) {
		try {
			paisRepository.update(id,
					new Pais(pais.getNombre(), pais.getCodigo(), pais.getAcronimo()));
			return new ResponseEntity<>("Pais actualizado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/pais/{id}")
	public ResponseEntity<String> deletePais(@PathVariable("id") int id) {
		try {
			paisRepository.delete(id);
			return new ResponseEntity<>("Pais eliminado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
