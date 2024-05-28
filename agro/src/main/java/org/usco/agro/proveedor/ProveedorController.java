package org.usco.agro.proveedor;

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
public class ProveedorController {

	@Autowired
	ProveedorRepository proveedorRepository;

	@PostMapping("/proveedor")
	public ResponseEntity<String> createProveedor(@RequestBody Proveedor proveedor) {
		try {
			proveedorRepository.create(
					new Proveedor(proveedor.getEmpresa_id(), proveedor.getFecha_creacion(), proveedor.getEstado()));
			return new ResponseEntity<>("Proveedor creado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/proveedor")
	public ResponseEntity<List<Proveedor>> getAllProveedors() {
		try {
			ArrayList<Proveedor> proveedors = new ArrayList<Proveedor>();

			proveedorRepository.read().forEach(proveedors::add);

			if (proveedors.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(proveedors, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/proveedor/{id}")
	public ResponseEntity<String> updateProveedor(@PathVariable("id") int id,
			@RequestBody Proveedor proveedor) {
		try {
			proveedorRepository.update(id,
					new Proveedor(proveedor.getEmpresa_id(), proveedor.getFecha_creacion(), proveedor.getEstado()));
			return new ResponseEntity<>("Proveedor actualizado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/proveedor/{id}")
	public ResponseEntity<String> deleteProveedor(@PathVariable("id") int id) {
		try {
			proveedorRepository.delete(id);
			return new ResponseEntity<>("Proveedor eliminado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
