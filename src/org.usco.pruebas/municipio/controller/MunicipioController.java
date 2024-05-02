package org.usco.pruebas.municipio;

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
public class MunicipioController {

	@Autowired
	MunicipioRepository municipioRepository;

	@PostMapping("/municipio")
	public ResponseEntity<String> createMunicipio(@RequestBody Municipio municipio) {
		try {
			municipioRepository.create(
					new Municipio(municipio.getNombre(), municipio.getDepartamento(), municipio.getCodigo(), municipio.getAcronimo()));
			return new ResponseEntity<>("Municipio creado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/municipio")
	public ResponseEntity<List<Municipio>> getAllMunicipios() {
		try {
			ArrayList<Municipio> municipios = new ArrayList<Municipio>();

			municipioRepository.read().forEach(municipios::add);

			if (municipios.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(municipios, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/municipio/{id}")
	public ResponseEntity<String> updateMunicipio(@PathVariable("id") int id,
			@RequestBody Municipio municipio) {
		try {
			municipioRepository.update(id,
					new Municipio(municipio.getNombre(), municipio.getDepartamento(), municipio.getCodigo(), municipio.getAcronimo()));
			return new ResponseEntity<>("Municipio actualizado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/municipio/{id}")
	public ResponseEntity<String> deleteMunicipio(@PathVariable("id") int id) {
		try {
			municipioRepository.delete(id);
			return new ResponseEntity<>("Municipio eliminado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
