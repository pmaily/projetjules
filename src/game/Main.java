package game;

import game.Building.Building;
import game.Manager.Manager;
import game.Menu.Menu;
import game.Resources.Resources;
import game.utils.enums.BuildingEnum;
import game.utils.enums.CommandEnum;
import game.utils.enums.ResourceEnum;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {
        Manager manager = new Manager();
        Menu menu = new Menu(manager);
        Resources.getInstance().addQuantity(ResourceEnum.FOOD, 10L);
        Resources.getInstance().addQuantity(ResourceEnum.WOOD, 10L);
        while (true){
            menu.lancerInterfaceUtilisateur();
        }

    }
}