package Factory;

import Building.*;
import Factory.interfaces.BuildingFactory;
import utils.enums.BuildingEnum;
/*
* Cette classe est une fabriaue de Building, implementant l'interface BuildingFactory
* C'est de cette facon que doit etre implementer le pattern "Factory Method"
* La fonction create sera appele dans le prgm pour creer des batiments
*/
public class BuildingFactoryImpl implements BuildingFactory {

    //cree une instance Building en fonction du type recu en parametre
    //possible car Farm, House.. heritent de Building
    @Override
    public Building create(BuildingEnum type){
        Building building = switch( type ) {
            case BuildingEnum.APPARTMENT_BUILDING -> new ApartmentBuilding();
            case BuildingEnum.FARM -> new Farm();
            case BuildingEnum.HOUSE -> new House();
            case BuildingEnum.LUMBER_MILL -> new LumberMill();
            case BuildingEnum.QUARRY -> new Quarry();
            case BuildingEnum.STEEL_MILL -> new SteelMill();
            case BuildingEnum.TOOL_FACTORY -> new ToolFactory();
            case BuildingEnum.WOODEN_CABIN -> new WoodenCabin();
            case BuildingEnum.CEMENT_PLANT -> new CementPlant();
            //TODO a tester
            default -> throw new RuntimeException( "Format " + type.toString() + " not supported" );
        };

        return building;
    }
}
