package game.Commands;

import game.Commands.interfaces.Command;
import game.Manager.Manager;
import game.utils.enums.BuildingEnum;

public class DeleteBuildingCommand implements Command {
	Manager manager;
	BuildingEnum type;
	Long index;


	/**
	 * Constructeur de la classe DeleteBuildingCommand
	 * @param manager Manager qui executera deleteBuilding()
	 * @param type type de Building pour deleteBuilding()
	 * @param index index du Building pour deleteBuilding()
	 */
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
