package game.Factory;

import game.Building.ApartmentBuilding;
import game.Building.Building;
import game.Building.CementPlant;
import game.Building.Farm;
import game.Building.House;
import game.Building.LumberMill;
import game.Building.Quarry;
import game.Building.SteelMill;
import game.Building.ToolFactory;
import game.Building.WoodenCabin;
import game.Commands.AddHabitantCommand;
import game.Commands.AddTravailleurCommand;
import game.Commands.CreateBuildingCommand;
import game.Commands.DeleteBuildingCommand;
import game.Commands.DeleteHabitantCommand;
import game.Commands.DeleteTravailleurCommand;
import game.Commands.interfaces.Command;
import game.Factory.interfaces.CommandFactory;
import game.Manager.Manager;
import game.utils.enums.BuildingEnum;
import game.utils.enums.CommandEnum;

/*
* Cette classe est une fabriaue de game.Building, implementant l'interface BuildingFactory
* C'est de cette facon que doit etre implementer le pattern "game.Factory Method"
* La fonction create sera appele dans le prgm pour creer des batiments
*/
public class CommandFactoryImpl implements CommandFactory {
    //cree une instance Building en fonction du type recu en parametre
    //possible car Farm, House.. heritent de Building
    @Override
    public Command create(CommandEnum commandType, BuildingEnum buildingType, Long index, Manager manager) throws IllegalArgumentException{
        return switch( commandType ) {
            case CommandEnum.ADD_HABITANT -> new AddHabitantCommand(manager, buildingType, index);
            case CommandEnum.ADD_TRAVAILLEUR -> new AddTravailleurCommand(manager, buildingType, index);
            case CommandEnum.DELETE_HABITANT -> new DeleteHabitantCommand(manager, buildingType, index);
            case CommandEnum.DELETE_TRAVAILLEUR -> new DeleteTravailleurCommand(manager, buildingType, index);
            case CommandEnum.CREATE_BUILDING -> new CreateBuildingCommand(manager, buildingType);
            case CommandEnum.DELETE_BUILDING -> new DeleteBuildingCommand(manager, buildingType, index);
            default -> throw new IllegalArgumentException( "Argument " + commandType.toString() + " not supported" );
        };
    }
}
