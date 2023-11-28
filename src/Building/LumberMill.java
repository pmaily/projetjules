package Building;

import utils.enums.BuildingEnum;
import utils.enums.ResourceEnum;

public class LumberMill extends Building{
    public LumberMill() {
        nbrHabitants = 0L;
        nbrTravailleurs = 10L;
        maxHabitants = 0L;
        maxTravailleurs = 10L;
        tempsConstruction = 4L;
        type = BuildingEnum.LUMBER_MILL;
        resourceConstruction.put(ResourceEnum.WOOD, 50L);
        resourceConstruction.put(ResourceEnum.STONE, 50L);
        resourceConsommation.put(ResourceEnum.WOOD, 4L);
        resourceProduction.put(ResourceEnum.LUMBER, 4L);
    }

    @Override
    public String getTypeString() {
        return "Lumber Mill";
    }
}
