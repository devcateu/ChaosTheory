package pl.chaos.theory.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.Collection;

/**
 * Contains global utils method.
 */
public class Util {
	/**
	 * Copy collection from source to purpose.
	 *
	 * @param purpose Purpose collection.
	 * @param source  Source Collection.
	 */
	public static <T> void copyCollection(Collection<T> purpose, Collection<T> source) {
		purpose.clear();
		purpose.addAll(source);
	}

	/**
	 * Add JSF message showed in UI for selected UI field.
	 * @param forId UI field id to which this message
	 * @param facesMessage Message type.
	 * @param message Message showed in UI.
	 */
	public static void addMessage(String forId, FacesMessage.Severity facesMessage, String message) {
		FacesContext.getCurrentInstance()
				.addMessage(forId,
						new FacesMessage(facesMessage,
								message, ""));
	}

	/**
	 * Add global JSF message showed in UI.
	 * @param facesMessage Message type.
	 * @param message Message showed in UI.
	 */
	public static void addMessage(FacesMessage.Severity facesMessage, String message) {
		addMessage(null, facesMessage, message);
	}
}
