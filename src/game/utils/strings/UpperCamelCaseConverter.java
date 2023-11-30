package game.utils.strings;

public class UpperCamelCaseConverter {
	public static String convertToCamelCase(String inputString) {
		inputString = inputString.replace("_", " ");
		String[] words = inputString.split(" ");

		StringBuilder camelCaseBuilder = new StringBuilder();
		for (int i = 0; i < words.length; i++) {
			camelCaseBuilder.append(' ').append(words[i].substring(0, 1).toUpperCase())
					.append(words[i].substring(1).toLowerCase());
		}
		camelCaseBuilder.deleteCharAt(0);
		return camelCaseBuilder.toString();
	}
}
