package org.usco.agro.usuario_perfil;

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
public class Usuario_perfilController {

	@Autowired
	Usuario_perfilRepository usuario_perfilRepository;

	@PostMapping("/usuario_perfil")
	public ResponseEntity<String> createUsuario_perfil(@RequestBody Usuario_perfil usuario_perfil) {
		try {
			usuario_perfilRepository.create(
					new Usuario_perfil(usuario_perfil.getUsuario_id(), usuario_perfil.getPerfil_id(), usuario_perfil.getEstado()));
			return new ResponseEntity<>("Usuario_perfil creado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/usuario_perfil")
	public ResponseEntity<List<Usuario_perfil>> getAllUsuario_perfils() {
		try {
			ArrayList<Usuario_perfil> usuario_perfils = new ArrayList<Usuario_perfil>();

			usuario_perfilRepository.read().forEach(usuario_perfils::add);

			if (usuario_perfils.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(usuario_perfils, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/usuario_perfil/{id}")
	public ResponseEntity<String> updateUsuario_perfil(@PathVariable("id") int id,
			@RequestBody Usuario_perfil usuario_perfil) {
		try {
			usuario_perfilRepository.update(id,
					new Usuario_perfil(usuario_perfil.getUsuario_id(), usuario_perfil.getPerfil_id(), usuario_perfil.getEstado()));
			return new ResponseEntity<>("Usuario_perfil actualizado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/usuario_perfil/{id}")
	public ResponseEntity<String> deleteUsuario_perfil(@PathVariable("id") int id) {
		try {
			usuario_perfilRepository.delete(id);
			return new ResponseEntity<>("Usuario_perfil eliminado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
