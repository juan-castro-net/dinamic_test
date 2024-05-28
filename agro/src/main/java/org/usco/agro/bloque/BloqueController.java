package org.usco.agro.bloque;

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
public class BloqueController {

	@Autowired
	BloqueRepository bloqueRepository;

	@PostMapping("/bloque")
	public ResponseEntity<String> createBloque(@RequestBody Bloque bloque) {
		try {
			bloqueRepository.create(
					new Bloque(bloque.getSede_id(), bloque.getTipo_bloque_id(), bloque.getNombre(), bloque.getGeolocalizacion(), bloque.getCoordenadas(), bloque.getNumero_pisos(), bloque.getDescripcion(), bloque.getEstado()));
			return new ResponseEntity<>("Bloque creado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/bloque")
	public ResponseEntity<List<Bloque>> getAllBloques() {
		try {
			ArrayList<Bloque> bloques = new ArrayList<Bloque>();

			bloqueRepository.read().forEach(bloques::add);

			if (bloques.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(bloques, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/bloque/{id}")
	public ResponseEntity<String> updateBloque(@PathVariable("id") int id,
			@RequestBody Bloque bloque) {
		try {
			bloqueRepository.update(id,
					new Bloque(bloque.getSede_id(), bloque.getTipo_bloque_id(), bloque.getNombre(), bloque.getGeolocalizacion(), bloque.getCoordenadas(), bloque.getNumero_pisos(), bloque.getDescripcion(), bloque.getEstado()));
			return new ResponseEntity<>("Bloque actualizado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/bloque/{id}")
	public ResponseEntity<String> deleteBloque(@PathVariable("id") int id) {
		try {
			bloqueRepository.delete(id);
			return new ResponseEntity<>("Bloque eliminado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
