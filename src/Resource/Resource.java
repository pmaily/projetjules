package Resource;

import utils.enums.ResourceEnum;

import java.util.HashMap;
import java.util.Map;

/*
* Cette classe suit le pattern Singleton, qui permet de garantir l'exisence unique des Resources, associe a une quantite
*/
public final class Resource { //final pour que la classe ne soit pas heritee

    private static Resource instance = null; //static fait que ce sera l'unique instance Resource existante du programme
    private Map<ResourceEnum, Long> resources;

    private Resource() { //private pour garantir que le constructeur ne peut etre utilise que dans la fonction getInstance
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

    public static Resource getInstance() {
        if (instance == null) {
            instance = new Resource(); //ici on garanti que "instance" n'est instanciee qu'une seule fois
        }
        return instance;
    }

    public void addQuantity(ResourceEnum type, Long amount){
        Long newAmount = resources.get(type) + amount;
        resources.put(type, newAmount);
    }

    public void reduceQuantity(ResourceEnum type, Long amount){
        Long newAmount = resources.get(type) - amount;
        if (newAmount < 0)
            throw new RuntimeException("Il n'y a plus assez de " + type.toString().toLowerCase() + ", fin de la partie !");
        resources.put(type, newAmount);
    }

    public Long getQuantity(ResourceEnum type) {
        return resources.get(type);
    }

}
