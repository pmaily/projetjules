package Building;

import utils.enums.BuildingEnum;
import utils.enums.ResourceEnum;

public class Farm extends Building{
    public Farm() {
        nbrHabitants = 5L;
        nbrTravailleurs = 3L;
        maxHabitants = 5L;
        maxTravailleurs = 3L;
        tempsConstruction = 2L;
        type = BuildingEnum.FARM;
        resourceConstruction.put(ResourceEnum.WOOD, 5L);
        resourceConstruction.put(ResourceEnum.STONE, 5L);
        resourceProduction.put(ResourceEnum.FOOD, 10L);
    }

    @Override
    public String getTypeString() {
        return "Farm";
    }
}
