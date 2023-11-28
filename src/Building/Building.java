package Building;

import Resource.Resource;
import utils.enums.BuildingEnum;
import utils.enums.ResourceEnum;

import java.util.HashMap;
import java.util.Map;

public abstract class Building {

    protected BuildingEnum type;
    protected Long nbrHabitants;
    protected Long nbrTravailleurs;
    protected Long maxHabitants;
    protected Long maxTravailleurs;
    protected Long tempsConstruction;
    protected Long tempsDepuisConstruction;
    protected Resource resources;
    protected Map<ResourceEnum, Long> resourceProduction;
    protected Map<ResourceEnum, Long> resourceConsommation;
    protected Map<ResourceEnum, Long> resourceConstruction;

    public Building() {
        resources = Resource.getInstance(); //on recupere l'instance unique de Resource (Singleton)
        resourceConsommation = new HashMap<>();
        resourceConstruction = new HashMap<>();
        resourceProduction = new HashMap<>();
        tempsDepuisConstruction = 0L;
    }

    public boolean isBuilt() {
        return tempsDepuisConstruction > tempsConstruction;
    }
    
    public void newDay(){
        tempsDepuisConstruction++;
        if (!isBuilt())
            return;

        for (Map.Entry<ResourceEnum, Long> entry : resourceProduction.entrySet()) {
            resources.addQuantity(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<ResourceEnum, Long> entry : resourceConsommation.entrySet()) {
            resources.reduceQuantity(entry.getKey(), entry.getValue());
        }
    }

    public BuildingEnum getType() {
        return type;
    }

    public Long getNbrHabitants() {
        return nbrHabitants;
    }

    public Long getNbrTravailleurs() {
        return nbrTravailleurs;
    }

    public abstract String getTypeString();
}
