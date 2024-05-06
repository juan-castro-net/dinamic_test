package org.usco.test.usuario;

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
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;

	@PostMapping("/usuario")
	public ResponseEntity<String> createUsuario(@RequestBody Usuario usuario) {
		try {
			usuarioRepository.create(
					new Usuario(usuario.getLogin_username(), usuario.getPersona(), usuario.getEstado()));
			return new ResponseEntity<>("Usuario creado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/usuario")
	public ResponseEntity<List<Usuario>> getAllUsuarios() {
		try {
			ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

			usuarioRepository.read().forEach(usuarios::add);

			if (usuarios.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(usuarios, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/usuario/{id}")
	public ResponseEntity<String> updateUsuario(@PathVariable("id") int id,
			@RequestBody Usuario usuario) {
		try {
			usuarioRepository.update(id,
					new Usuario(usuario.getLogin_username(), usuario.getPersona(), usuario.getEstado()));
			return new ResponseEntity<>("Usuario actualizado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/usuario/{id}")
	public ResponseEntity<String> deleteUsuario(@PathVariable("id") int id) {
		try {
			usuarioRepository.delete(id);
			return new ResponseEntity<>("Usuario eliminado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
