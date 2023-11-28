package Factory.interfaces;

import Building.Building;
import utils.enums.BuildingEnum;

public interface BuildingFactory {
    public Building create(BuildingEnum type);
}
