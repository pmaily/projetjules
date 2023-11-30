package game.Factory.interfaces;

import game.Building.Building;
import game.Commands.interfaces.Command;
import game.Manager.Manager;
import game.utils.enums.BuildingEnum;
import game.utils.enums.CommandEnum;

public interface CommandFactory {
    public Command create(CommandEnum commandType, BuildingEnum buildingType, Long index, Manager manager);
}
