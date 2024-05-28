package org.usco.agro.tipo_costo_indirecto;

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
public class Tipo_costo_indirectoController {

	@Autowired
	Tipo_costo_indirectoRepository tipo_costo_indirectoRepository;

	@PostMapping("/tipo_costo_indirecto")
	public ResponseEntity<String> createTipo_costo_indirecto(@RequestBody Tipo_costo_indirecto tipo_costo_indirecto) {
		try {
			tipo_costo_indirectoRepository.create(
					new Tipo_costo_indirecto(tipo_costo_indirecto.getNombre(), tipo_costo_indirecto.getDescripcion(), tipo_costo_indirecto.getEstado()));
			return new ResponseEntity<>("Tipo_costo_indirecto creado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/tipo_costo_indirecto")
	public ResponseEntity<List<Tipo_costo_indirecto>> getAllTipo_costo_indirectos() {
		try {
			ArrayList<Tipo_costo_indirecto> tipo_costo_indirectos = new ArrayList<Tipo_costo_indirecto>();

			tipo_costo_indirectoRepository.read().forEach(tipo_costo_indirectos::add);

			if (tipo_costo_indirectos.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(tipo_costo_indirectos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/tipo_costo_indirecto/{id}")
	public ResponseEntity<String> updateTipo_costo_indirecto(@PathVariable("id") int id,
			@RequestBody Tipo_costo_indirecto tipo_costo_indirecto) {
		try {
			tipo_costo_indirectoRepository.update(id,
					new Tipo_costo_indirecto(tipo_costo_indirecto.getNombre(), tipo_costo_indirecto.getDescripcion(), tipo_costo_indirecto.getEstado()));
			return new ResponseEntity<>("Tipo_costo_indirecto actualizado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/tipo_costo_indirecto/{id}")
	public ResponseEntity<String> deleteTipo_costo_indirecto(@PathVariable("id") int id) {
		try {
			tipo_costo_indirectoRepository.delete(id);
			return new ResponseEntity<>("Tipo_costo_indirecto eliminado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
