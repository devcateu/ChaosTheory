package pl.chaos.theory.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.Collection;

public class Util {
	public static <T> void copyCollection(Collection<T> purpose, Collection<T> source) {
		purpose.clear();
		purpose.addAll(source);
	}

	public static void addMessage(String forId, FacesMessage.Severity facesMessage, String message) {
		FacesContext.getCurrentInstance().addMessage(
				forId,
				new FacesMessage(facesMessage,
						message, ""));
	}

	public static void addMessage(FacesMessage.Severity facesMessage, String message) {
		addMessage(null, facesMessage, message);
	}
}
