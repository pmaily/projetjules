package Building;

import utils.enums.BuildingEnum;
import utils.enums.ResourceEnum;

public class ToolFactory extends Building{
    public ToolFactory() {
        nbrHabitants = 0L;
        nbrTravailleurs = 12L;
        maxHabitants = 0L;
        maxTravailleurs = 12L;
        tempsConstruction = 8L;
        type = BuildingEnum.TOOL_FACTORY;
        resourceConstruction.put(ResourceEnum.WOOD, 50L);
        resourceConstruction.put(ResourceEnum.STONE, 50L);
        resourceConsommation.put(ResourceEnum.STEEL, 4L);
        resourceConsommation.put(ResourceEnum.COAL, 4L);
        resourceProduction.put(ResourceEnum.TOOLS, 4L);
    }

    @Override
    public String getTypeString() {
        return "Tool Factory";
    }
}
