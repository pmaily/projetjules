package game.Factory.interfaces;

import game.Building.Building;
import game.utils.enums.BuildingEnum;

public interface BuildingFactory {

    /**
     * Cree un Building
     * @param type Building a creer
     * @return Building
     */
    public Building create(BuildingEnum type);
}
