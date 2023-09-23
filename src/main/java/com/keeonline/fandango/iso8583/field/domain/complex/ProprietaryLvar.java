package com.keeonline.fandango.iso8583.field.domain.complex;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.keeonline.fandango.gson.typeadapters.RuntimeTypeAdapterFactory;

/**
 * 
 * Abstract base class that enables Json serialisation and deserialisation
 * of proprietary scheme types.
 *
 */
public abstract class ProprietaryLvar {
	
	private String type;
	
	public ProprietaryLvar() {
		this.type = this.getClass().getSimpleName();
	}
	
	public String getType() {
		return type;
	}

	public Gson getGson(){
		RuntimeTypeAdapterFactory<ProprietaryLvar> factory;
		Gson bob;
		factory = RuntimeTypeAdapterFactory
				.of(ProprietaryLvar.class, "type")
				.registerSubtype(this.getClass(), type);
		bob = new GsonBuilder().registerTypeAdapterFactory(factory).create();
		return bob;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ProprietaryLvar))
			return false;
		ProprietaryLvar other = (ProprietaryLvar) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	public abstract String toEncoded();

	public abstract void fromEncoded(String encoded);

}
