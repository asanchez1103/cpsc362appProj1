import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class shuffleClass extends cardClass{

	public shuffleClass(int startId, Image thePic, int theHolder, boolean pubYet) {
		super(startId, thePic, theHolder, pubYet);
		// TODO Auto-generated constructor stub
	}

	public static void main(String [] aArgs){
	
		
	}
	
	public cardClass[] shuffleCards(cardClass[] someCards, int deckAmt){
		Random newPlace = new Random();
		
		for(int i = deckAmt; i>0; i--){
			int j = newPlace.nextInt(i);
			cardClass tempCard = someCards[i-1];
			someCards[i-1] = someCards[j];
			someCards[j] = tempCard;
			}
		return someCards;
		
	}
	
} 
//Since the cardClass does not work at this time, I created shuffleClass using an array of chars(seen below in comments). 
//I then modified it to fit with an array of cardClass(seen above in code). 
//The function shuffleCards is all we need, so we can probably copy this function  into the larger classes like BoardClass.



/*public class shuffleClass {
	
	public static void main(String [] aArgs){
		 char[] alphaCheck = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		 Random newPlace = new Random();
		 
		for(int i = 52; i>0;i--){
			int j = newPlace.nextInt(i);
			char temp = alphaCheck[i-1];
			alphaCheck[i-1] = alphaCheck[j];
			alphaCheck[j] = temp;
			
		}
		
			System.out.println(Arrays.toString(alphaCheck)); 
		 
		 
		 
	}

}*/
