package com.keeonline.fandango.iso8583.field.spec;

import java.util.HashMap;
import java.util.Map;

public class PrimitiveSpec extends FieldSpec {
    // private String type;
    private Map<String,String> attributes = new HashMap<String,String>();
    
    public PrimitiveSpec() {
        super();
    }

    // public PrimitiveSpec(String type) {
    //     this.type = type;
    // }

    // public String getType() {
    //     return type;
    // }

    public Map<String,String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String,String> attributes) {
        this.attributes = attributes;
    }

    public void addAttribute(String name,String value) {
        attributes.put(name,value);
    }

}
