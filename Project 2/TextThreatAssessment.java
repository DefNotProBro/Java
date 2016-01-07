/*
 * Terry Thibault
 * Programming Fundamentals 1
 * Java Project 2
 * 
 * Description: This program sorts through given "encrypted" files. In order to decrypt the file, 
 * you need to reverse the entire thing, and then take every other letter in the file. Based on
 * the resulting 'decrypted' message, you do a "threat assessment." This is determined by the number of times
 * a given word is used in the decrypted message.
 */
import java.util.*;
import java.io.File;
public class TextThreatAssessment {
	public static void main(String[] args){
		
		boolean run = true;
		String UFID = "";
		String word = "";
		int numFound;
		Scanner sc1 = new Scanner(System.in);
		String threat = "Safe";
		
		while(run){
			System.out.print("Enter the UFID of the person who wrote the message: ");
			UFID = sc1.nextLine();
			
			if(UFID.length() != 8){
				System.out.println("Error: UFID must be 8 digits. Now Exiting.");
				run = false;
			}
			else if(UFID.charAt(0) == '0'){
				System.out.println("Error: UFID must not begin with a zero. Now Exiting.");
				run = false;
			}
			else {
				System.out.println("Opening file: " + UFID + ".txt");
				System.out.print("Enter the word (or phrase) of interest: ");
				word = sc1.nextLine();
				
			//Code given by Professor
			     String encryptedString = "";
			     try 
			     {
					File file = new File(UFID + ".txt"); 
					Scanner sc = new Scanner(file); 
					while (sc.hasNextLine()) 
					{ 
						encryptedString+=sc.nextLine(); 
					}
					sc.close(); 
					} catch(Exception ex) 
					{ 
					ex.printStackTrace(); 
					}
			   //End code given by Professor   
			     String decryptedMessage = decrypt(encryptedString);
			     numFound = found(decryptedMessage, word);
			     
			     if(numFound == 2){
			    	 threat = "Somewhat Threatening";
			     }
			     else if(numFound == 3){
			    	 threat = "Threatening";
			     }
			     else if(numFound >= 4){
			    	 threat = "Highly Threatening";
			     }
			     
			     System.out.println("The word " + word + " was found " + numFound + " time(s).");
			     System.out.print("Messages from student " + UFID + " were found to be: ");
			     System.out.println(threat);
			     System.out.print("Press (y) to continue or (n) to exit. ");
			     run = (sc1.nextLine().charAt(0) == 'y') ? true : false;
			}
		}
	}
	
	public static String decrypt(String encryptedMessage){
		String decryptedMessage = "";
		String temp = "";
		
		//Reverse the encrypted string
		for(int i = encryptedMessage.length(); i > 0; i--){
			temp = temp + encryptedMessage.charAt(i-1);
		}
		//Take every other letter
		for(int j = 0; j < (temp.length() / 2); j++){
			decryptedMessage = decryptedMessage + temp.charAt((j*2) + 1);
		}
		
		return decryptedMessage;
	}
	
	public static int found(String decryptedMessage, String word){
		int numFound = 0;
		int position = -1;
		boolean run = false;
		
		if(decryptedMessage.indexOf(word) != -1){
			numFound++;
			run = true;
			position = decryptedMessage.indexOf(word, position + 1);
		}
		while(run){
			position = decryptedMessage.indexOf(word, position + 1);
			if(position != -1){
				numFound++;
			}
			else{
				run = false;
			}
		}
		
		return numFound;
	}
}