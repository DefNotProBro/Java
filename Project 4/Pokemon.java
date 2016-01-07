import java.util.*;
public class Pokemon {
	String species;
	int attack;
	int defense;
	int speed;
	
	public Pokemon(String species, int attack, int defense, int speed){
		this.species = species;
		this.attack = attack;
		this.defense = defense;
		this.speed = speed;
	}//End constructor
	
	public void grow(int boost){
		attack += boost;
	}
	
	public void harden(int boost){
		defense += boost;
	}
	
	public void haste(int boost){
		speed += boost;
	}
	
	public String getSpecies(){
		return species;
	}
	
	public void setSpecies(String spc){
		species = spc;
	}
	
	public int getAttack(){
		return attack;
	}
	
	public void setAttack(int atk){
		attack = atk;
	}
	
	public int getDefense(){
		return defense;
	}
	
	public void setDefense(int def){
		defense = def;
	}
	
	public int getSpeed(){
		return speed;
	}
	
	public void setSpeed(int spd){
		speed = spd;
	}
}
