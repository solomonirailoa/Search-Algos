package CS214Assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class TenPercLinkedListBinary implements Runnable{
    private final String key;
    private final int ran;
    private final int endran;
    private final String[] tenPerc;
    private final LinkedList<Database> linkedList;
    public TenPercLinkedListBinary (String key, int ran, int endran, String[] tenPerc, LinkedList<Database> linkedList){
        this.key=key;
        this.ran = ran;
        this.endran = endran;
        this.tenPerc = tenPerc;
        this.linkedList = linkedList;
    }
    @Override
    public void run(){ //Enter code here in run()
        long startTime = System.nanoTime(); //Search timer starts
        Comparator<Database> c = new Comparator<Database>() {
            @Override
			public int compare(Database p1, Database p2)
			{
						return p1.getKey().compareTo(p2.getKey());
			} //This comparator is a help class for the buit-in Java Binary search
        }; //Must! Binary Search can only be performed on sorted collections, e.g. our linkedList
        LinkedList<Database> temporarySortedLinkLst= new LinkedList<Database>();
        temporarySortedLinkLst.addAll(linkedList);
        temporarySortedLinkLst.sort(c);
        for (int i=0;i<tenPerc.length;i++){
            String search = tenPerc[i];
            int indx = Collections.binarySearch(temporarySortedLinkLst, new Database(search, null), c); //<----This is the actual BUILT-in binary search for ArrayList
            if (indx >= 0){
                //Found at index "indx"
            }
            if (indx < 0){
                //Not found
            }        
        }
        long endTime = System.nanoTime(); //Stop the search timer
        long duration = (endTime - startTime);//Calculate search time  
        double sec = duration/1000000000; //Next we'll print search time
        System.out.println("-------- Total 10% batch Search time using Binary Search on "
                + "\nLinkedList : " + duration + " nanoseconds");
        if (sec>0){
            System.out.println("        or " + sec + " seconds");
        }
        System.out.println("Based on a search from row No." + ran + " to row No." + endran);
        System.out.println("Giving "+tenPerc.length + " rows in total\n---------------\n Please wait for next algorithm\n or wait for END OF PROGRAM\n\n\n\n");
    }
}
