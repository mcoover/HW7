/*
Matt Coover
CS2050
HW 7 version 2
 */
package hw7.pkg2;

import java.util.*;
import java.io.*;

public class hw72{
    
    public static void main(String[] args) {
        
        ArrayList<String> s= createArrayList(greetNget());
	HashTable a = new HashTable (s);
        
	System.out.println("The array size is "+s.size());
	System.out.println("The hashtable lengths are: ");
        
	a.printSize();
	a.printOut();
	Hashtable hash = a.hash(s,100);
	a.printHash(hash);

    } // main
    
    public static String greetNget(){
	Scanner scnr = new Scanner(System.in);
        
        System.out.println("Welcome User! \n This program identifies the unique"
            + " words in a text file of your \n choosing, and sorts them into"
            + " a hash table");
        
	System.out.println("Please enter the location of your input file");
        
        return scnr.next();
        
    } // method
    
    public static ArrayList<String> createArrayList(String file){
	Scanner sr =null;
        
	try{
            sr = new Scanner(new File(file));
	}catch(FileNotFoundException e){
            System.out.println(e);
	} // try/catch
		
	ArrayList<String> words = new ArrayList<>();
	while(sr.hasNext()){
            String here = sr.next();
            here= doIt(here);
            
            if(!checkIfThere(words,here)) {
                words.add(here);
            } // if
            
	} // while
        
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