import java.util.*;
public class Pokedex {
	int size;
	int stored = 0;
	Pokemon[] pokemon;
	public Pokedex(int size){
		pokemon = new Pokemon[size];
		this.size = size;
	}//End constructor
	
	public void listPokemon(){
		if(stored == 0){
			System.out.println("Your Pokedex is currently empty!");
		}
		else{
			for(int i = 1; i < stored + 1; i++){
				System.out.println(i + ".  " + pokemon[i-1].species);
			}
		}
	}
	public void addPokemon(Pokemon pkm){
		boolean run = true;
		int i = 0;
		if(stored >= size){
			System.out.println("Your Pokedex is already holding the max amount!");
		}
		else{
			while(run){
				if(stored == 0){
					pokemon[i] = pkm;
					stored++;
					run = false;
				}
				else if(pokemon[i].species.equals(pkm.species)){
					System.out.println("Your Pokedex is already storing that Pokemon!");
					return;
				}
				else{
					pokemon[stored] = pkm;
					stored++;
					run = false;
				}
				i++;
			}
		}
	}
	public void checkStats(String pkm_nm){
		for(int i = 0; i < stored; i++){
			if(pokemon[i].species.equals(pkm_nm)){
				System.out.println("The stats for " + pokemon[i].species + " are:");
				System.out.println("Attack: " + pokemon[i].attack);
				System.out.println("Defense: " + pokemon[i].defense);
				System.out.println("Speed: " + pokemon[i].speed);
				return;
			}
		}
		System.out.println("The Pokemon could not be found!");
	}
	public void sortPokemon(){
		for(int p = 0; p < 2; p++){
			for(int i = 0; i < stored - 1; i++){
				int min = i;
				for(int j = i + 1; j < stored; j++){
					if(pokemon[j].species.compareTo(pokemon[i].species) < 0){
						min = j;
					}
				}
				Pokemon temp = pokemon[i];
				pokemon[i] = pokemon[min];
				pokemon[min] = temp;
			}
		}
	}
}
