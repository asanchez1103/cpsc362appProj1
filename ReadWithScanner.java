package ataclone;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class ReadWithScanner extends CardClass{
	public static  CardClass[] redCards = new CardClass[777];//Change number according to lines/proper nouns in redApples.txt
	public  static CardClass[] greenCards = new CardClass[249];//Change number according to lines/adjectives in greenApples.txt
  
	public static void main(String... aArgs) throws IOException {
    ReadWithScanner redParse = new ReadWithScanner("C:\\Users\\gschadha\\workspace\\ataclone\\src\\redApples.txt",1,"","",0,false);
    ReadWithScanner greenParse = new ReadWithScanner("C:\\Users\\gschadha\\workspace\\ataclone\\src\\greenApples.txt",1,"","",0,false);
   
    //TODO: create instances of nonstatic Readwith Scanner, try to get CardClass non-static
    
    String nameInfoR[][] = new String[777][2];
    String nameInfoG[][] = new String[249][2];
   nameInfoR = redParse.processLineByLine(nameInfoR);
   
   for(int i = 0; i<redCards.length; i++){
	   redCards[i] = new CardClass();
	   redCards[i].setID(i+1);
	   redCards[i].setName(nameInfoR[i][0]);
	   redCards[i].setInfo(nameInfoR[i][1]);
	   redCards[i].setHolder(0);
	   redCards[i].setFlip(false);
	   log("Red Card # " + Integer.toString(i+1) + "= \n" + redCards[i].cardName + "\n" + redCards[i].cardInfo +"\n");
   } 
   nameInfoG = greenParse.processLineByLine(nameInfoG);
   for(int j =0; j<greenCards.length; j++){
	   greenCards[j] = new CardClass();
	   greenCards[j].setID(j+1);
	   greenCards[j].setName(nameInfoG[j][0]);
	   greenCards[j].setInfo(nameInfoG[j][1]);
	   greenCards[j].setHolder(0);
	   greenCards[j].setFlip(false);
	   log("Green Card # " + Integer.toString(j+1) + "= \n" + greenCards[j].cardName + "\n" + greenCards[j].cardInfo +"\n");
   }
  
    log("Done.");
  }
  
  
  public ReadWithScanner(String aFileName, int startId, String theName, String theInfo, int theHolder, boolean pubYet){
	  super(startId, theName, theInfo, theHolder, pubYet);
    fFilePath = Paths.get(aFileName);
    //add cardclass object?
  }
  
  
  /** Template method that calls {@link #processLine(String)}.  */
  public  String[][] processLineByLine(String[][] emptyArr) throws IOException {
    try (Scanner scanner =  new Scanner(fFilePath, ENCODING.name())){
    	int loc=0;
    	String[] currArr = new String[2];
      while (scanner.hasNextLine()){
        currArr = processLine(scanner.nextLine(),currArr);
        emptyArr[loc][0] = currArr[0];
        emptyArr[loc][1] = currArr[1];
        loc++;
        
      }
      
    }
    return emptyArr;
  }
  

  protected String[] processLine(String aLine, String[] strArr){
    //use a second Scanner to parse the content of each line 
    Scanner sep = new Scanner(aLine);
    sep.useDelimiter("::");
    if (sep.hasNext()){
      //assumes the line has a certain structure
      String name = sep.next();
      String info = sep.next();
      strArr[0] = name;
      strArr[1] = info;
      return strArr;
    }
    else {
    	strArr[0] = "";
    	strArr[1] = "";
      return strArr;
    }
  }
  
  // PRIVATE 
  private final Path fFilePath;
  private final static Charset ENCODING = StandardCharsets.UTF_8;  
  
  private static void log(Object aObject){
    System.out.println(String.valueOf(aObject));
  }
  
  private String quote(String aText){
    String QUOTE = "'";
    return QUOTE + aText + QUOTE;
  }
} 
