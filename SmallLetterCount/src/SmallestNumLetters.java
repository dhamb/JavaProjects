/********************************
 A Simple program that outputs
 all non-repeating characters from
 a user created message. Cases
 are consider as unique in this
 implementation.
********************************/
import java.util.Scanner;

public class SmallestNumLetters {
	
	public static void main(String [] args){
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Please enter a message: ");
		String word = in.nextLine();
		
		String shortLetters = "";
		
		for( int i = 0; i <= word.length() - 1; i++){
			if(!letterOccurs(shortLetters, word, i)){
				shortLetters += word.charAt(i);
			}
		}
		
		System.out.println("For original message: " + word + "\nThe shortest list of all letters is: " +  shortLetters);
		in.close();
	}
	
	public static Boolean letterOccurs(String msgContains, String msgCompare, int index){
		
		for(int i = 0; i <= msgContains.length() - 1; i++){
			if( msgContains.charAt(i) == msgCompare.charAt(index))
				return true;
		}
		
		return false;
	}

}
