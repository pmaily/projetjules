package game.Factory.interfaces;

import game.Building.Building;
import game.utils.enums.BuildingEnum;

public interface BuildingFactory {
    public Building create(BuildingEnum type);
}
