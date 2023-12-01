package game.Factory.interfaces;

import game.Building.Building;
import game.Commands.interfaces.Command;
import game.Manager.Manager;
import game.utils.enums.BuildingEnum;
import game.utils.enums.CommandEnum;

public interface CommandFactory {

    /**
     * Cree une Command
     * @param commandType type de commande a creer
     * @param buildingType type de building sur lequel la commande sera executee
     * @param index index du building sur lequel la commande sera executee
     * @param manager Manager qui executera la commande
     * @return Command
     */
    public Command create(CommandEnum commandType, BuildingEnum buildingType, Long index, Manager manager);
}
