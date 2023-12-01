package game.Resources;

import game.utils.enums.ResourceEnum;

import java.util.HashMap;
import java.util.Map;

/*
* Cette classe suit le pattern Singleton, qui permet de garantir l'exisence unique des Resources, associe a une quantite
*/
public final class Resources { //final pour que la classe ne soit pas heritee

    private static Resources instance = null; //static fait que ce sera l'unique instance game.Resource existante du programme
    private Map<ResourceEnum, Long> resources;

    private Resources() { //private pour garantir que le constructeur ne peut etre utilise que dans la fonction getInstance
        resources = new HashMap<>();
        resources.put(ResourceEnum.COAL, 0L);
        resources.put(ResourceEnum.FOOD, 0L);
        resources.put(ResourceEnum.IRON, 0L);
        resources.put(ResourceEnum.CEMENT, 0L);
        resources.put(ResourceEnum.LUMBER, 0L);
        resources.put(ResourceEnum.STEEL, 0L);
        resources.put(ResourceEnum.STONE, 0L);
        resources.put(ResourceEnum.TOOLS, 0L);
        resources.put(ResourceEnum.WOOD, 0L);
    }

    /**
     * Getter de instance
     * @return instance
     */
    public static Resources getInstance() {
        if (instance == null) {
            instance = new Resources(); //ici on garanti que "instance" n'est instanciee qu'une seule fois
        }
        return instance;
    }

    /**
     * Permet d'ajouter d'augmenter le nombre de resources "type".
     * @param type la resource qu'on veut augmenter
     * @param amount le total a augmenter
     */
    public void addQuantity(ResourceEnum type, Long amount){
        Long newAmount = resources.get(type) + amount;
        resources.put(type, newAmount);
    }

    /**
     * Permet de reduire le nombre de resources "type".
     * @param type la resource qu'on veut reduire
     * @param amount le total a reduire
     * @throws IllegalStateException si la resource "type" passe en dessous de 0
     */
    public void reduceQuantity(ResourceEnum type, Long amount){
        Long newAmount = resources.get(type) - amount;
        if (newAmount < 0)
            throw new IllegalStateException("Il n'y a plus assez de " + type + ", fin du programme.");
        resources.put(type, newAmount);
    }

    /**
     * Getter de la quantite d'une resource precise "type".
     * @param type le type de resource dont on souhaite recuperer la quantite
     * @return quantite de la resource type
     */
    public Long getQuantity(ResourceEnum type) { //TODO voir si encore utile
        return resources.get(type);
    }

    /**
     * Getter de la propriété resources.
     * @return resources
     */
    public Map<ResourceEnum, Long> getResources() {
        return resources;
    }
}

