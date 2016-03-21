package br.jus.tjpe.infosistelecom.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter("br.jus.tjpe.infosistelecom.converter.FoneConverter")
public class FoneConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
//		String fonePattern = "("+value.substring(0, 1)+")"+value.substring(2, 5)+"-"+value.substring(6, 9);
		return value;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		String valueString = (String)value;
		String fonePattern = "("+valueString.substring(0, 2)+") "+valueString.substring(2, 6)+"-"+valueString.substring(6, 10);
		return fonePattern;
	}

}
