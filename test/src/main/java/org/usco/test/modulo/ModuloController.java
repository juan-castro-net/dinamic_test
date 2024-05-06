package org.usco.test.modulo;

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
public class ModuloController {

	@Autowired
	ModuloRepository moduloRepository;

	@PostMapping("/modulo")
	public ResponseEntity<String> createModulo(@RequestBody Modulo modulo) {
		try {
			moduloRepository.create(
					new Modulo(modulo.getNombre(), modulo.getDescripcion(), modulo.getEstado(), modulo.getUrl()));
			return new ResponseEntity<>("Modulo creado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/modulo")
	public ResponseEntity<List<Modulo>> getAllModulos() {
		try {
			ArrayList<Modulo> modulos = new ArrayList<Modulo>();

			moduloRepository.read().forEach(modulos::add);

			if (modulos.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(modulos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/modulo/{id}")
	public ResponseEntity<String> updateModulo(@PathVariable("id") int id,
			@RequestBody Modulo modulo) {
		try {
			moduloRepository.update(id,
					new Modulo(modulo.getNombre(), modulo.getDescripcion(), modulo.getEstado(), modulo.getUrl()));
			return new ResponseEntity<>("Modulo actualizado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/modulo/{id}")
	public ResponseEntity<String> deleteModulo(@PathVariable("id") int id) {
		try {
			moduloRepository.delete(id);
			return new ResponseEntity<>("Modulo eliminado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
