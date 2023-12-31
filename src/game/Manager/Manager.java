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

	/**
	 * Constructeur de la classe Manager.
	 */
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
		buildings.put(BuildingEnum.TOOL_FACTORY, new ArrayList<>());
		buildingFactory = new BuildingFactoryImpl();
		commandFactory = new CommandFactoryImpl();
	}

	/**
	 * Creer un Building
	 * @param type le type de building a creer
	 */
	public void createBuilding(BuildingEnum type) {
		Building newbuilding = buildingFactory.create(type);
		buildings.get(type).add(newbuilding);
		this.addObserver(newbuilding);
		newDay();
	}

	/**
	 * Supprime un building
	 * @param type Le type de building a supprimer
	 * @param index L'index du building a supprimer
	 */
	public void deleteBuilding(BuildingEnum type, Long index) {
		buildings.get(type).remove(index.intValue());
		newDay();
	}

	/**
	 * Ajoute un habitant a un building
	 * @param type Type de building
	 * @param index Index du building
	 */
	public void addHabitant(BuildingEnum type, Long index) {
		getOneBuilding(type, index).addHabitant();
		newDay();
	}

	/**
	 * Supprime un travailleur
	 * @param type Type de building
	 * @param index Index du building
	 */
	public void deleteHabitant(BuildingEnum type, Long index) {
		getOneBuilding(type, index).deleteHabitant();
		newDay();
	}

	/**
	 * Ajoute un travailleur
	 * @param type Type de building
	 * @param index Index du building
	 * @throws IllegalStateException si il n' y a pas d'habitant disponible
	 */
	public void addTravailleur(BuildingEnum type, Long index) {
		if (getNbrHabitantsAffectable() <= 0)
			throw new IllegalStateException("Vous rajoutez un travailleur dans un batiment alors qu'il n'y a plus d'habitant disponible");
		getOneBuilding(type, index).addTravailleur();
		newDay();
	}

	/**
	 * Supprime un travailleur
	 * @param type Type de building
	 * @param index Index du building
	 */
	public void deleteTravailleur(BuildingEnum type, Long index) {
		getOneBuilding(type, index).deleteTravailleur();
		newDay();
	}

	/**
	 * Getter d'un building specifique
	 * @param type Type de building
	 * @param index Index du building
	 * @return Building
	 */
	private Building getOneBuilding(BuildingEnum type, Long index) {
		return buildings.get(type).get(index.intValue());

	}

	/**
	 * Notifie tous les Observer (buildings) d'un changement (nouvele journee)
	 */
	private void newDay() { //respecte le design pattern Observer
		setChanged();
		this.notifyObservers();
	}

	/**
	 * Execute une Commande
	 * @param commandType Type de commande a executer
	 * @param buildingType Type de building pour lequel sera execute la commande
	 * @param index Index du building pour lequel sera execute la commande
	 */
	public void executeCommand(CommandEnum commandType, BuildingEnum buildingType, Long index) {
		Command command = commandFactory.create(commandType, buildingType, index, this);
		command.execute();
	}

	/**
	 * @return Le nombre d'habitants sans travail
	 */
	public Long getNbrHabitantsAffectable() {
		Long totalHabitants = 0L;
		Long totalTravailleurs = 0L;

		for (Map.Entry<BuildingEnum, List<Building>> buildingsByType : buildings.entrySet()) {
			for (Building building : buildingsByType.getValue()) {
				totalHabitants += building.getNbrHabitants();
				totalTravailleurs += building.getNbrTravailleurs();
			}
		}

		return totalHabitants - totalTravailleurs;
	}

	/**
	 * Getter de buildings
	 * @return buildings
	 */
	final public Map<BuildingEnum, List<Building>> getBuildings() {
		return buildings;
	}
}
