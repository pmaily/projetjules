package game.utils.enums;

import game.utils.strings.UpperCamelCaseConverter;

public enum BuildingEnum {
    APARTMENT_BUILDING,
    CEMENT_PLANT,
    FARM,
    HOUSE,
    LUMBER_MILL,
    QUARRY,
    STEEL_MILL,
    TOOL_FACTORY,
    WOODEN_CABIN;

    @Override
    public String toString() {
        return UpperCamelCaseConverter.convertToCamelCase(super.toString());
    }
}