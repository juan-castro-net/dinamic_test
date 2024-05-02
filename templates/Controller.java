package $PACKAGE_NAME$.$OBJECT_NAME$;

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
public class $CLASS_NAME$Controller {

	@Autowired
	$CLASS_NAME$Repository $OBJECT_NAME$Repository;

	@PostMapping("/$OBJECT_NAME$")
	public ResponseEntity<String> create$CLASS_NAME$(@RequestBody $CLASS_NAME$ $OBJECT_NAME$) {
		try {
			$OBJECT_NAME$Repository.create(
					new $CLASS_NAME$($OBJECT_GETTERS$));
			return new ResponseEntity<>("$CLASS_NAME$ creado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/$OBJECT_NAME$")
	public ResponseEntity<List<$CLASS_NAME$>> getAll$CLASS_NAME$s() {
		try {
			ArrayList<$CLASS_NAME$> $OBJECT_NAME$s = new ArrayList<$CLASS_NAME$>();

			$OBJECT_NAME$Repository.read().forEach($OBJECT_NAME$s::add);

			if ($OBJECT_NAME$s.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>($OBJECT_NAME$s, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/$OBJECT_NAME$/{id}")
	public ResponseEntity<String> update$CLASS_NAME$(@PathVariable("id") int id,
			@RequestBody $CLASS_NAME$ $OBJECT_NAME$) {
		try {
			$OBJECT_NAME$Repository.update(id,
					new $CLASS_NAME$($OBJECT_GETTERS$));
			return new ResponseEntity<>("$CLASS_NAME$ actualizado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/$OBJECT_NAME$/{id}")
	public ResponseEntity<String> delete$CLASS_NAME$(@PathVariable("id") int id) {
		try {
			$OBJECT_NAME$Repository.delete(id);
			return new ResponseEntity<>("$CLASS_NAME$ eliminado con exito", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
