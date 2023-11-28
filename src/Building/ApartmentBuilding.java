package Building;

import utils.enums.BuildingEnum;
import utils.enums.ResourceEnum;

public class ApartmentBuilding extends Building{

    public ApartmentBuilding(){
        nbrHabitants = 60L;
        nbrTravailleurs = 0L;
        maxHabitants = 60L;
        maxTravailleurs = 0L;
        tempsConstruction = 6L;
        type = BuildingEnum.APPARTMENT_BUILDING;
        resourceConstruction.put(ResourceEnum.WOOD, 50L);
        resourceConstruction.put(ResourceEnum.STONE, 50L);
    }

    @Override
    public String getTypeString() {
        return "Apartment Building";
    }
}
