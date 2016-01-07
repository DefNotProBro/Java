import java.util.*;
public class Project4 {
	private static Scanner sc = new Scanner (System.in);
	public static void main(String[] args){
		//Scanner sc = new Scanner(System.in);
		int size;
		System.out.println("Welcome to your new PokeDex!");
		System.out.print("How many Pokemon are in your region?: ");
		size = sc.nextInt();
		System.out.println();
		Pokedex pokedex = new Pokedex(size);
		System.out.println("Your new Pokedex can hold " + size + " pokemon. Let's start using it!");
		menu(pokedex);
	}//End main
	
	public static void menu(Pokedex pokedex){
		System.out.println();
		System.out.println("1. List Pokemon");
		System.out.println("2. Add Pokemon");
		System.out.println("3. Check a Pokemon's Stats");
		System.out.println("4. Sort Pokemon");
		System.out.println("5. Exit");
		System.out.println();
		System.out.print("What would you like to do? ");
		int input = sc.nextInt();
		System.out.println();
		switch(input){
		case 1: 
			pokedex.listPokemon();
			menu(pokedex);
			break;
		
		case 2: 
			System.out.print("Please enter the Pokemon's name: ");
			String species = sc.next();
			int attack = (species.length() * 4) + 2;
			int defense = (species.length() * 2) + 7;
			int speed = (species.length() * 3) + 5;
			Pokemon pkm = new Pokemon(species, attack, defense, speed);
			pokedex.addPokemon(pkm);
			menu(pokedex);
			break;
			
		case 3: 
			System.out.print("Please enter the Pokemon of interest: ");
			String pkm_nm = sc.next();
			System.out.println();
			pokedex.checkStats(pkm_nm);
			menu(pokedex);
			break;
			
		case 4:
			pokedex.sortPokemon();
			menu(pokedex);
			break;
			
		case 5: 
			break;
			
		default:
			System.out.println("That's not a valid input choice. Try again!");
			menu(pokedex);
		}
		
	}//End menu
}
