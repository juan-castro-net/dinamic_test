package org.usco.pruebas.entidad;

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
public class EntidadController {

	@Autowired
	EntidadRepository entidadRepository;

	@PostMapping("/entidad")
	public ResponseEntity<String> createEntidad(@RequestBody Entidad entidad) {
		try {
			entidadRepository.create(
					new Entidad(entidad.getNombre(), entidad.getMunicipio(), entidad.getCodigo(), entidad.getTipoentidad(), entidad.getEstado(), entidad.getComuna(), entidad.getGeolocalizacion()));
			return new ResponseEntity<>("Entidad creado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/entidad")
	public ResponseEntity<List<Entidad>> getAllEntidads() {
		try {
			ArrayList<Entidad> entidads = new ArrayList<Entidad>();

			entidadRepository.read().forEach(entidads::add);

			if (entidads.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(entidads, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/entidad/{id}")
	public ResponseEntity<String> updateEntidad(@PathVariable("id") int id,
			@RequestBody Entidad entidad) {
		try {
			entidadRepository.update(id,
					new Entidad(entidad.getNombre(), entidad.getMunicipio(), entidad.getCodigo(), entidad.getTipoentidad(), entidad.getEstado(), entidad.getComuna(), entidad.getGeolocalizacion()));
			return new ResponseEntity<>("Entidad actualizado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/entidad/{id}")
	public ResponseEntity<String> deleteEntidad(@PathVariable("id") int id) {
		try {
			entidadRepository.delete(id);
			return new ResponseEntity<>("Entidad eliminado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
