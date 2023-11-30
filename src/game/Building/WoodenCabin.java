package game.Building;

import game.utils.enums.BuildingEnum;
import game.utils.enums.ResourceEnum;

public class WoodenCabin extends Building{
    public WoodenCabin() {
        nbrHabitants = 0L;
        nbrTravailleurs = 0L;
        maxHabitants = 2L;
        maxTravailleurs = 2L;
        tempsConstruction = 2L;
        type = BuildingEnum.WOODEN_CABIN;
        resourceConstruction.put(ResourceEnum.WOOD, 1L);
        resourceProduction.put(ResourceEnum.WOOD, 2L);
        resourceProduction.put(ResourceEnum.FOOD, 2L);
        consommationResourceConstruction();
    }
}
