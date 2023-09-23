package com.keeonline.fandango.iso8583.field.spec;

import java.util.ArrayList;
import java.util.Collection;

public class ComplexSpec extends FieldSpec {
    private Collection<FieldSpec> fieldSpecs;

    public Collection<FieldSpec> getFieldSpecs() {
        return fieldSpecs;
    }

    public void addFieldSpec(FieldSpec fieldSpec) {
        if (fieldSpecs == null) {
            fieldSpecs = new ArrayList<FieldSpec>();
        }
        fieldSpecs.add(fieldSpec);
    }
    
}