package game.utils.enums;

import game.utils.strings.UpperCamelCaseConverter;

public enum ResourceEnum {
	CEMENT,
	COAL,
	FOOD,
	IRON,
	LUMBER,
	STEEL,
	STONE,
	TOOLS,
	WOOD;

	@Override
	public String toString() {
		return UpperCamelCaseConverter.convertToCamelCase(super.toString());
	}
}
