package game.Commands;

import game.Building.Building;
import game.Commands.interfaces.Command;
import game.Manager.Manager;
import game.utils.enums.BuildingEnum;

public class AddTravailleurCommand implements Command {

	Manager manager;
	BuildingEnum type;
	Long index;

	public AddTravailleurCommand(Manager manager, BuildingEnum type, Long index) {
		this.manager = manager;
		this.type = type;
		this.index = index;
	}
	@Override
	public void execute(){
		manager.addTravailleur(type, index);
	}
}
