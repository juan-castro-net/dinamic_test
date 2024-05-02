package org.usco.pruebas.panelcontrol;

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
public class PanelcontrolController {

	@Autowired
	PanelcontrolRepository panelcontrolRepository;

	@PostMapping("/panelcontrol")
	public ResponseEntity<String> createPanelcontrol(@RequestBody Panelcontrol panelcontrol) {
		try {
			panelcontrolRepository.create(
					new Panelcontrol(panelcontrol.getNombre(), panelcontrol.getDescripcion(), panelcontrol.getEstado()));
			return new ResponseEntity<>("Panelcontrol creado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/panelcontrol")
	public ResponseEntity<List<Panelcontrol>> getAllPanelcontrols() {
		try {
			ArrayList<Panelcontrol> panelcontrols = new ArrayList<Panelcontrol>();

			panelcontrolRepository.read().forEach(panelcontrols::add);

			if (panelcontrols.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(panelcontrols, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/panelcontrol/{id}")
	public ResponseEntity<String> updatePanelcontrol(@PathVariable("id") int id,
			@RequestBody Panelcontrol panelcontrol) {
		try {
			panelcontrolRepository.update(id,
					new Panelcontrol(panelcontrol.getNombre(), panelcontrol.getDescripcion(), panelcontrol.getEstado()));
			return new ResponseEntity<>("Panelcontrol actualizado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/panelcontrol/{id}")
	public ResponseEntity<String> deletePanelcontrol(@PathVariable("id") int id) {
		try {
			panelcontrolRepository.delete(id);
			return new ResponseEntity<>("Panelcontrol eliminado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
