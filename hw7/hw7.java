/*
Matt Coover
CS2050
HW 7 version 2
 */
package hw7;

import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;

public class hw7{
    
    // C:\Users\mattc\OneDrive\Documents\CS1050\Homework\HW4.txt
    
    public static void main(String[] args) {
        
        ArrayList<String> s = createArrayList(greetNget());
	HashTable a = new HashTable (s);
        
	System.out.println("The array size is " + s.size());
	System.out.println("The hashtable lengths are: ");
        
	a.printSize();
	a.printOut();
	Hashtable hash = a.hash(s,100);
	try{
            a.printHash(hash);
        } catch (Exception e) {System.out.println("The Hash Table is "
                + "showing the value 'zero' because your input file was "
                + "incorrect. Please verify the correct location and name of "
                + "the input file and try again. :)");
        } // try catch

    } // main
    
    public static String greetNget(){
	Scanner scnr = new Scanner(System.in);
        String file = null;
        
        System.out.println("Welcome User! \n This program identifies the unique"
            + " words in a text file of your \n choosing, and sorts them into"
            + " a hash table");
        System.out.println("Please enter the location of your input file"); // try/catch
        file = scnr.next();
        return file;
        
    } // method
    
    public static ArrayList<String> createArrayList(String file){
	Scanner scnr =null;
        
	try{
            scnr = new Scanner(new File(file));
	}catch(FileNotFoundException e){
            System.out.println(e);
	} // try/catch
		

        ArrayList<String> words = new ArrayList<>();
	
            try{ 
                while(scnr.hasNext()){
                String here = scnr.next();
                here= doIt(here);
            
            if(!checkIfThere(words,here)) {
                words.add(here);
            } // if
                } // while
            
            } catch (Exception e){}

        
        
	return words;
        
    } // method
    
    public static boolean checkIfThere(ArrayList<String> words, String zz){
        for (int i=0;i<words.size();i++) {
            
            if(words.get(i).equals(zz)){
		return true;
            } // if
            
	} // for
		return false;
                
    } // method
    
    public static String doIt(String s){
        
        String b = "";
        
        for(int i =0;i<s.length();i++){
            char a = s.charAt(i);
            if(Character.isLetter(a)||(a=='\'')){
                if(Character.isUpperCase(a)){
                    b=b+(Character.toLowerCase(a));
                } // inner if
                if(Character.isLowerCase(a)){
                    b=b+a;
                } // inner if
            } //outer if
        } // for
        return b;
        
    } // method
    
} // class