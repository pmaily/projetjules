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

    /**
     * Ajoute un habitant
     * @throws IllegalStateException si le nombre d'habitants depasse maxHabitants
     */
    public void addHabitant(){
        if (nbrHabitants >= maxHabitants)
            throw new IllegalStateException("Le nombre d'habitants est deja au maximum pour ce batiment.");
        nbrHabitants++;
    }

    /**
     * Ajoute un travailleur
     * @throws IllegalStateException si le nombre de travailleurs depasse maxTravailleurs
     */
    public void addTravailleur(){
        if (nbrTravailleurs >= maxTravailleurs)
            throw new IllegalStateException("Le nombre de travailleurs est deja au maximum pour ce batiment.");
        nbrTravailleurs++;
    }

    /**
     * supprime un habitant
     * @throws IllegalStateException si le nombre d'habitants passe en dessous de zero
     */
    public void deleteHabitant(){
        if (nbrHabitants <= 0)
            throw new IllegalStateException("Le nombre d'habitants est de 0, vous ne pouvez pas en retirer.");
        nbrHabitants--;
    }

    /**
     * supprime un travailleur
     * @throws IllegalStateException si le nombre de travailleurs passe en dessous de zero
     */
    public void deleteTravailleur(){
        if (nbrHabitants <= 0)
            throw new IllegalStateException("Le nombre de travailleurs est de 0, vous ne pouvez pas en retirer.");
        nbrTravailleurs--;
    }

    /**
     * @return Le nombre de travailleurs par rapport au maximum possible sour la forme d'un pourcentage compris entre 0 et 1
     */
    public Float quotaNbrTravailleurs() {
        return nbrTravailleurs.floatValue() / maxTravailleurs.floatValue();
    }

    /**
     * @return Boolean qui indique si le batiment est construit ou non
     */
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

    /**
     * Consomme les resources necessaires a la construction
     */
    protected void consommationResourceConstruction() {
        for (Map.Entry<ResourceEnum, Long> entry : resourceConstruction.entrySet()) {
            resources.reduceQuantity(entry.getKey(), entry.getValue());
        }
    }

    /**
     * Getter de type
     * @return type
     */
    public BuildingEnum getType() {
        return type;
    }

    /**
     * Getter de nbrHabitants
     * @return nbrHabitants
     */
    public Long getNbrHabitants() {
        return nbrHabitants;
    }

    /**
     * Getter de nbrTravailleurs
     * @return nbrTravailleurs
     */
    public Long getNbrTravailleurs() {
        return nbrTravailleurs;
    }
}
