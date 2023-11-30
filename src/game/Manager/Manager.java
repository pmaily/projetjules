package game.Manager;

import game.Building.Building;
import game.Commands.interfaces.Command;
import game.Factory.BuildingFactoryImpl;
import game.Factory.CommandFactoryImpl;
import game.Factory.interfaces.BuildingFactory;
import game.Factory.interfaces.CommandFactory;
import game.utils.enums.BuildingEnum;
import game.utils.enums.CommandEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;

public class Manager extends Observable {
	CommandFactory commandFactory;

	BuildingFactory buildingFactory;

	Map<BuildingEnum, List<Building>> buildings;

	public Manager() {
		buildings = new HashMap<>();
		buildings.put(BuildingEnum.FARM, new ArrayList<>());
		buildings.put(BuildingEnum.HOUSE, new ArrayList<>());
		buildings.put(BuildingEnum.APARTMENT_BUILDING, new ArrayList<>());
		buildings.put(BuildingEnum.QUARRY, new ArrayList<>());
		buildings.put(BuildingEnum.CEMENT_PLANT, new ArrayList<>());
		buildings.put(BuildingEnum.LUMBER_MILL, new ArrayList<>());
		buildings.put(BuildingEnum.STEEL_MILL, new ArrayList<>());
		buildings.put(BuildingEnum.WOODEN_CABIN, new ArrayList<>());
		buildingFactory = new BuildingFactoryImpl();
		commandFactory = new CommandFactoryImpl();
	}

	public void createBuilding(BuildingEnum type) {
		Building newbuilding = buildingFactory.create(type);
		buildings.get(type).add(newbuilding);
		this.addObserver(newbuilding);
		newDay();
	}

	public void deleteBuilding(BuildingEnum type, Long index) {
		buildings.get(type).remove(index.intValue());
		newDay();
	}

	public void addHabitant(BuildingEnum type, Long index) {
		getOneBuilding(type, index).addHabitant();
	}

	public void deleteHabitant(BuildingEnum type, Long index) {
		getOneBuilding(type, index).deleteHabitant();
	}

	public void addTravailleur(BuildingEnum type, Long index) {
		getOneBuilding(type, index).addTravailleur();
	}

	public void deleteTravailleur(BuildingEnum type, Long index) {
		getOneBuilding(type, index).deleteTravailleur();
	}

	private Building getOneBuilding(BuildingEnum type, Long index) {
		return buildings.get(type).get(index.intValue());
	}

	private void newDay() {
		setChanged();
		this.notifyObservers();
	}

	public void executeCommand(CommandEnum commandType, BuildingEnum buildingType, Long index) {
		Command command = commandFactory.create(commandType, buildingType, index, this);
		command.execute();
		newDay();
	}

	final public Map<BuildingEnum, List<Building>> getBuildings() {
		return buildings;
	}
}
