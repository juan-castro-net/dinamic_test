package org.usco.agro.empresa;

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
public class EmpresaController {

	@Autowired
	EmpresaRepository empresaRepository;

	@PostMapping("/empresa")
	public ResponseEntity<String> createEmpresa(@RequestBody Empresa empresa) {
		try {
			empresaRepository.create(
					new Empresa(empresa.getTipo_identificacion_id(), empresa.getIdentificacion(), empresa.getNombre(), empresa.getDescripcion(), empresa.getEstado()));
			return new ResponseEntity<>("Empresa creado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/empresa")
	public ResponseEntity<List<Empresa>> getAllEmpresas() {
		try {
			ArrayList<Empresa> empresas = new ArrayList<Empresa>();

			empresaRepository.read().forEach(empresas::add);

			if (empresas.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(empresas, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/empresa/{id}")
	public ResponseEntity<String> updateEmpresa(@PathVariable("id") int id,
			@RequestBody Empresa empresa) {
		try {
			empresaRepository.update(id,
					new Empresa(empresa.getTipo_identificacion_id(), empresa.getIdentificacion(), empresa.getNombre(), empresa.getDescripcion(), empresa.getEstado()));
			return new ResponseEntity<>("Empresa actualizado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/empresa/{id}")
	public ResponseEntity<String> deleteEmpresa(@PathVariable("id") int id) {
		try {
			empresaRepository.delete(id);
			return new ResponseEntity<>("Empresa eliminado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
