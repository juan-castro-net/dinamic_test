package org.usco.agro.producto_categoria;

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
public class Producto_categoriaController {

	@Autowired
	Producto_categoriaRepository producto_categoriaRepository;

	@PostMapping("/producto_categoria")
	public ResponseEntity<String> createProducto_categoria(@RequestBody Producto_categoria producto_categoria) {
		try {
			producto_categoriaRepository.create(
					new Producto_categoria(producto_categoria.getNombre(), producto_categoria.getDescripcion(), producto_categoria.getEstado()));
			return new ResponseEntity<>("Producto_categoria creado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/producto_categoria")
	public ResponseEntity<List<Producto_categoria>> getAllProducto_categorias() {
		try {
			ArrayList<Producto_categoria> producto_categorias = new ArrayList<Producto_categoria>();

			producto_categoriaRepository.read().forEach(producto_categorias::add);

			if (producto_categorias.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(producto_categorias, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/producto_categoria/{id}")
	public ResponseEntity<String> updateProducto_categoria(@PathVariable("id") int id,
			@RequestBody Producto_categoria producto_categoria) {
		try {
			producto_categoriaRepository.update(id,
					new Producto_categoria(producto_categoria.getNombre(), producto_categoria.getDescripcion(), producto_categoria.getEstado()));
			return new ResponseEntity<>("Producto_categoria actualizado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/producto_categoria/{id}")
	public ResponseEntity<String> deleteProducto_categoria(@PathVariable("id") int id) {
		try {
			producto_categoriaRepository.delete(id);
			return new ResponseEntity<>("Producto_categoria eliminado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
