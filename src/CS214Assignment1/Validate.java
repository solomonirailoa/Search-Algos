package CS214Assignment1;

import java.util.*; 


public class Validate {
	
	int userInput1to2() {
		boolean flag;
		int choice = 0;
		int s = 0;
		do{ //This is a do While loop, for user input validation
            try{
                do{ //This checks for errors made by user's input
                    if((choice>2 || choice<1 )&& s==1){
                        System.out.println("\tEnter only integer value, from 1 or 2: ");
                        s=0;
                    }
                    Scanner sc = new Scanner(System.in);
                    choice=sc.nextInt();
                    flag=false;
                    s=1;
                   
                }while(!(choice>=1 && choice <=2));    
            }catch(Exception e){
                // Must accept integer only as user input
                flag=true;
            }
        }while(flag); //End of while loop
		return choice;
	}
	int userInput1to3() {
		boolean flag;
		int choice = 0;
		int s=0;
		do{ //This is a do While loop, for user input validation
            try{    //It makes sure that the user input is only an integer [1,2,3 values only]
                do{    //This checks for errors made by user's input
                    if((choice>3 || choice<1)&& s==1){
                       System.out.println("\tEnter only integer value, from 1, 2, or 3: ");
                       s=0;
                    }
                    Scanner sc = new Scanner(System.in);
                    choice=sc.nextInt();
                    flag=false;
                    s=1;
                
                    }while(!(choice>=1 && choice <=3));    
                }catch(Exception e){
                    // Must accept integer only as user input
                    flag=true;
                }
        }while(flag); //End of while loop, as well as user input validation
		return choice;
	}
	int userInput1only(GUIversion om) {
		boolean flag;
		int choice = 1;
		int s = 0;
		do{ //This is a do While loop, for user input validation
            try{    //It makes sure that the user input is only an integer [1,2,3 values only]
                do{    //This checks for errors made by user's input
                    if(choice!=1){
                       System.out.println("\t Wrong input. Enter '1': ");
                    }
                    if (CLIversion.filename==null && choice==1 && s==1) {
                    	System.out.println("\tNo! You must open CSV file first in GUI version window before you enter '1': ");
                    	s=0;
                    }
                    Scanner sc = new Scanner(System.in);
                    choice=sc.nextInt();
                    flag=false;
                    s=1;
                    
                    }while(!(choice==1) || CLIversion.filename==null);    
                }catch(Exception e){
                    // Must accept integer only as user input
                    flag=true;
                }
        }while(flag); //End of while loop, as well as user input validation
		return choice;
	}
	
}
