package org.usco.agro.produccion;

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
public class ProduccionController {

	@Autowired
	ProduccionRepository produccionRepository;

	@PostMapping("/produccion")
	public ResponseEntity<String> createProduccion(@RequestBody Produccion produccion) {
		try {
			produccionRepository.create(
					new Produccion(produccion.getNombre(), produccion.getTipo_produccion_id(), produccion.getDescripcion(), produccion.getFecha_inicio(), produccion.getFecha_final(), produccion.getEspacio_id(), produccion.getEstado()));
			return new ResponseEntity<>("Produccion creado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/produccion")
	public ResponseEntity<List<Produccion>> getAllProduccions() {
		try {
			ArrayList<Produccion> produccions = new ArrayList<Produccion>();

			produccionRepository.read().forEach(produccions::add);

			if (produccions.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(produccions, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/produccion/{id}")
	public ResponseEntity<String> updateProduccion(@PathVariable("id") int id,
			@RequestBody Produccion produccion) {
		try {
			produccionRepository.update(id,
					new Produccion(produccion.getNombre(), produccion.getTipo_produccion_id(), produccion.getDescripcion(), produccion.getFecha_inicio(), produccion.getFecha_final(), produccion.getEspacio_id(), produccion.getEstado()));
			return new ResponseEntity<>("Produccion actualizado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/produccion/{id}")
	public ResponseEntity<String> deleteProduccion(@PathVariable("id") int id) {
		try {
			produccionRepository.delete(id);
			return new ResponseEntity<>("Produccion eliminado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
