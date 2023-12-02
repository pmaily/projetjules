package game.Building;

import game.utils.enums.BuildingEnum;
import game.utils.enums.ResourceEnum;

public class CementPlant extends Building {
	public CementPlant() {
		nbrHabitants = 0L;
		nbrTravailleurs = 0L;
		maxHabitants = 0L;
		maxTravailleurs = 10L;
		tempsConstruction = 4L;
		type = BuildingEnum.CEMENT_PLANT;
		resourceConstruction.put(ResourceEnum.WOOD, 50L);
		resourceConstruction.put(ResourceEnum.STONE, 50L);
		resourceConsommation.put(ResourceEnum.COAL, 4L);
		resourceConstruction.put(ResourceEnum.STONE, 4L);
		resourceProduction.put(ResourceEnum.CEMENT, 4L);
		consommationResourceConstruction();
	}
}
