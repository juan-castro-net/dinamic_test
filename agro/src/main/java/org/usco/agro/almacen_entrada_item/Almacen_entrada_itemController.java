package org.usco.agro.almacen_entrada_item;

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
public class Almacen_entrada_itemController {

	@Autowired
	Almacen_entrada_itemRepository almacen_entrada_itemRepository;

	@PostMapping("/almacen_entrada_item")
	public ResponseEntity<String> createAlmacen_entrada_item(@RequestBody Almacen_entrada_item almacen_entrada_item) {
		try {
			almacen_entrada_itemRepository.create(
					new Almacen_entrada_item(almacen_entrada_item.getAlmacen_entrada_id(), almacen_entrada_item.getProducto_id(), almacen_entrada_item.getProducto_presentacion_id(), almacen_entrada_item.getCantidad(), almacen_entrada_item.getPrecio(), almacen_entrada_item.getEstado()));
			return new ResponseEntity<>("Almacen_entrada_item creado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/almacen_entrada_item")
	public ResponseEntity<List<Almacen_entrada_item>> getAllAlmacen_entrada_items() {
		try {
			ArrayList<Almacen_entrada_item> almacen_entrada_items = new ArrayList<Almacen_entrada_item>();

			almacen_entrada_itemRepository.read().forEach(almacen_entrada_items::add);

			if (almacen_entrada_items.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(almacen_entrada_items, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/almacen_entrada_item/{id}")
	public ResponseEntity<String> updateAlmacen_entrada_item(@PathVariable("id") int id,
			@RequestBody Almacen_entrada_item almacen_entrada_item) {
		try {
			almacen_entrada_itemRepository.update(id,
					new Almacen_entrada_item(almacen_entrada_item.getAlmacen_entrada_id(), almacen_entrada_item.getProducto_id(), almacen_entrada_item.getProducto_presentacion_id(), almacen_entrada_item.getCantidad(), almacen_entrada_item.getPrecio(), almacen_entrada_item.getEstado()));
			return new ResponseEntity<>("Almacen_entrada_item actualizado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/almacen_entrada_item/{id}")
	public ResponseEntity<String> deleteAlmacen_entrada_item(@PathVariable("id") int id) {
		try {
			almacen_entrada_itemRepository.delete(id);
			return new ResponseEntity<>("Almacen_entrada_item eliminado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
