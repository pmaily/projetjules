package game.Building;

import game.utils.enums.BuildingEnum;
import game.utils.enums.ResourceEnum;

public class SteelMill extends Building {
	public SteelMill() {
		nbrHabitants = 0L;
		nbrTravailleurs = 0L;
		maxHabitants = 0L;
		maxTravailleurs = 40L;
		tempsConstruction = 6L;
		type = BuildingEnum.STEEL_MILL;
		resourceConstruction.put(ResourceEnum.WOOD, 100L);
		resourceConstruction.put(ResourceEnum.STONE, 50L);
		resourceConsommation.put(ResourceEnum.IRON, 4L);
		resourceConsommation.put(ResourceEnum.COAL, 2L);
		resourceProduction.put(ResourceEnum.STEEL, 4L);
		consommationResourceConstruction();
	}
}
