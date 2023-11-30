package game.Building;

import game.utils.enums.BuildingEnum;
import game.utils.enums.ResourceEnum;

public class Farm extends Building{
    public Farm() {
        nbrHabitants = 0L;
        nbrTravailleurs = 0L;
        maxHabitants = 5L;
        maxTravailleurs = 3L;
        tempsConstruction = 2L;
        type = BuildingEnum.FARM;
        resourceConstruction.put(ResourceEnum.WOOD, 5L);
        resourceConstruction.put(ResourceEnum.STONE, 5L);
        resourceProduction.put(ResourceEnum.FOOD, 10L);
        consommationResourceConstruction();
    }
}
