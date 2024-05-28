package org.usco.agro.almacen;

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
public class AlmacenController {

	@Autowired
	AlmacenRepository almacenRepository;

	@PostMapping("/almacen")
	public ResponseEntity<String> createAlmacen(@RequestBody Almacen almacen) {
		try {
			almacenRepository.create(
					new Almacen(almacen.getNombre(), almacen.getSede_id(), almacen.getGeolocalizacion(), almacen.getCoordenadas(), almacen.getDescripcion(), almacen.getEstado()));
			return new ResponseEntity<>("Almacen creado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/almacen")
	public ResponseEntity<List<Almacen>> getAllAlmacens() {
		try {
			ArrayList<Almacen> almacens = new ArrayList<Almacen>();

			almacenRepository.read().forEach(almacens::add);

			if (almacens.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(almacens, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/almacen/{id}")
	public ResponseEntity<String> updateAlmacen(@PathVariable("id") int id,
			@RequestBody Almacen almacen) {
		try {
			almacenRepository.update(id,
					new Almacen(almacen.getNombre(), almacen.getSede_id(), almacen.getGeolocalizacion(), almacen.getCoordenadas(), almacen.getDescripcion(), almacen.getEstado()));
			return new ResponseEntity<>("Almacen actualizado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/almacen/{id}")
	public ResponseEntity<String> deleteAlmacen(@PathVariable("id") int id) {
		try {
			almacenRepository.delete(id);
			return new ResponseEntity<>("Almacen eliminado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
