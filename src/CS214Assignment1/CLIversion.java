package CS214Assignment1;
/**
 * 
 * This MainClass is the Command Line Interface (CLI) version of the Search Engine
 * it will also launch the GUI version. You can perform Searches on both CLI and GUI. 
 * for CLI, you need to switch back to console once you've opened the file using GUI Open CSV
 * 
 * 
 * @author Ratu Solomoni Railoa (s11123197@student.usp.ac.fj)
 * 		   Sireli Savutila  (s11086287@student.usp.ac.fj)
 * CS214 Assignment 1 Solution
 * 2021, Semester 2
 * 
 */
import java.util.*; //Import everything in Java Utility Library, for Data Structures like ArrayList, LinkedList, and HashMap

public class CLIversion {
    public static String filename;
    public static int ran;
    public static int endran;
    public static int tenPerc;
    public static String columnHeading;
	
	@SuppressWarnings("rawtypes")
	public static void main (String[] args){
    	CSVfile csvFile = new CSVfile();
        Hashtable<String, Database> hashTable = new Hashtable<>();
        LinkedList<Database> linkedList = new LinkedList<>();
        ArrayList<Database> arrayList = new ArrayList<>(); 
    	System.out.println("\n Welcome to Mini Search Engine - Command Line Interface Version (CLI) \n You can also use the GUI version which has popped up already \n");        
        int cols = 0; int rows=0; String key="";
    	String columnHeadingg = ""; //Stores column headings, it will be splitted later
        String[] tenPerc = null; //This empty array will be used later for 10% random search on ID's
        GUIversion om=new GUIversion(); Scanner userIn = new Scanner(System.in); Validate input = new Validate(); int choice; om.goStart();    
		System.out.println("Use the new Mini Search Engine (GUI version) window to open your CSV file\n     Caution: Closing the new GUI window will stop the Console Search Operation\n        Or even close the whole program \n So please keep the Mini Search Engine window open.\n After opening your CSV file in the new window,\n please come back to this console and\n enter '1' over here to continue and perform SEARCH: ");
				
		if ( input.userInput1only(om)==1 ) {    		
            csvFile.read(hashTable,linkedList,arrayList,columnHeadingg,key,cols,rows,ran,endran,tenPerc,filename);
            cols=csvFile.getCols();rows=csvFile.getRows(); key=csvFile.getKey(); tenPerc=csvFile.getTenPerc(); 
            columnHeadingg=columnHeading;
            do{
            	System.out.println("\nEnter 1 to perform Sequential Search for ArrayList and LinkedList");
                System.out.println("Enter 2 to perform Built-in Binary Search for ArrayList and LinkedList");
                System.out.println("Enter 3 to perform Built-in HashTable Search for the Hashtable");
                choice = input.userInput1to3(); //Select 1,2, or 3
                switch (choice) {
                case 1:
                	//Perform Sequential Search for ArrayList and LinkedList
                    System.out.println("\tEnter 1 for ArrayList, Sequential search");
                    System.out.println("\tEnter 2 for LinkedList, Sequential search");            
                    choice=input.userInput1to2(); //Select 1 or 2
                    switch (choice) {
                    case 1: //Perform Sequential Search for ArrayList
                    	SingleSearch sequential1 = new SingleSearch();
                        sequential1.startArrayListSeq(key, arrayList, columnHeadingg);
                    break;
                    case 2:  //Perform Sequential Search for LinkedList
                    	SingleSearch sequential2 = new SingleSearch();
                    	sequential2.startLinkedListSeq(key, linkedList, columnHeadingg);
                    }
                break;
                case 2:
                    //Perform Built-in Binary Search for ArrayList and LinkedList
                    System.out.println("\tEnter 1 for ArrayList, Built-in Binary Search");
                    System.out.println("\tEnter 2 for LinkedList, Built-in Binary Search");
                    choice=input.userInput1to2(); //Select 1 or 2
                    switch (choice) {
                    case 1:  //Perform Built-in Binary Search for ArrayList
                    	SingleSearch builtIN1 = new SingleSearch();
                        builtIN1.startArrayListBinary(key, arrayList, columnHeadingg);
                    break;
                    case 2:
                    	//Perform Built-in Binary Search for LinkedList
                    	SingleSearch builtIn2 = new SingleSearch();
                        builtIn2.startLinkedListBinary(key, linkedList, columnHeadingg);
                }
	            break;
	            case 3:  //Perform Built-in HashTable Search for the Hashtable.
	            	SingleSearch builtin = new SingleSearch();
	                builtin.startHashTableSearch(key, hashTable, columnHeadingg);
                }
                System.out.println("\n Enter '1' to repeat search, enter '2' to proceed to Bulk Search on 10% collection: ");
            }while (input.userInput1to2()==1); choice=2;
            if (choice==2){ //To save time, multi Threading is enabled on 10% random searches
                Start10percOp go = new Start10percOp(); //Start the 10% search Operation
                go.start(key, ran, endran, tenPerc, arrayList, linkedList, hashTable);
            }
            else{ 
                System.out.println("\n\n\n END of program \n");
            }
            userIn.close();
    	}
    }
}