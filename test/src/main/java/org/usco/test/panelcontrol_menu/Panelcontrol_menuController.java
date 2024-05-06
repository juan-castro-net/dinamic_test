package org.usco.test.panelcontrol_menu;

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
public class Panelcontrol_menuController {

	@Autowired
	Panelcontrol_menuRepository panelcontrol_menuRepository;

	@PostMapping("/panelcontrol_menu")
	public ResponseEntity<String> createPanelcontrol_menu(@RequestBody Panelcontrol_menu panelcontrol_menu) {
		try {
			panelcontrol_menuRepository.create(
					new Panelcontrol_menu(panelcontrol_menu.getNombre()));
			return new ResponseEntity<>("Panelcontrol_menu creado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/panelcontrol_menu")
	public ResponseEntity<List<Panelcontrol_menu>> getAllPanelcontrol_menus() {
		try {
			ArrayList<Panelcontrol_menu> panelcontrol_menus = new ArrayList<Panelcontrol_menu>();

			panelcontrol_menuRepository.read().forEach(panelcontrol_menus::add);

			if (panelcontrol_menus.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(panelcontrol_menus, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/panelcontrol_menu/{id}")
	public ResponseEntity<String> updatePanelcontrol_menu(@PathVariable("id") int id,
			@RequestBody Panelcontrol_menu panelcontrol_menu) {
		try {
			panelcontrol_menuRepository.update(id,
					new Panelcontrol_menu(panelcontrol_menu.getNombre()));
			return new ResponseEntity<>("Panelcontrol_menu actualizado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/panelcontrol_menu/{id}")
	public ResponseEntity<String> deletePanelcontrol_menu(@PathVariable("id") int id) {
		try {
			panelcontrol_menuRepository.delete(id);
			return new ResponseEntity<>("Panelcontrol_menu eliminado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
