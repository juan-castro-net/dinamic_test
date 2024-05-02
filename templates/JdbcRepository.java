package $PACKAGE_NAME$.$OBJECT_NAME$;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class Jdbc$CLASS_NAME$Repository implements $CLASS_NAME$Repository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String CREATE_SQL = $CREATE_SQL$
	String READ_SQL = $READ_SQL$
	String UPDATE_SQL = $UPDATE_SQL$
	String DELETE_SQL = $DELETE_SQL$

	@Override
	public int create($CLASS_NAME$ $OBJECT_NAME$) {
		return jdbcTemplate.update(CREATE_SQL,
				new Object[] { $OBJECT_GETTERS$ });
	}

	@Override
	public List<$CLASS_NAME$> read() {
		return jdbcTemplate.query(READ_SQL, BeanPropertyRowMapper.newInstance($CLASS_NAME$.class));
	}

	@Override
	public int update($PK_ATTRIBUTE_DATA_TYPE$ $PK_ATTRIBUTE_NAME$, $CLASS_NAME$ $OBJECT_NAME$) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] { $OBJECT_GETTERS$, $PK_ATTRIBUTE_NAME$ });
	}

	@Override
	public int delete($PK_ATTRIBUTE_DATA_TYPE$ $PK_ATTRIBUTE_NAME$) {
		return jdbcTemplate.update(DELETE_SQL, $PK_ATTRIBUTE_NAME$);
	}

}
