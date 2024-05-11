package CS214Assignment1;

import java.util.*;

public class SingleSearch {
	Scanner userIn = new Scanner(System.in);
	
	@SuppressWarnings("rawtypes")
	void startArrayListSeq (String key, ArrayList<Database> arrayList, String columnHeading) {
		//Perform Sequential Search for ArrayList
        System.out.println("\tEnter the  \""+ key +"\"  you are searching for: ");
        String search = userIn.next();
        int statusFound = 0; //0 for not found, 1 for Found
        int foundAt = 0; //stores the location, index of found element
        int i = 0; //iterator counter
        long startTime = System.nanoTime(); //Search timer START
        while(i < arrayList.size() && statusFound==0){
            Database ptnn = arrayList.get(i);
            if (ptnn.getKey().equals(search)){
                statusFound = 1; //if FOUND element, then STOP search
                foundAt = i; //Keep the index of found element
            }
            ++i;
        }
        long endTime = System.nanoTime(); //Search timer stopped
        long duration = (endTime - startTime); //Calculate Search Time
        if (statusFound == 1){
            System.out.println("Found");
            System.out.println((arrayList.get(foundAt)).printOut());
            (arrayList.get(foundAt)).showDetailedRecord(columnHeading);
        }
        else if (statusFound == 0){
            System.out.println("Not found"); //Element is not in arrayList
        }
        double sec = duration/1000000000; //Next we'll print search time
        System.out.println("-------- Search time: " + duration + " nanoseconds");
        if (sec>0){
            System.out.println("-------- or " + sec + " seconds");
        }
	}
	@SuppressWarnings("rawtypes")
	void startLinkedListSeq(String key, LinkedList<Database> linkedList, String columnHeading) {
		//Perform Sequential Search for LinkedList
        System.out.println("\tEnter the  \""+ key +"\"  you are searching for: ");
        String search = userIn.next();
        int statusFoundd = 0; //0 for not found, 1 for Found
        int foundAtt = 0; //stores the location, index of found element
        int ii = 0; //iterator counter
        long startTime = System.nanoTime(); //Search Timer START 
        while(ii < linkedList.size() && statusFoundd==0){ //Begin Search
            Database ptn = linkedList.get(ii);
            if (ptn.getKey().equals(search)){
                statusFoundd = 1; //if FOUND element, then STOP search
                foundAtt = ii; //Keep the index of found element
            }
            ii++;
        } //End of search
        long endTime = System.nanoTime(); //Search Timer START
        long duration = (endTime - startTime);
        if (statusFoundd == 1){
            System.out.println("Found");
            System.out.println((linkedList.get(foundAtt)).printOut());
            (linkedList.get(foundAtt)).showDetailedRecord(columnHeading);
        }
        else if (statusFoundd == 0){
            System.out.println("Not found");
        }
        double sec = duration/1000000000;
        System.out.println("-------- Search time: " + duration + " nanoseconds");
        if (sec>0){
            System.out.println("-------- or " + sec + " seconds");
        }
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	void startArrayListBinary(String key, ArrayList<Database> arrayList, String columnHeading) {
		//Perform Built-in Binary Search for ArrayList
        System.out.println("\tEnter the  \""+ key +"\"  you are searching for: ");
        String search = userIn.next();
        Comparator<Database> c = new Comparator<Database>() {
            @Override
			public int compare(Database p1, Database p2)
			{
				return p1.getKey().compareTo(p2.getKey());
			} //This comparator is a help class for the buit-in Java Binary search
		}; //Must! Binary Search can only be performed on sorted collections, e.g. our arrayList
		ArrayList<Database> temporarySortedArrList= new ArrayList<Database>();
	    temporarySortedArrList.addAll(arrayList);
	    temporarySortedArrList.sort(c);
		long startTime = System.nanoTime(); //Search timer starts
        int indx = Collections.binarySearch(temporarySortedArrList, new Database(search, null), c); //<----This is the actual BUILT-in binary search for ArrayList
        long endTime = System.nanoTime(); //Stop the search timer
        long duration = (endTime - startTime);//Calculate search time
        if (indx > -1){
            System.out.println("Found");
            System.out.println((temporarySortedArrList.get(indx)).printOut()); //Print the Row,record
            (temporarySortedArrList.get(indx)).showDetailedRecord(columnHeading); //Print detailed search result
        }
        else if (indx <= -1){
            System.out.println("Not found");
        }
        double sec = duration/1000000000; //Print search time below
        System.out.println("-------- Search time: " + duration + " nanoseconds");
        if (sec>0){
            System.out.println("-------- or " + sec + " seconds");
        }
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	void startLinkedListBinary(String key, LinkedList<Database> linkedList, String columnHeading) {
		//Perform Built-in Binary Search for LinkedList
        System.out.println("\tEnter the  \""+ key +"\"  you are searching for: ");
        String search = userIn.next();
        Comparator<Database> cc = new Comparator<Database>() {
            @Override
			public int compare(Database pp1, Database pp2)
			{
                                return pp1.getKey().compareTo(pp2.getKey());
			} //This comparator is a help class for the buit-in Java Binary search
		}; //Must! Binary Search can only be performed on sorted collections, e.g. our linkedList
		LinkedList<Database> temporarySortedLinkLst= new LinkedList<Database>();
		temporarySortedLinkLst.addAll(linkedList);
		temporarySortedLinkLst.sort(cc);
        long startTime = System.nanoTime(); //Search timer starts
        int indexx = Collections.binarySearch(temporarySortedLinkLst, new Database(search, null), cc); //<---- This right here is the actual Built-in BINARY search for Linked Lists in Java
        long endTime = System.nanoTime(); //Stop the search timer
        long duration = (endTime - startTime);//Calculate search time
        if (indexx > -1){
            System.out.println("Found");
            System.out.println((temporarySortedLinkLst.get(indexx)).printOut()); // Print the row/record containing the search ID
            (temporarySortedLinkLst.get(indexx)).showDetailedRecord(columnHeading);//Print a detailed search result
        }
        else if (indexx <= -1){
            System.out.println("Not found");
        }
        double sec = duration/1000000000;
        System.out.println("-------- Search time: " + duration + " nanoseconds");
        if (sec>0){
            System.out.println("-------- or " + sec + " seconds");
        }
	}
	@SuppressWarnings("rawtypes")
	void startHashTableSearch(String key, Hashtable<String,Database> hashTable, String columnHeading) {
		//Perform Built-in HashTable Search for the Hashtable. 
        System.out.println("\tEnter the  \""+ key +"\"  you are searching for: ");
        String search = userIn.next();
        long startTime = System.nanoTime(); //Search timer STARTS
        if(hashTable.containsKey(search)){ // The containsKey() method is the built-in SEARCH method/algorithm for HashTable/Hashmap
            System.out.println("Found");
            System.out.println((hashTable.get(search).printOut()));
            (hashTable.get(search)).showDetailedRecord(columnHeading);
        }
        else{
            System.out.println("Not found");
        }
        long endTime = System.nanoTime(); //Search timer STOPS
        long duration = (endTime - startTime); //Calculate search time
        double sec = duration/1000000000;
        System.out.println("-------- Search time: " + duration + " nanoseconds");
        if (sec>0){
            System.out.println("-------- or " + sec + " seconds");
        }
	}
	
	
}
