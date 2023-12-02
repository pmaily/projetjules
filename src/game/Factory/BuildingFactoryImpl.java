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
import game.Factory.interfaces.BuildingFactory;
import game.utils.enums.BuildingEnum;

/**
 * Cette classe est une fabriaue de game.Building, implementant l'interface BuildingFactory
 * C'est de cette facon que doit etre implementer le pattern "game.Factory Method"
 * La fonction create sera appele dans le prgm pour creer des batiments
 */
public class BuildingFactoryImpl implements BuildingFactory {


	//cree une instance Building en fonction du type recu en parametre
	//possible car Farm, House.. heritent de Building
	@Override
	public Building create(BuildingEnum type) {
		return switch (type) {
			case BuildingEnum.APARTMENT_BUILDING -> new ApartmentBuilding();
			case BuildingEnum.FARM -> new Farm();
			case BuildingEnum.HOUSE -> new House();
			case BuildingEnum.LUMBER_MILL -> new LumberMill();
			case BuildingEnum.QUARRY -> new Quarry();
			case BuildingEnum.STEEL_MILL -> new SteelMill();
			case BuildingEnum.TOOL_FACTORY -> new ToolFactory();
			case BuildingEnum.WOODEN_CABIN -> new WoodenCabin();
			case BuildingEnum.CEMENT_PLANT -> new CementPlant();
			default -> throw new IllegalArgumentException("Argument " + type.toString() + " not supported");
		};
	}
}
