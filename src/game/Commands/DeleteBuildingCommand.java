package game.Commands;

import game.Commands.interfaces.Command;
import game.Manager.Manager;
import game.utils.enums.BuildingEnum;

public class DeleteBuildingCommand implements Command {
	Manager manager;
	BuildingEnum type;
	Long index;

	public DeleteBuildingCommand(Manager manager, BuildingEnum type, Long index) {
		this.manager = manager;
		this.type = type;
		this.index = index;
	}
	@Override
	public void execute(){
		manager.deleteBuilding(type, index);
	}
}
