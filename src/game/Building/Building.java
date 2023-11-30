package game.Building;

import game.Resources.Resources;
import game.utils.enums.BuildingEnum;
import game.utils.enums.ResourceEnum;

import javax.management.BadAttributeValueExpException;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public abstract class Building implements Observer {

    protected BuildingEnum type;
    protected Long nbrHabitants;
    protected Long nbrTravailleurs;
    protected Long maxHabitants;
    protected Long maxTravailleurs;
    protected Long tempsConstruction;
    protected Long tempsDepuisConstruction;
    protected Resources resources;
    protected Map<ResourceEnum, Long> resourceProduction;
    protected Map<ResourceEnum, Long> resourceConsommation;
    protected Map<ResourceEnum, Long> resourceConstruction;

    protected Building() {
        resources = Resources.getInstance(); //on recupere l'instance unique de game.Resource (Singleton)
        resourceConsommation = new HashMap<>();
        resourceConstruction = new HashMap<>();
        resourceProduction = new HashMap<>();
        tempsDepuisConstruction = 0L;
    }

    public void addHabitant(){
        nbrHabitants++;
        if (nbrHabitants > nbrTravailleurs)
            throw new IllegalStateException("Le nombre d'habitants est passé au dessus de la limite du batiment, fin du programme.");
    }

    public void addTravailleur(){
        nbrTravailleurs++;
        if (nbrHabitants > nbrTravailleurs)
            throw new IllegalStateException("Le nombre de travailleurs est passé au dessus de la limite du batiment, fin du programme.");
    }

    public void deleteHabitant(){
        nbrHabitants--;
        if (nbrHabitants < 0)
            throw new IllegalStateException("Le nombre d'habitants est passé en dessous de 0, fin du programme.");
    }

    public void deleteTravailleur(){
        nbrTravailleurs--;
        if (nbrHabitants < 0)
            throw new IllegalStateException("Le nombre de travailleurs est passé en dessous de 0, fin du programme.");
    }

    public Float quotaNbrTravailleurs() {
        return nbrTravailleurs.floatValue() / maxTravailleurs.floatValue();
    }

    public boolean isBuilt() {
        return tempsDepuisConstruction > tempsConstruction;
    }

    @Override
    public void update(Observable o, Object arg){
        tempsDepuisConstruction++;
        if (!isBuilt())
            return;

        for (Map.Entry<ResourceEnum, Long> entry : resourceProduction.entrySet()) {
            Float amountResource = entry.getValue() * quotaNbrTravailleurs();
            resources.addQuantity(entry.getKey(), amountResource.longValue());
        }
        for (Map.Entry<ResourceEnum, Long> entry : resourceConsommation.entrySet()) {
            Float amountResource = entry.getValue() * quotaNbrTravailleurs();
            resources.reduceQuantity(entry.getKey(), amountResource.longValue());
        }
        resources.reduceQuantity(ResourceEnum.FOOD, nbrHabitants);
    }

    protected void consommationResourceConstruction() {
        for (Map.Entry<ResourceEnum, Long> entry : resourceConstruction.entrySet()) {
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
}
