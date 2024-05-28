package org.usco.agro.almacen_entrada;

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
public class Almacen_entradaController {

	@Autowired
	Almacen_entradaRepository almacen_entradaRepository;

	@PostMapping("/almacen_entrada")
	public ResponseEntity<String> createAlmacen_entrada(@RequestBody Almacen_entrada almacen_entrada) {
		try {
			almacen_entradaRepository.create(
					new Almacen_entrada(almacen_entrada.getProveedor_id(), almacen_entrada.getAlmacen_id(), almacen_entrada.getEspacio_id(), almacen_entrada.getFecha(), almacen_entrada.getDescripcion(), almacen_entrada.getEstado()));
			return new ResponseEntity<>("Almacen_entrada creado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/almacen_entrada")
	public ResponseEntity<List<Almacen_entrada>> getAllAlmacen_entradas() {
		try {
			ArrayList<Almacen_entrada> almacen_entradas = new ArrayList<Almacen_entrada>();

			almacen_entradaRepository.read().forEach(almacen_entradas::add);

			if (almacen_entradas.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(almacen_entradas, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/almacen_entrada/{id}")
	public ResponseEntity<String> updateAlmacen_entrada(@PathVariable("id") int id,
			@RequestBody Almacen_entrada almacen_entrada) {
		try {
			almacen_entradaRepository.update(id,
					new Almacen_entrada(almacen_entrada.getProveedor_id(), almacen_entrada.getAlmacen_id(), almacen_entrada.getEspacio_id(), almacen_entrada.getFecha(), almacen_entrada.getDescripcion(), almacen_entrada.getEstado()));
			return new ResponseEntity<>("Almacen_entrada actualizado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/almacen_entrada/{id}")
	public ResponseEntity<String> deleteAlmacen_entrada(@PathVariable("id") int id) {
		try {
			almacen_entradaRepository.delete(id);
			return new ResponseEntity<>("Almacen_entrada eliminado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
