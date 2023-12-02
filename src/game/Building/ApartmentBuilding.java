package game.Building;

import game.utils.enums.BuildingEnum;
import game.utils.enums.ResourceEnum;

public class ApartmentBuilding extends Building {

	public ApartmentBuilding() {
		nbrHabitants = 0L;
		nbrTravailleurs = 0L;
		maxHabitants = 60L;
		maxTravailleurs = 0L;
		tempsConstruction = 6L;
		type = BuildingEnum.APARTMENT_BUILDING;
		resourceConstruction.put(ResourceEnum.WOOD, 50L);
		resourceConstruction.put(ResourceEnum.STONE, 50L);
		consommationResourceConstruction();
	}
}
