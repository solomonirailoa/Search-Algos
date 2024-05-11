package CS214Assignment1;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;

public class Start10percOp {
    public void start(String key, int ran, int endran, String[] tenPerc, ArrayList<Database> arrayList, LinkedList<Database>linkedList, Hashtable<String,Database>hashTable){
        System.out.println("\n\nYou have selected 2 for Bulk Search"); //This is helpful for answering Q3 of assignment 1
        System.out.println("Let's begin 10% mass search on all algorithms and data structures");
        System.out.println("The random search will be performed on " + tenPerc.length + " rows ");
        System.out.println("Ranging from row no." + ran + " to row no." + endran + "");
        System.out.println("If the dataset is very large, we advise you to wait for a while");
        System.out.println("or wait for END of program signal\n\n\n\nLoading next algorithm");
            
        Runnable r1 = new TenPercArrayListSequential(key,ran,endran,tenPerc,arrayList);
        Runnable r2 = new TenPercLinkedListSequential(key,ran,endran,tenPerc,linkedList);
        Runnable r3 = new TenPercArrayListBinary(key,ran,endran,tenPerc,arrayList);
        Runnable r4 = new TenPercLinkedListBinary(key,ran,endran,tenPerc,linkedList);
        Runnable r5 = new TenPercHashTable(key,ran,endran,tenPerc,hashTable);
            
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);
        Thread t4 = new Thread(r4);
        Thread t5 = new Thread(r5);
            
        t1.start();
        t2.start();
        t5.start();
        t3.start();
        t4.start();
            
        int th1 = 0; int th2 = 0; int th3 = 0; int th4 = 0; int th5 = 0; 
        while (t1.isAlive() || t2.isAlive() || t3.isAlive() || t4.isAlive() || t5.isAlive()){
            if (!t1.isAlive() && t2.isAlive() && !t3.isAlive() && !t4.isAlive() && !t5.isAlive() && th2==0){
                System.out.println("\nPlease wait for LinkedList Sequential Search (!! Might take very long !!)");
                th2=1;
            }
            else if(t1.isAlive() && t2.isAlive() && !t3.isAlive() && t4.isAlive() && !t5.isAlive() && th1==0){
                System.out.println("\nLoading next algorithm");
                th1=1;
            }
            else if (!t1.isAlive() && t2.isAlive() && !t3.isAlive() && t4.isAlive() && !t5.isAlive() && th4==0){
            	System.out.println("\nLoading next algorithm");
                th4=1;
            }
        }
        if (!(t1.isAlive() && t2.isAlive() && t3.isAlive() && t4.isAlive() && t5.isAlive())){
            //This is the END of program Signal
        	System.out.println("\n\n\n END of program \n"); //When all threads are completed and TERMINATED
           }
        }
} 