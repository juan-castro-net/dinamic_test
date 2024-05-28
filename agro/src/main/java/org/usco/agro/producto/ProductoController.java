package org.usco.agro.producto;

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
public class ProductoController {

	@Autowired
	ProductoRepository productoRepository;

	@PostMapping("/producto")
	public ResponseEntity<String> createProducto(@RequestBody Producto producto) {
		try {
			productoRepository.create(
					new Producto(producto.getNombre(), producto.getProducto_categoria_id()));
			return new ResponseEntity<>("Producto creado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/producto")
	public ResponseEntity<List<Producto>> getAllProductos() {
		try {
			ArrayList<Producto> productos = new ArrayList<Producto>();

			productoRepository.read().forEach(productos::add);

			if (productos.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(productos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/producto/{id}")
	public ResponseEntity<String> updateProducto(@PathVariable("id") int id,
			@RequestBody Producto producto) {
		try {
			productoRepository.update(id,
					new Producto(producto.getNombre(), producto.getProducto_categoria_id()));
			return new ResponseEntity<>("Producto actualizado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/producto/{id}")
	public ResponseEntity<String> deleteProducto(@PathVariable("id") int id) {
		try {
			productoRepository.delete(id);
			return new ResponseEntity<>("Producto eliminado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
