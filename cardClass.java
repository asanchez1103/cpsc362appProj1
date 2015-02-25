//CLASS NOT FUNCTIONAL YET
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
	int cardHolder;//Location of Card. 0 = Deck. 1-8 = Player # 1-8. 9 = Discard Pile(Red Cards only). 10 = On table(Green Cards and current round's Red Cards).
	boolean cardVisible;//When on table, card may exist, but will not be seen. 
	
	cardClass[] redCards = new cardClass[757];//Change number according to lines/proper nouns in redApples.txt
	cardClass[] greenCards = new cardClass[249];//Change number according to lines/adjectives in greenApples.txt
	
	
	
	public  void main(String[] args) throws Throwable{
		
		String redFile = "redApples.txt";
		String greenFile = "greenApples.txt";
		
		redCards = getCards(redFile, redCards);
	
	System.out.println("Hello everyone!");
}
	
	cardClass[] getCards(String fileName,cardClass[] deckCards) throws Throwable{
		
		fFilePath = 
		
		File redFile = new File("redApples.txt");
		FileInputStream redStream = new FileInputStream(redFile);
		
		
		redStream.close();
		
		return deckCards;
	}
}
