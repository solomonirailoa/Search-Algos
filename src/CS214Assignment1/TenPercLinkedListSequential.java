package CS214Assignment1;

import java.util.LinkedList;

public class TenPercLinkedListSequential implements Runnable{ //Thread for performing Sequential Search on LinkedList
    private final String key;
    private final int ran;
    private final int endran;
    private final String[] tenPerc;
    private final LinkedList<Database> linkedList;
    public TenPercLinkedListSequential (String key, int ran, int endran, String[] tenPerc, LinkedList<Database> linkedList){
        this.key=key;
        this.ran = ran;
        this.endran = endran;
        this.tenPerc = tenPerc;
        this.linkedList = linkedList;
    }
    @Override
    public void run(){ //Enter code here in run()
        long startTime = System.nanoTime(); //Search Timer START 
        for (int i=0;i<tenPerc.length;i++){
            String search = tenPerc[i];
            int statusFoundd = 0; //0 for not found, 1 for Found
            int foundAtt = 0; //stores the location, index of found element
            int ii = 0; //iterator counter
            while(ii < linkedList.size() && statusFoundd==0){ //Begin Search
                Database ptn = linkedList.get(ii);
                if (ptn.getKey().equals(search)){
                    statusFoundd = 1; //if FOUND element, then STOP search
                    foundAtt = ii; //Keep the index of found element
                }
                ii++;
            }
            if (statusFoundd == 1){
                //Found the item at index ii
            }
            else if (statusFoundd == 0){
                //Not found
            }
        }
        long endTime = System.nanoTime(); //Search timer stopped
        long duration = (endTime - startTime); //Calculate Search Time
        double sec = duration/1000000000; //Next we'll print search time
        System.out.println("-------- Total 10% batch Search time using Sequential Search on "
                + "\nLinkedList : " + duration + " nanoseconds");
        if (sec>0){
            System.out.println("        or " + sec + " seconds");
        }
        System.out.println("Based on a search from row No." + ran + " to row No." + endran);
        System.out.println("Giving "+tenPerc.length + " rows in total\n---------------\n Please wait for next algorithm\n or wait for END OF PROGRAM\n\n\n\n");
    }         
}
