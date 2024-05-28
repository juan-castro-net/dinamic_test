package org.usco.agro.espacio;

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
public class EspacioController {

	@Autowired
	EspacioRepository espacioRepository;

	@PostMapping("/espacio")
	public ResponseEntity<String> createEspacio(@RequestBody Espacio espacio) {
		try {
			espacioRepository.create(
					new Espacio(espacio.getBloque_id(), espacio.getTipo_espacio_id(), espacio.getNombre(), espacio.getGeolocalizacion(), espacio.getCoordenadas(), espacio.getDescripcion(), espacio.getEstado()));
			return new ResponseEntity<>("Espacio creado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/espacio")
	public ResponseEntity<List<Espacio>> getAllEspacios() {
		try {
			ArrayList<Espacio> espacios = new ArrayList<Espacio>();

			espacioRepository.read().forEach(espacios::add);

			if (espacios.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(espacios, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/espacio/{id}")
	public ResponseEntity<String> updateEspacio(@PathVariable("id") int id,
			@RequestBody Espacio espacio) {
		try {
			espacioRepository.update(id,
					new Espacio(espacio.getBloque_id(), espacio.getTipo_espacio_id(), espacio.getNombre(), espacio.getGeolocalizacion(), espacio.getCoordenadas(), espacio.getDescripcion(), espacio.getEstado()));
			return new ResponseEntity<>("Espacio actualizado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/espacio/{id}")
	public ResponseEntity<String> deleteEspacio(@PathVariable("id") int id) {
		try {
			espacioRepository.delete(id);
			return new ResponseEntity<>("Espacio eliminado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
