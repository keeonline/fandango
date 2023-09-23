package com.keeonline.fandango.iso8583.message.transformer;

import java.util.ArrayList;
import java.util.Collection;

import com.keeonline.fandango.iso8583.field.spec.FieldSpec;

public class MessageSpec {
    private String name;
    private String description;
    private FieldSpec mtiFieldSpec;
    private FieldSpec primaryBitmapFieldSpec;
    private Collection<FieldSpec> fieldSpecs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public FieldSpec getMtiFieldSpec() {
        return mtiFieldSpec;
    }

    public void setMtiFieldSpec(FieldSpec mtiFieldSpec) {
        this.mtiFieldSpec = mtiFieldSpec;
    }

    public FieldSpec getPrimaryBitmapFieldSpec() {
        return primaryBitmapFieldSpec;
    }

    public void setPrimaryBitmapFieldSpec(FieldSpec primaryBitmapFieldSpec) {
        this.primaryBitmapFieldSpec = primaryBitmapFieldSpec;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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