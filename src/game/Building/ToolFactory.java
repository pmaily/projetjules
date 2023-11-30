package game.Building;

import game.utils.enums.BuildingEnum;
import game.utils.enums.ResourceEnum;

public class ToolFactory extends Building{
    public ToolFactory() {
        nbrHabitants = 0L;
        nbrTravailleurs = 0L;
        maxHabitants = 0L;
        maxTravailleurs = 12L;
        tempsConstruction = 8L;
        type = BuildingEnum.TOOL_FACTORY;
        resourceConstruction.put(ResourceEnum.WOOD, 50L);
        resourceConstruction.put(ResourceEnum.STONE, 50L);
        resourceConsommation.put(ResourceEnum.STEEL, 4L);
        resourceConsommation.put(ResourceEnum.COAL, 4L);
        resourceProduction.put(ResourceEnum.TOOLS, 4L);
        consommationResourceConstruction();
    }
}
