package game.Commands;

import game.Commands.interfaces.Command;
import game.Manager.Manager;
import game.utils.enums.BuildingEnum;

public class AddTravailleurCommand implements Command {

	Manager manager;
	BuildingEnum type;
	Long index;

	/**
	 * Constructeur de la classe AddTravailleurCommand
	 *
	 * @param manager Manager qui executera addTravailleur()
	 * @param type    type de Building pour addTravailleur()
	 * @param index   index du Building pour addTravailleur()
	 */
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
