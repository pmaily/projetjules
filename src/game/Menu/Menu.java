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


    public Menu(Manager manager){
        this.manager = manager;
        scanner = new Scanner(System.in);
    }

    private void choisirAction() {
        List<BuildingEnum> buildingEnums = List.of(BuildingEnum.values());
        List<CommandEnum> commandEnums = List.of(CommandEnum.values());
        CommandEnum commandType;
        BuildingEnum buildingType;
        Long index = null;
        int i = 1;

        System.out.println("Choisir une action: ");
        for (CommandEnum commandEnum : commandEnums) {
            System.out.println("\t" + i + "- " + commandEnum);
            i++;
        }
        i = 1;
        System.out.print("Choix: ");
        Integer choix = Integer.parseInt(scanner.next());
        commandType = commandEnums.get(choix - 1);

        System.out.println("Choisir le type de building: ");
        for (BuildingEnum buildingEnum : buildingEnums) {
            System.out.println("\t" + i + "- " + buildingEnum);
            i++;
        }
        System.out.print("Choix: ");
        choix = Integer.parseInt(scanner.next());
        buildingType = buildingEnums.get(choix - 1);

        if (commandType != CommandEnum.CREATE_BUILDING)
        {
            System.out.print("Choix: ");
            System.out.println("Choisir le numéro du building: ");
            index = Long.parseLong(scanner.next()) - 1;
        }

        manager.executeCommand(commandType, buildingType, index);
    }

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