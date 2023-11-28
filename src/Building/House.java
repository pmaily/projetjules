package Building;

import utils.enums.BuildingEnum;
import utils.enums.ResourceEnum;

public class House extends Building{
    public House() {
        nbrHabitants = 4L;
        nbrTravailleurs = 0L;
        maxHabitants = 4L;
        maxTravailleurs = 0L;
        tempsConstruction = 4L;
        type = BuildingEnum.HOUSE;
        resourceConstruction.put(ResourceEnum.WOOD, 2L);
        resourceConstruction.put(ResourceEnum.STONE, 2L);
    }

    @Override
    public String getTypeString() {
        return "House";
    }
}
