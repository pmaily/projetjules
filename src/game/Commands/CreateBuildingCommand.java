package game.Commands;

import game.Building.Building;
import game.Commands.interfaces.Command;
import game.Manager.Manager;
import game.utils.enums.BuildingEnum;

public class CreateBuildingCommand implements Command {

	Manager manager;
	BuildingEnum type;

	public CreateBuildingCommand(Manager manager, BuildingEnum type) {
		this.manager = manager;
		this.type = type;
	}
	@Override
	public void execute(){
		manager.createBuilding(type);
	}
}
