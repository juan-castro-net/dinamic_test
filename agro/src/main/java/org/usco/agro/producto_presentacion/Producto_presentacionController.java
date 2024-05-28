package org.usco.agro.producto_presentacion;

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
public class Producto_presentacionController {

	@Autowired
	Producto_presentacionRepository producto_presentacionRepository;

	@PostMapping("/producto_presentacion")
	public ResponseEntity<String> createProducto_presentacion(@RequestBody Producto_presentacion producto_presentacion) {
		try {
			producto_presentacionRepository.create(
					new Producto_presentacion(producto_presentacion.getProducto_id(), producto_presentacion.getNombre(), producto_presentacion.getDescripcion(), producto_presentacion.getEstado()));
			return new ResponseEntity<>("Producto_presentacion creado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/producto_presentacion")
	public ResponseEntity<List<Producto_presentacion>> getAllProducto_presentacions() {
		try {
			ArrayList<Producto_presentacion> producto_presentacions = new ArrayList<Producto_presentacion>();

			producto_presentacionRepository.read().forEach(producto_presentacions::add);

			if (producto_presentacions.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(producto_presentacions, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/producto_presentacion/{id}")
	public ResponseEntity<String> updateProducto_presentacion(@PathVariable("id") int id,
			@RequestBody Producto_presentacion producto_presentacion) {
		try {
			producto_presentacionRepository.update(id,
					new Producto_presentacion(producto_presentacion.getProducto_id(), producto_presentacion.getNombre(), producto_presentacion.getDescripcion(), producto_presentacion.getEstado()));
			return new ResponseEntity<>("Producto_presentacion actualizado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/producto_presentacion/{id}")
	public ResponseEntity<String> deleteProducto_presentacion(@PathVariable("id") int id) {
		try {
			producto_presentacionRepository.delete(id);
			return new ResponseEntity<>("Producto_presentacion eliminado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
