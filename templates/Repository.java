package $PACKAGE_NAME$.$OBJECT_NAME$;


import java.util.List;

public interface $CLASS_NAME$Repository {
	
	public int create ($CLASS_NAME$ $OBJECT_NAME$);
	
	public List<$CLASS_NAME$> read ();
	
	public int update ($PK_ATTRIBUTE_DATA_TYPE$ $PK_ATTRIBUTE_NAME$, $CLASS_NAME$ $OBJECT_NAME$);
	
	public int delete ($PK_ATTRIBUTE_DATA_TYPE$ $PK_ATTRIBUTE_NAME$);

}
