/********************************
 A Simple program that outputs
 all non-repeating characters from
 a user created message. The message
 is separated by char types alpha, numeric and
 special. Each section is sorted.
********************************/
import java.util.Scanner;

public class SmallestNumLetters {
	
	/*Global constants*/
	static final String NUMBERS = "0123456789";
	static final String LETTERS = "abcdefghijklmnopqrstuvwxyz";
	static final String SPECIAL = "`~!@#$%^&*()_-=+/*[]{}|;:,.<>?\"\'\\";
	
	
	public static void main(String [] args){
		
		Scanner in = new Scanner(System.in);
		String letters, numbers, special = "";
		
		System.out.print("Please enter a message: ");
		String word = in.nextLine();
				
		String checkWords = word.toLowerCase();
		
		String shortLetters = "";
		char letter = ' ';
		
		/*Retrieves non repeating characters from the
		 user's message.*/
		for( int i = 0; i <= checkWords.length() - 1; i++){
			letter = letterOccurs(shortLetters, checkWords, i);
			
			if (letter != ' ')
				shortLetters += letter;
		}
		
		/*Extracts character by type from the 
		 user's message and then sorts in
		 ascending order.
		 */
		letters = extractLetters(shortLetters);
		letters = sort(letters);
		
		numbers = extractNumbers(shortLetters);
		numbers = sort(numbers);
		
		special = extractSpecials(shortLetters);
		special = sort(special);
		
		/*Outputs the distinct alpha, numeric 
		  or special characters, if present*/
		if(!letters.isEmpty())
			System.out.println("The shortest list of all letters is: " + letters);
		
		if(!numbers.isEmpty())
			System.out.println("The shortest list of all numbers is: " + numbers);
		
		if(!special.isEmpty())
			System.out.println("The shortest list of all specials is: " + special);
		
		in.close();
	}
	
	/*A method that returns non-repeating characters*/
	public static char letterOccurs(String msgContains, String msgCompare, int index){
		
		for(int i = 0; i <= msgContains.length() - 1; i++){
			if( msgContains.charAt(i) == msgCompare.charAt(index))
				return ' ';
		}
		
		return msgCompare.charAt(index);
	}
	
	/*A method that returns numbers that 
	  are present in the user's message*/
	public static String extractNumbers(String msg){
		
		String currNumbers = "";
		
		for(int i = 0; i <= msg.length() - 1; i++){
			for(int j = 0; j < NUMBERS.length(); j++)
				if( NUMBERS.charAt(j) == msg.charAt(i))
					currNumbers += msg.charAt(i);
		}
		
		return currNumbers;
	}
	
	/*A method that returns letters that 
	  are present in the user's message*/
	public static String extractLetters(String msg){
		
		String currLetters = "";
		
		for(int i = 0; i <= msg.length() - 1; i++){
			for(int j = 0; j < LETTERS.length(); j++)
				if( LETTERS.charAt(j) == msg.charAt(i))
					currLetters += msg.charAt(i);
		}
		
		return currLetters;
	}
	
	/*A method that returns special characters that 
	  are present in the user's message*/
	public static String extractSpecials(String msg){
		
		String currSpecials = "";
		
		for(int i = 0; i <= msg.length() - 1; i++){
			for(int j = 0; j < SPECIAL.length(); j++)
				if( SPECIAL.charAt(j) == msg.charAt(i))
					currSpecials += msg.charAt(i);
		}
		
		return currSpecials;
	}
	
	/*A method that sorts the user's message  
	  in ascending order*/
	public static String sort(String msg){
		
		char tempStore = ' ';
		char[] tempCharArray = msg.toCharArray();
	
		for(int i = 0; i <= msg.length() - 1; i++){
			for(int j = i + 1; j < msg.length(); j++){
				if(tempCharArray[i] > tempCharArray[j]){
					tempStore = tempCharArray[i];
					tempCharArray[i] = tempCharArray[j];
					tempCharArray[j] = tempStore;
				}
			}
		}
			
		return new String (tempCharArray);
	}

}
