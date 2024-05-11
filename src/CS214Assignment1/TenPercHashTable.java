package CS214Assignment1;

import java.util.Hashtable;

public class TenPercHashTable implements Runnable{
    private final String key;
    private final int ran;
    private final int endran;
    private final String[] tenPerc;
    private final Hashtable<String, Database> hashTable;
    public TenPercHashTable (String key, int ran, int endran, String[] tenPerc, Hashtable<String, Database> hashTable){
        this.key=key;
        this.ran = ran;
        this.endran = endran;
        this.tenPerc = tenPerc;
        this.hashTable = hashTable;
    }
    @Override
    public void run(){ //Enter code here in run()
        long startTime = System.nanoTime(); //Search timer starts
        for (int i=0;i<tenPerc.length;i++){
            String search = tenPerc[i];
            if(hashTable.containsKey(search)){ // The containsKey() method is the built-in SEARCH method/algorithm for HashTable/Hashmap
                //Found the key
            }
            else{
                //Not found
            }
        }
        long endTime = System.nanoTime(); //Stop the search timer
        long duration = (endTime - startTime);//Calculate search time  
        double sec = duration/1000000000; //Next we'll print search time
        System.out.println("\nLoading next algorithm");
        System.out.println("-------- Total 10% batch Search time using built-in Search on "
                + "\n HashTable : " + duration + " nanoseconds");
        if (sec>0){
            System.out.println("        or " + sec + " seconds");
        }
        System.out.println("Based on a search from row No." + ran + " to row No." + endran);
        System.out.println("Giving "+tenPerc.length + " rows in total\n---------------\n Please wait for next algorithm\n or wait for END OF PROGRAM\n\n\n\n");
    }      
} 