package game.utils.enums;

import game.utils.strings.UpperCamelCaseConverter;

public enum CommandEnum {

	ADD_HABITANT,

	ADD_TRAVAILLEUR,

	DELETE_HABITANT,
	DELETE_TRAVAILLEUR,

	CREATE_BUILDING,

	DELETE_BUILDING;

	@Override
	public String toString() {
		return UpperCamelCaseConverter.convertToCamelCase(super.toString());
	}
}
