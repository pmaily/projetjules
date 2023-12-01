package game.Commands;

import game.Building.Building;
import game.Commands.interfaces.Command;
import game.Manager.Manager;
import game.utils.enums.BuildingEnum;

public class DeleteHabitantCommand implements Command {

	Manager manager;
	BuildingEnum type;
	Long index;

	/**
	 * Constructeur de la classe DeleteHabitantCommand
	 * @param manager Manager qui executera deleteHabitant()
	 * @param type type de Building pour deleteHabitant()
	 * @param index index du Building pour deleteHabitant()
	 */
	public DeleteHabitantCommand(Manager manager, BuildingEnum type, Long index) {
		this.manager = manager;
		this.type = type;
		this.index = index;
	}
	@Override
	public void execute(){
		manager.deleteHabitant(type, index);
	}
}
