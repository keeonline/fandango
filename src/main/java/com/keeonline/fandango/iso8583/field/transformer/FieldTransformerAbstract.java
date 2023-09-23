package com.keeonline.fandango.iso8583.field.transformer;

import com.keeonline.fandango.iso8583.field.spec.FieldSpec;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;

public class FieldTransformerAbstract implements FieldTransformer {

    private final FieldSpec fieldSpec;

    public FieldTransformerAbstract(FieldSpec fieldSpec) {
        this.fieldSpec = fieldSpec;
    }

    public FieldTransformerAbstract() {
        this.fieldSpec = null;
    }

    @Override
    public String getFieldName() {
        return fieldSpec.getName();
    }

    @Override
    public String getFieldDescription() {
        return fieldSpec.getDescription();
    }

    @Override
    public FieldSpec getFieldSpec() {
        return fieldSpec;
    }

    @Override
    public TransformedField fill() throws FieldTransformerException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'fill'");
    }

    @Override
    public TransformedField map(Object valueObject) throws FieldTransformerException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'map'");
    }

    @Override
    public TransformedField parse(String payload) throws FieldTransformerException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'parse'");
    }

    @Override
    public TransformedField parse(String payload, int offset) throws FieldTransformerException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'parse'");
    }
   
}
