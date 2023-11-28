package Building;

import utils.enums.BuildingEnum;
import utils.enums.ResourceEnum;

public class WoodenCabin extends Building{
    public WoodenCabin() {
        nbrHabitants = 2L;
        nbrTravailleurs = 2L;
        maxHabitants = 2L;
        maxTravailleurs = 2L;
        tempsConstruction = 2L;
        type = BuildingEnum.WOODEN_CABIN;
        resourceConstruction.put(ResourceEnum.WOOD, 1L);
        resourceProduction.put(ResourceEnum.WOOD, 2L);
        resourceProduction.put(ResourceEnum.FOOD, 2L);
    }

    @Override
    public String getTypeString() {
        return "Wooden Cabin";
    }
}
