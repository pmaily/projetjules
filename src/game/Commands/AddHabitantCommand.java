package game.Commands;

import game.Commands.interfaces.Command;
import game.Manager.Manager;
import game.utils.enums.BuildingEnum;

public class AddHabitantCommand implements Command {

	Manager manager;
	BuildingEnum type;
	Long index;

	/**
	 * Constructeur de la classe AddHabitantCommand
	 * @param manager Manager qui executera addHabitant()
	 * @param type type de Building pour addHabitant()
	 * @param index index du Building pour addHabitant()
	 */
	public AddHabitantCommand(Manager manager, BuildingEnum type, Long index) {
		this.manager = manager;
		this.type = type;
		this.index = index;
	}
	@Override
	public void execute(){
		manager.addHabitant(type, index);
	}
}
