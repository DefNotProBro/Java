/*
 * Terry Thibault
 * Programming Fundamentals 1
 * Java Project 3
 * 
 * Description: This program will display a menu from which the user can select various options
 * to perform various tasks. This is Harry-Potter-themed, which is super awesome.
 */
import java.util.*;
public class DiagonAlleyGuide {
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args){
		
		String items[][] = {{"0", "0", "0", "0", "0", "0", "0"}, {"Broom", "School robes", "Wand", "The Standard Book of Spells", "A History of Magic" , "Magical Drafts and Potions", "Cauldron"}, {"0", "0", "0"}};
		System.out.println("Welcome to Diagon Alley!");
		System.out.println();
		mainMenu(items);

	}//End main
	
	//Takes the dollar input and returns number of galleons to add.
	public static int exchangeGalleons(double USD){
		int galleons = (int) (USD * 10 /(17*29));
		return galleons;
	}//End exchangeGalleons

	//Takes the dollar input and returns number of sickles to add.
	public static int exchangeSickles(double USD){
		int knut = (int) (USD * 10);
		int sickles = (int) knut / 29;
		sickles = sickles % 17;
		return sickles;
	}//End exchangeSickles

	//Takes the dollar input and returns number of knuts to add.
	public static int exchangeKnuts(double USD){
		int knut = (int) (USD * 10) % 29;
		return knut;
	}//End exchangeKnuts
	                    
	//Prints out your balance. Singularity is noted.
	public static void balance(int galleon, int sickle, int knut){
		 String galleonString = (galleon == 1 ? "Galleon" : "Galleons");
		 String sickleString = (sickle == 1 ? "Sickle" : "Sickles");
		 String knutString = (knut == 1 ? "Knut" : "Knuts");
		 
		 System.out.print("You have " + galleon + " " + galleonString);
		 System.out.print(", " + sickle + " " + sickleString);
		 System.out.println(", and " + knut + " " + knutString + ".");
		 System.out.println();
	}//End balance

	//Checks if you have enough money to purchase desired item.
	public static boolean enoughMoney(int galleon, int sickle, int knut, int cost){
		return (galleon*493 + sickle*29 + knut >= cost);
	}//End enoughMoney
	
	//Displays the main menu to the output window.
	public static void mainMenu(String items[][]){
	//Scanner sc = new Scanner(System.in);
		
		System.out.println("Main Menu:");
		System.out.println("1. Gringotts Bank");
		System.out.println("2. List of Supplies");
		System.out.println("3. Shoppes");
		System.out.println("4. Leave");
		System.out.println();
		
		System.out.print("Selection: ");
		int input = sc.nextInt();
		System.out.println();
		
		switch(input){
			case 1: 
				gringottsMenu(items);
				break;
			case 2: 
				inventoryList(items);
				break;
			case 3:
				shoppes(items);
				break;
			case 4:
				if(items[0][0].equals("0") && items[0][1].equals("0") && items[0][2].equals("0") && items[0][3].equals("0") && items[0][4].equals("0") && items[0][5].equals("0") && items[0][6].equals("0")){
					System.out.println("You have no supplies!");
				}
				else if(items[0][0].equals("1") && items[0][1].equals("1") && items[0][2].equals("1") && items[0][3].equals("1") && items[0][4].equals("1") && items[0][5].equals("1") && items[0][6].equals("1")){
					System.out.println("Have a nice day!!");
				}
				else{
					System.out.println("You are missing some items!");
					System.out.println("Missing:");
					for(int i = 0; i < items[0].length; i++){
						if(items[0][i].equals("0")){
							System.out.println(items[1][i]);
						}
					}
				}
				break;
			default:
				System.out.println("Invalid entry!");
				System.out.println();
				mainMenu(items);
				break;
			}
		
		
	}//End mainMenu
	                    
	//Displays the bank menu.
	public static void gringottsMenu(String items[][]){
		System.out.println("Gringotts Bank");
		System.out.println("1. Exchange Money");
		System.out.println("2. Check Balance");
		System.out.println("3. Exit");
		System.out.println();
		System.out.print("Selection: ");
		//Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		System.out.println();
		
		switch(input){
			case 1:
				System.out.println("How much would you like to exchange?");
				System.out.print("USD: ");
				double USD = sc.nextDouble();
				System.out.println();
				if(USD < 0){
					System.out.println("Transaction failed!");
					System.out.println("Input cannot be negative!");
					gringottsMenu(items);
				}
				else{
					//Money fun begins..
					 int knut = Integer.parseInt(items[2][0]);
					 int sickle = Integer.parseInt(items[2][1]);
					 int galleon = Integer.parseInt(items[2][2]);
					 
					 knut = knut + exchangeKnuts(USD);
					 sickle = sickle + exchangeSickles(USD);
					 galleon = galleon + exchangeGalleons(USD);
					 
					 sickle = sickle + knut / 29;
					 knut = knut%29;
					 galleon = galleon + sickle / 17;
					 sickle = sickle % 17;
//					 knut = (int) (knut + USD * 10);
//					 sickle = sickle + (knut/29);
//					 knut = knut%29;
//					 galleon = galleon + (sickle / 17);
//					 sickle = sickle%17;
					 
					 items[2][0] = Integer.toString(knut);
					 items[2][1] = Integer.toString(sickle);
					 items[2][2] = Integer.toString(galleon);
					 //End money fun
					System.out.println("Transaction Complete!");
					System.out.println();
					gringottsMenu(items);
				}
				break;
			case 2: 
				 int knut = Integer.parseInt(items[2][0]);
				 int sickle = Integer.parseInt(items[2][1]);
				 int galleon = Integer.parseInt(items[2][2]);
				 balance(galleon, sickle, knut);
				 gringottsMenu(items);
				 break;
					
			case 3:
				mainMenu(items);
				break;
			
			default:
				System.out.println("Invalid entry!");
				System.out.println();
				gringottsMenu(items);
				break;
		}
		
	}//End gringottsMenu
	                    
	//Displays the shop menu.
	public static void shoppes(String items[][]){
		System.out.println("Shoppes");
		System.out.println("1. Broomstix");
		System.out.println("2. Second-Hand Robes");
		System.out.println("3. Olivanders");
		System.out.println("4. Flourish and Blotts");
		System.out.println("5. Potage's Cauldron Shop");
		System.out.println("6. Exit");
		System.out.println();
		//Scanner sc = new Scanner(System.in);
		System.out.print("Selection: ");
		int input = sc.nextInt();
		System.out.println();
		
		switch(input){
			case 1: 
				broomstix(items);
				break;
			case 2: 
				secondhandRobes(items);
				break;
			case 3: 
				olivanders(items);
				break;
			case 4: 
				flourishblotts(items);
				break;
			case 5: 
				potagecauldron(items);
				break;
			case 6:
				mainMenu(items);
				break;
			default:
				System.out.println("Invalid entry!");
				System.out.println();
				shoppes(items);
				break;
		}
	}//End shoppes
	
	public static void potagecauldron(String items[][]){
		System.out.println("Potage's Cauldron Shop");
		System.out.println("1. Buy Cauldron for 10 Sickles");
		System.out.println("2. Exit");
		System.out.println();
		//Scanner sc = new Scanner(System.in);
		System.out.print("Selection: ");
		int input = sc.nextInt();
		System.out.println();
		
		switch(input){
		case 1:
			 int knut = Integer.parseInt(items[2][0]);
			 int sickle = Integer.parseInt(items[2][1]);
			 int galleon = Integer.parseInt(items[2][2]);
			 int price = 10 * 29; // hard - coded price of the cauldron.. could have been done differently. 
			 int totalCash = (galleon * 493) + (sickle * 29) + knut;  
			 if(enoughMoney(galleon, sickle, knut, price) && items[0][6].equals("0")){
				 purchase(totalCash, price, items);
				 items[0][6] = "1"; // cauldron purchased
				 System.out.println("Transaction successful!");
				 System.out.println();
				 potagecauldron(items);
			 }
			 else if(items[0][6].equals("1")){ // If cauldron is already owned, fail.
				 System.out.println("Transaction failed!");
				 System.out.println("You already have this!");
				 System.out.println();
				 potagecauldron(items);
			 }
			 else if(!enoughMoney(galleon, sickle, knut, price)){
				 System.out.println("Transaction failed!");
				 System.out.println("You do not have enough money!");
				 System.out.println();
				 potagecauldron(items);
			 }
			 break;
		case 2:
			shoppes(items);
			break;
		default:
			System.out.println("Invalid  entry!");
			System.out.println();
			potagecauldron(items);
			break;
		}
	}//End potagecauldron
	
	public static void flourishblotts(String items[][]){
		System.out.println("Flourish and Blotts");
		System.out.println("1. Buy The Standard Book of Spells for 5 Sickles");
		System.out.println("2. Buy A History of Magic for 3 Sickles and 12 Knuts");
		System.out.println("3. Buy Magical Drafts and Potions for 27 Knuts");
		System.out.println("4. Exit");
		System.out.println();
		//Scanner sc = new Scanner(System.in);
		System.out.print("Selection: ");
		int input = sc.nextInt();
		System.out.println();
		
		switch(input){
		case 1:
			 int knut = Integer.parseInt(items[2][0]);
			 int sickle = Integer.parseInt(items[2][1]);
			 int galleon = Integer.parseInt(items[2][2]);
			 int price = 5 * 29; // hard - coded price of the standard book of spells.. could have been done differently. 
			 int totalCash = (galleon * 493) + (sickle * 29) + knut;  
			 if(enoughMoney(galleon, sickle, knut, price) && items[0][3].equals("0")){
				 purchase(totalCash, price, items);
				 items[0][3] = "1"; // standard book of spells purchased
				 System.out.println("Transaction successful!");
				 System.out.println();
				 flourishblotts(items);
			 }
			 else if(items[0][3].equals("1")){ // If standard book of spells is already owned, fail.
				 System.out.println("Transaction failed!");
				 System.out.println("You already have this!");
				 System.out.println();
				 flourishblotts(items);
			 }
			 else if(!enoughMoney(galleon, sickle, knut, price)){
				 System.out.println("Transaction failed!");
				 System.out.println("You do not have enough money!");
				 System.out.println();
				 flourishblotts(items);
			 }
			 break;
		case 2: 
			 knut = Integer.parseInt(items[2][0]);
			 sickle = Integer.parseInt(items[2][1]);
			 galleon = Integer.parseInt(items[2][2]);
			 price = (3 * 29) + 12; // hard - coded price of the history of magic.. could have been done differently. 
			 totalCash = (galleon * 493) + (sickle * 29) + knut;  
			 if(enoughMoney(galleon, sickle, knut, price) && items[0][4].equals("0")){
				 purchase(totalCash, price, items);
				 items[0][4] = "1"; // history of magic purchased
				 System.out.println("Transaction successful!");
				 System.out.println();
				 flourishblotts(items);
			 }
			 else if(items[0][4].equals("1")){ // If history of magic is already owned, fail.
				 System.out.println("Transaction failed!");
				 System.out.println("You already have this!");
				 System.out.println();
				 flourishblotts(items);
			 }
			 else if(!enoughMoney(galleon, sickle, knut, price)){
				 System.out.println("Transaction failed!");
				 System.out.println("You do not have enough money!");
				 System.out.println();
				 flourishblotts(items);
			 }
			 break;
		case 3:
			 knut = Integer.parseInt(items[2][0]);
			 sickle = Integer.parseInt(items[2][1]);
			 galleon = Integer.parseInt(items[2][2]);
			 price = 27; // hard - coded price of magical drafts and potions.. could have been done differently. 
			 totalCash = (galleon * 493) + (sickle * 29) + knut;  
			 if(enoughMoney(galleon, sickle, knut, price) && items[0][5].equals("0")){
				 purchase(totalCash, price, items);
				 items[0][5] = "1"; // magical drafts and potions purchased
				 System.out.println("Transaction successful!");
				 System.out.println();
				 flourishblotts(items);
			 }
			 else if(items[0][5].equals("1")){ // If magical drafts and potions is already owned, fail.
				 System.out.println("Transaction failed!");
				 System.out.println("You already have this!");
				 System.out.println();
				 flourishblotts(items);
			 }
			 else if(!enoughMoney(galleon, sickle, knut, price)){
				 System.out.println("Transaction failed!");
				 System.out.println("You do not have enough money!");
				 System.out.println();
				 flourishblotts(items);
			 }
			 break;
		case 4: 
			shoppes(items);
			break;
		default: 
			System.out.println("Invalid  entry!");
			System.out.println();
			flourishblotts(items);
			break;
		}
	}//End flourishblotts
	
	public static void olivanders(String items[][]){
		System.out.println("Olivanders");
		System.out.println("1. Buy Wand for 7 Sickles");
		System.out.println("2. Exit");
		System.out.println();
		//Scanner sc = new Scanner(System.in);
		System.out.print("Selection: ");
		int input = sc.nextInt();
		System.out.println();
		
		switch(input){ 
		case 1:
			 int knut = Integer.parseInt(items[2][0]);
			 int sickle = Integer.parseInt(items[2][1]);
			 int galleon = Integer.parseInt(items[2][2]);
			 int price = 7 * 29; // hard - coded price of the wand.. could have been done differently. 
			 int totalCash = (galleon * 493) + (sickle * 29) + knut;  
			 if(enoughMoney(galleon, sickle, knut, price) && items[0][2].equals("0")){
				 purchase(totalCash, price, items);
				 items[0][2] = "1"; // wand purchased
				 System.out.println("Transaction successful!");
				 System.out.println();
				 olivanders(items);
			 }
			 else if(items[0][2].equals("1")){ // If wand is already owned, fail.
				 System.out.println("Transaction failed!");
				 System.out.println("You already have this!");
				 System.out.println();
				 olivanders(items);
			 }
			 else if(!enoughMoney(galleon, sickle, knut, price)){
				 System.out.println("Transaction failed!");
				 System.out.println("You do not have enough money!");
				 System.out.println();
				 olivanders(items);
			 }
			 break;
		case 2:
			shoppes(items);
			break;
		default:
			System.out.println("Invalid  entry!");
			System.out.println();
			olivanders(items);
			break;
	}

		
	}//End olivanders
	
	public static void secondhandRobes(String items[][]){
		System.out.println("Second-Hand Robes");
		System.out.println("1. Buy School robes for 12 Sickles");
		System.out.println("2. Exit");
		System.out.println();
		//Scanner sc = new Scanner(System.in);
		System.out.print("Selection: ");
		int input = sc.nextInt();
		System.out.println();
		
		switch(input){ 
		case 1:
			 int knut = Integer.parseInt(items[2][0]);
			 int sickle = Integer.parseInt(items[2][1]);
			 int galleon = Integer.parseInt(items[2][2]);
			 int price = 12 * 29; // hard - coded price of the robes.. could have been done differently. 
			 int totalCash = (galleon * 493) + (sickle * 29) + knut;  
			 if(enoughMoney(galleon, sickle, knut, price) && items[0][1].equals("0")){
				 purchase(totalCash, price, items);
				 items[0][1] = "1"; // robes purchased
				 System.out.println("Transaction successful!");
				 System.out.println();
				 secondhandRobes(items);
			 }
			 else if(items[0][1].equals("1")){ // If robes already owned, fail.
				 System.out.println("Transaction failed!");
				 System.out.println("You already have this!");
				 System.out.println();
				 secondhandRobes(items);
			 }
			 else if(!enoughMoney(galleon, sickle, knut, price)){
				 System.out.println("Transaction failed!");
				 System.out.println("You do not have enough money!");
				 System.out.println();
				 secondhandRobes(items);
			 }
			 break;
		case 2:
			shoppes(items);
			break;
		default:
			System.out.println("Invalid  entry!");
			System.out.println();
			secondhandRobes(items);
			break;
		}

	}//End secondhandRobes
	                    
	public static void broomstix(String items[][]){
		System.out.println("Broomstix");
		System.out.println("1. Buy Broom for 1 Galleon");
		System.out.println("2. Exit");
		//Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.print("Selection: ");
		int input = sc.nextInt();
		System.out.println();
		
		switch(input){ 
			case 1:
				 int knut = Integer.parseInt(items[2][0]);
				 int sickle = Integer.parseInt(items[2][1]);
				 int galleon = Integer.parseInt(items[2][2]);
				 int price = 493; // hard - coded price of the broom.. could have been done differently. 
				 int totalCash = (galleon * 493) + (sickle * 29) + knut;  
				 if(enoughMoney(galleon, sickle, knut, price) && items[0][0].equals("0")){
					 purchase(totalCash, price, items);
					 items[0][0] = "1"; // Broomstick purchased
					 System.out.println("Transaction successful!");
					 System.out.println();
					 broomstix(items);
				 }
				 else if(items[0][0].equals("1")){ // If broom already owned, fail.
					 System.out.println("Transaction failed!");
					 System.out.println("You already have this!");
					 System.out.println();
					 broomstix(items);
				 }
				 else if(!enoughMoney(galleon, sickle, knut, price)){
					 System.out.println("Transaction failed!");
					 System.out.println("You do not have enough money!");
					 System.out.println();
					 broomstix(items);
				 }
				 break;
			case 2:
				shoppes(items);
				break;
			default:
				System.out.println("Invalid  entry!");
				System.out.println();
				broomstix(items);
				break;
		}
	}//End broomstix
	
	public static void purchase(int totalCash, int price, String[][] items){
		totalCash = totalCash - price;
		int knut =  totalCash % 29;
		int sickle = (totalCash / 29) % 17;
		int galleon = (totalCash / (17* 29));
		
		//Attach the new values to their array counterparts
		
		items[2][0] = Integer.toString(knut);
		items[2][1] = Integer.toString(sickle);
		items[2][2] = Integer.toString(galleon);
		
		//Money has now been subtracted. Next step should be to set the item to 'purchased'.
	} // End purchase
	
	//Displays the list of items currently in inventory.
	public static void inventoryList(String items[][]){
		System.out.println("Inventory:");
		for(int i = 0; i < items[0].length; i++){
			if(items[0][i] == "1"){
				System.out.println(items[1][i]);
			}
		}
		System.out.println();
		System.out.println("Need:");
		for(int i = 0; i < items[0].length; i++){
			if(items[0][i] == "0"){
				System.out.println(items[1][i]);
			}
		}
		System.out.println();
		mainMenu(items);
	}//End inventoryList
	                    
}
