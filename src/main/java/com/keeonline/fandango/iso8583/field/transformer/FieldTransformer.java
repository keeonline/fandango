package com.keeonline.fandango.iso8583.field.transformer;

import com.keeonline.fandango.iso8583.field.spec.FieldSpec;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;

/**
 * Interface that is implemented by all field transformer classes.
 * 
 * The transformation methods are map, parse and fill, their functions being:<br>
 * 
 * map - transforms java object representations of field data into encoded bytes
 * (according to given field characteristics)<br>
 * parse - transforms encoded byte representations of fields into their java object
 * representation<br>
 * fill - returns the encoded byte representation of the default value of a field
 *
 */
public interface FieldTransformer {
	
	String getFieldName();
	String getFieldDescription();
	FieldSpec getFieldSpec();
	
	TransformedField fill() throws FieldTransformerException;
	TransformedField map(Object valueObject) throws FieldTransformerException;
	TransformedField parse(String payload) throws FieldTransformerException;
	TransformedField parse(String payload, int offset) throws FieldTransformerException;
//	TransformedField parse(String payload, int offset, Object [] context) throws FieldTransformerException;

}
