package game.utils.strings;

public class UpperCamelCaseConverter {

	/**
	 * Convertit une string au format "Camel Case" (en conservant les espaces et remplacent les underscores par des espaces).
	 * @param inputString la string a convertir
	 * @return la string au format "Camel Case"
	 */
	public static String convertToCamelCase(String inputString) {
		inputString = inputString.replace("_", " ");
		String[] words = inputString.split(" ");

		StringBuilder camelCaseBuilder = new StringBuilder();
		for (int i = 0; i < words.length; i++) {
			camelCaseBuilder.append(' ').append(words[i].substring(0, 1).toUpperCase())
					.append(words[i].substring(1).toLowerCase());
		}
		camelCaseBuilder.deleteCharAt(0); //On supprime le 1er espace place inutilement
		return camelCaseBuilder.toString();
	}
}
