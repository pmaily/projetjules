package game.Menu;

import game.Building.Building;
import game.Manager.Manager;
import game.Resources.Resources;
import game.utils.enums.BuildingEnum;
import game.utils.enums.CommandEnum;
import game.utils.enums.ResourceEnum;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Menu {

    Manager manager;
    Scanner scanner;

    /**
     * Constructeur de la classe Menu
     * @param manager
     */
    public Menu(Manager manager){
        this.manager = manager;
        scanner = new Scanner(System.in);
    }

    /**
     * Demande un nombre a l'utilisateur jusqu'a ce qu'il soit compris entre 0 et size
     * @param size input max possible pour l'utilisateur
     * @return input de l'utilisateur
     */
    private Integer demanderChoix(int size) {
        Integer choix = null;
        while (choix == null) {
            System.out.print("Choix: ");
            try {
                choix = Integer.parseInt(scanner.next());
                if (choix < 1 || choix > size) {
                    throw new NumberFormatException();
                }
            }
            catch (NumberFormatException e){
                System.out.println("\tChoix invalide, veuillez recommencer.");
                choix = null;
            }
        }
        return choix;
    }
    /**
     * Cette fonction propose a l'utilisateur les options possibles et enregistre ses choix qui seront
     * envoyes a la fonction executeCommand de la classe manager
     */
    private void choisirAction() {
        List<BuildingEnum> buildingEnums = List.of(BuildingEnum.values());
        List<CommandEnum> commandEnums = List.of(CommandEnum.values());
        CommandEnum commandType;
        BuildingEnum buildingType;
        Long index = null;
        int i = 1;

        System.out.println("Choisir une action: ");
        for (CommandEnum commandEnum : commandEnums) { //ici on affiche la liste des commandes disponibles
            System.out.println("\t" + i + "- " + commandEnum);
            i++;
        }
        i = 1;

        commandType = commandEnums.get(demanderChoix(commandEnums.size()) - 1);

        System.out.println("Choisir le type de building: ");
        for (BuildingEnum buildingEnum : buildingEnums) {
            System.out.println("\t" + i + "- " + buildingEnum);
            i++;
        }

        buildingType = buildingEnums.get(demanderChoix(buildingEnums.size()) - 1);

        if (commandType != CommandEnum.CREATE_BUILDING)
        {
            System.out.println("Choisir le numéro du building: ");
            index = demanderChoix(manager.getBuildings().get(buildingType).size()).longValue() - 1;
        }
        manager.executeCommand(commandType, buildingType, index);
    }

    /**
     * Cette fonction lance l'interface utilisateur en presentant les resources disponibles et les batiments
     * puis lance la fonction choisrAction pour intergir avec l'utilisateur
     */
    public void lancerInterfaceUtilisateur() {
        Map<ResourceEnum, Long> resources = Resources.getInstance().getResources();

        while (true) {
            final Map<BuildingEnum, List<Building>> buildings = manager.getBuildings(); //TODO essayer de voir pour sortir du scope de la boucle vu qu'on a des ref sur les buildings (et pas des copies)

            for (Map.Entry<BuildingEnum, List<Building>> entry : buildings.entrySet()){
                int i = 1;
                System.out.println(entry.getKey() + ": ");
                for(Building building : entry.getValue()) {
                    System.out.println("\t" + i + "- Nombre d'habitants: " + building.getNbrHabitants() + " | Nombre de travailleurs: " + building.getNbrTravailleurs());
                    i++;
                }
                if (entry.getValue().isEmpty()) {
                    System.out.println("\t(Aucun batiment disponible)");
                }
            }

            System.out.println("\nResources disponibles: ");
            for (Map.Entry<ResourceEnum, Long> entry : resources.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            System.out.println("\n");

            choisirAction();
        }
    }
}