package CS214Assignment1;

import java.util.*;

public class TenPercArrayListSequential implements Runnable{ //Thread for performing Sequential Search on ArrayList
  private final String key;
  private final int ran;
  private final int endran;
  private final String[] tenPerc;
  private final ArrayList<Database> arrayList;
  public TenPercArrayListSequential (String key, int ran, int endran, String[] tenPerc, ArrayList<Database> arrayList){
      this.key=key;
      this.ran = ran;
      this.endran = endran;
      this.tenPerc = tenPerc;
      this.arrayList = arrayList;
  }
  @Override
  public void run(){ 
      long startTime = System.nanoTime(); //Search timer START
      for (int ip=0;ip<tenPerc.length;ip++){
          String search = tenPerc[ip]; //The search variable stores the search KEY
          int statusFound = 0; //0 for not found, 1 for Found
          int foundAt = 0; //stores the location, index of found element
          int i = 0; //iterator counter
          while(i < arrayList.size() && statusFound==0){
              Database ptnn = arrayList.get(i);
              if (ptnn.getKey().equals(search)){
                  statusFound = 1; //if FOUND element, then STOP search
                  foundAt = i; //Keep the index of found element
              }
              ++i;
          }
          if (statusFound == 1){
              //Found the item at index i
          }
          else if (statusFound == 0){
              //Not found
          }
      }
      long endTime = System.nanoTime(); //Search timer stopped
      long duration = (endTime - startTime); //Calculate Search Time
      double sec = duration/1000000000; //Next we'll print search time
      System.out.println("-------- Total 10% batch Search time using Sequential Search on "
              + "\nArrayList : " + duration + " nanoseconds");
      if (sec>0){
          System.out.println("        or " + sec + " seconds");
      }
      System.out.println("Based on a search from row No." + ran + " to row No." + endran);
      System.out.println("Giving "+tenPerc.length + " rows in total\n---------------\n Please wait for next algorithm\n or wait for END OF PROGRAM\n\n\n\n");
  }  
}

