package CS214Assignment1;

import java.util.*; 
import java.io.*;   //Like wise for Java IO library, which is for File Reading

public class CSVfile {
	String columnHeadingg;
	String keyy;
	int colss;
	int rowss;
	int rann; 
	int endrann;
	String[] tenPercc;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	void read (Hashtable<String,Database>hashTable,LinkedList<Database> linkedList,ArrayList<Database> arrayList, String columnHeading, String key, int cols, int rows, int ran, int endran, String[] tenPerc, String filename) {
		try{ //File Reading process
            File x = new File(filename);
            Scanner sc = new Scanner(x);
            System.out.println("\n You have opened: " + filename + "  from the Mini Search Engine window\n");
            columnHeading = sc.nextLine(); //Read column heading
            String[] temp = columnHeading.split(","); //Gather column headings into separate elements
            key = temp[0]; //This identifies what type of ID we're dealing with upon various CSV files, in our case, this is StructureID. For other CSV's, it would be key=carRegNo, or key=studentId, etc
            cols = temp.length; //How many columns are in this CSV? 
            while(sc.hasNext()) {
                String str = sc.nextLine();
                String[] arrOfStr = str.split(",",2);
                Database aRecord = new Database(arrOfStr[0],arrOfStr[1]); 
                hashTable.put(arrOfStr[0],aRecord);
                linkedList.add(aRecord);
                arrayList.add(aRecord);
            }
            rows = arrayList.size();
            System.out.println("This CSV file contains " + rows +" rows and " + cols + " columns ");
            sc.close(); //Close the File
            tenPerc = new String[(int)(rows*0.1)]; //This empty array will be used later for 10% random search on ID's
            
            int s =ran;
            for (int i = 0; i < tenPerc.length;i++ ){ //Prepare and fill the 10% array
                tenPerc[i] = (String)arrayList.get(s).getKey();
                ++s;
            }
            
            keyy=key;colss=cols;rowss=rows;rann=ran;endrann=endran;tenPercc=tenPerc; columnHeadingg=columnHeading;
        }catch (FileNotFoundException e) { //Exception, file cannot open
            System.out.println("!!!!! File Open Error !!!!!");
        }
	}
	String getColumnHeading() {
		return columnHeadingg;
	}
	String getKey() {
		return keyy;
	}
	int getCols() {
		return colss;
	}
	int getRows() {
		return rowss;
	}
	int getRan() {
		return rann;
	}
	int getEndRan() {
		return endrann;
	}
	String[] getTenPerc() {
		return tenPercc;
	}
	
	
		
}
