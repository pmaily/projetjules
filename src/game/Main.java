package game;

import game.Manager.Manager;
import game.Menu.Menu;
import game.Resources.Resources;
import game.utils.enums.ResourceEnum;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

	public static void main(String[] args) {
		Manager manager = new Manager();
		Menu menu = new Menu(manager);
		Resources.getInstance().addQuantity(ResourceEnum.FOOD, 10L);
		Resources.getInstance().addQuantity(ResourceEnum.WOOD, 10L);
		System.out.println("""
				---------JEU DE CONSTRUCTION---------
				        
				Regles:
				\t- Construire un maximum de batiments sans epuiser les resources
				\t- Si une resources tombe en dessous de 0, fin de la partie.
				        
				Pour regarder les limites en habitants/travailleurs, les resources de consommation/production/construction, regardez le pdf.
				        
				Pour effectuer une action:
				\t1- Choisissez une action
				\t2- Choisissez le type de batiment
				\t3- Choisissez l'index du batiment (qui est en fonction du type, regardez la liste des batiments pour cela)
				        
				APPUYEZ SUR UNE ENTREE POUR CONTINUER""");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();

		while (true) {
			menu.lancerInterfaceUtilisateur();
		}

	}
}