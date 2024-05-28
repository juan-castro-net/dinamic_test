package org.usco.agro.almacen_salida_item;

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
public class Almacen_salida_itemController {

	@Autowired
	Almacen_salida_itemRepository almacen_salida_itemRepository;

	@PostMapping("/almacen_salida_item")
	public ResponseEntity<String> createAlmacen_salida_item(@RequestBody Almacen_salida_item almacen_salida_item) {
		try {
			almacen_salida_itemRepository.create(
					new Almacen_salida_item(almacen_salida_item.getAlmacen_salida_id(), almacen_salida_item.getProducto_id(), almacen_salida_item.getProducto_presentacion_id(), almacen_salida_item.getCantidad(), almacen_salida_item.getPrecio(), almacen_salida_item.getEstado()));
			return new ResponseEntity<>("Almacen_salida_item creado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/almacen_salida_item")
	public ResponseEntity<List<Almacen_salida_item>> getAllAlmacen_salida_items() {
		try {
			ArrayList<Almacen_salida_item> almacen_salida_items = new ArrayList<Almacen_salida_item>();

			almacen_salida_itemRepository.read().forEach(almacen_salida_items::add);

			if (almacen_salida_items.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(almacen_salida_items, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/almacen_salida_item/{id}")
	public ResponseEntity<String> updateAlmacen_salida_item(@PathVariable("id") int id,
			@RequestBody Almacen_salida_item almacen_salida_item) {
		try {
			almacen_salida_itemRepository.update(id,
					new Almacen_salida_item(almacen_salida_item.getAlmacen_salida_id(), almacen_salida_item.getProducto_id(), almacen_salida_item.getProducto_presentacion_id(), almacen_salida_item.getCantidad(), almacen_salida_item.getPrecio(), almacen_salida_item.getEstado()));
			return new ResponseEntity<>("Almacen_salida_item actualizado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/almacen_salida_item/{id}")
	public ResponseEntity<String> deleteAlmacen_salida_item(@PathVariable("id") int id) {
		try {
			almacen_salida_itemRepository.delete(id);
			return new ResponseEntity<>("Almacen_salida_item eliminado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
