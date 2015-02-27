/*Guneet Singh Chadha
 * Group 404
 * cardClass
 * Function: cardClass is used to recieve input from text files redApples and GreenApples for the Red Cards and Green Cards respectively. 
 * 
 * GREEN CARDS contain an adjective, as well as a list of synonyms. Format: "Adjective" + " - " + "(Synonyms)"
 * RED CARDS contain a proper noun, as well as a small description. Format: "Proper Noun" + " - " + "This is a description. May contain more than one sentence."
 * Red Cards and Green Cards are placed into their own respective array of card classes/structs. 
 * 
 * When players 'draw' cards from the Red/Green card stack, the Program randomly selects a Red/Green card from the draw array. 
 * That card is removed from the draw array, and the last card of the array is placed in the new spot, to avoid errors.
 * 
 * Any Red cards that are kept in the hand are in the players' Red Hand arrays, until used, or until the game ends.
 * Red Cards that are used by players are kept in a Discard array.  Cards are kept in Discard array in the order they were discarded.
 * 
 * Green Cards that are won by players are kept in the players' Green Hand arrays, until the game ends.
 * 
 * 
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
//found parsing class, need to implement into cardClass. Site: http://www.javapractices.com/topic/TopicAction.do?Id=87
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
public class cardClass {
	
	int cardID;//Each Card will be given an ID upon being entered.
	String cardName;//Green Card: Adjective. Red Card: Proper Noun
	String cardInfo;//Green Card: Synonyms of adjective. Red Card: Description of Proper Noun.
	int cardHolder;//Location of Card. 0 = Deck. 1-8 = Player # 1-8. 9 = Discard Pile(Red Cards only). 10 = On table(Green Cards only).
	
	public static cardClass[] redCards = new cardClass[757];//Change number according to lines/proper nouns in redApples.txt
	public static cardClass[] greenCards = new cardClass[249];//Change number according to lines/adjectives in greenApples.txt
	

	 public static void main(String[] Args) throws  IOException {
		 
		 String redFileName = "C:\\Users\\Guneet Singh Chadha\\Desktop\\CS Stuff\\cs362\\redApples.txt";//Modify based on location
		 String greenFileName = "C:\\Users\\Guneet Singh Chadha\\Desktop\\CS Stuff\\cs362\\greenApples.txt";//Modify based on location
		 
		 for(int i=0;i<redCards.length;i++){//Give cards starting info to prevent NullPointerException ?
			 redCards[i].cardID = i;
			 redCards[i].cardName = "";
			 redCards[i].cardInfo = "";
			 redCards[i].cardHolder = 0;
		 }
		 for(int j =0; j<greenCards.length;j++){
			 greenCards[j].cardID = j;
			 greenCards[j].cardName = "";
			 greenCards[j].cardInfo = "";
			 greenCards[j].cardHolder = 0;
		 }
		 redCards = processLineByLine(redCards,redFileName);
		 greenCards = processLineByLine(greenCards,greenFileName);
		    
		    for(int m = 0; m<757; m++){
		    	System.out.println(redCards[m].cardID + "\t" + redCards[m].cardName + redCards[m].cardInfo);
		    }
		    for(int n = 0; n<249; n++){
		    	System.out.println(greenCards[n].cardID + "\t" + greenCards[n].cardName + greenCards[n].cardInfo);
		    }
		    
	 }
		  

	 public  static cardClass[] processLineByLine(cardClass[] deckCards, String aFileName) throws IOException {
		 
		 Path fFilePath = Paths.get(aFileName);
		 int currentCard = 0;
		 
		 try (Scanner scanner =  new Scanner(fFilePath)){
			 while (scanner.hasNextLine()){
		    	  String cardWord = "";
		    	  String cardDesc = "";
		    	  String newLine = scanner.nextLine();
		    	  Scanner newLineScan = new Scanner(newLine);
		    	  scanner.useDelimiter(" - ");// " - " seperates keyword(s) from info.
		    	  
		    	  if (newLineScan.hasNext()){
		    		  cardWord = scanner.next();
		   		      cardDesc = scanner.next();
		   		  //deckCards[currentCard].cardID = currentCard;    
		    	  deckCards[currentCard].cardName = cardWord;
		    	  deckCards[currentCard].cardInfo = cardDesc;
		    	  //deckCards[currentCard].cardHolder = 0;
		    	  currentCard++;
		    	  
		    	  }
		      }
		    } 
		    
		    return deckCards;
		    
		  }
		    
		
}

