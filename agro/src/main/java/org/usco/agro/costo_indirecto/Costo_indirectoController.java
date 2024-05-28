package org.usco.agro.costo_indirecto;

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
public class Costo_indirectoController {

	@Autowired
	Costo_indirectoRepository costo_indirectoRepository;

	@PostMapping("/costo_indirecto")
	public ResponseEntity<String> createCosto_indirecto(@RequestBody Costo_indirecto costo_indirecto) {
		try {
			costo_indirectoRepository.create(
					new Costo_indirecto(costo_indirecto.getEspacio_id(), costo_indirecto.getTipo_costo_indirecto_id(), costo_indirecto.getFecha_inicio(), costo_indirecto.getFecha_fin(), costo_indirecto.getNombre(), costo_indirecto.getPrecio(), costo_indirecto.getDescripcion(), costo_indirecto.getEstado()));
			return new ResponseEntity<>("Costo_indirecto creado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/costo_indirecto")
	public ResponseEntity<List<Costo_indirecto>> getAllCosto_indirectos() {
		try {
			ArrayList<Costo_indirecto> costo_indirectos = new ArrayList<Costo_indirecto>();

			costo_indirectoRepository.read().forEach(costo_indirectos::add);

			if (costo_indirectos.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(costo_indirectos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/costo_indirecto/{id}")
	public ResponseEntity<String> updateCosto_indirecto(@PathVariable("id") int id,
			@RequestBody Costo_indirecto costo_indirecto) {
		try {
			costo_indirectoRepository.update(id,
					new Costo_indirecto(costo_indirecto.getEspacio_id(), costo_indirecto.getTipo_costo_indirecto_id(), costo_indirecto.getFecha_inicio(), costo_indirecto.getFecha_fin(), costo_indirecto.getNombre(), costo_indirecto.getPrecio(), costo_indirecto.getDescripcion(), costo_indirecto.getEstado()));
			return new ResponseEntity<>("Costo_indirecto actualizado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/costo_indirecto/{id}")
	public ResponseEntity<String> deleteCosto_indirecto(@PathVariable("id") int id) {
		try {
			costo_indirectoRepository.delete(id);
			return new ResponseEntity<>("Costo_indirecto eliminado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
