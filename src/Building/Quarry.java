package Building;

import utils.enums.BuildingEnum;
import utils.enums.ResourceEnum;

public class Quarry extends Building{
    public Quarry() {
        nbrHabitants = 2L;
        nbrTravailleurs = 30L;
        maxHabitants = 2L;
        maxTravailleurs = 30L;
        tempsConstruction = 2L;
        type = BuildingEnum.QUARRY;
        resourceConstruction.put(ResourceEnum.WOOD, 50L);
        resourceProduction.put(ResourceEnum.STONE, 4L);
        resourceProduction.put(ResourceEnum.IRON, 4L);
        resourceProduction.put(ResourceEnum.COAL, 4L);
    }

    @Override
    public String getTypeString() {
        return "Quarry";
    }
}
