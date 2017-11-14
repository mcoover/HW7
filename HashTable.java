package hw7.pkg2;


import java.util.*;
import java.io.*;
public final class HashTable {
    
    private final LinkedList<String>[] list = new LinkedList[100];
    
    public HashTable(ArrayList<String> dis) {
        for(int i=0;i<list.length;i++){
            list[i]=new LinkedList();
	} // for
        
	setHash(dis);
    } // method
    
    public void setHash(ArrayList<String> s) {
        
        for(int i = 0; i < s.size(); i++){
            int big = convertToInt(s.get(i));
            int index = big%100;
            this.list[index].add(s.get(i));
	} // for
        
    } // method
    
    public int convertToInt(String s){
        int sum = 0;
	for(int i = 0; i < s.length(); i++){
            char a = s.charAt(i);
            sum = sum+(int)a;
	} // for
        
	return sum;
        
	} // method
    
    public void printOut(){
	PrintWriter write =null;
	try {
            write = new PrintWriter("hw72.out.txt");
            } catch(FileNotFoundException e) {
			System.out.println(e);
            } // try/catch
		
        for(int i = 0 ;i < 5; i++){
            write.println("Contents of linked list at index "+i+":");			 				
                for(int rn=0;rn<this.list[i].size();rn++){
                    write.println("\t"+this.list[i].get(rn));
                } // inner for
        } // outer for
        write.close();
            
    } // method
    
    public void printHash(Hashtable hashish){
        PrintWriter write = null;
        
	try{
            write =new PrintWriter("hw72.hash.txt");
	}catch(FileNotFoundException e) {
            System.out.println(e);
	} // catch
        
	Enumeration keys = hashish.keys();
	for(int i=0;i<5;i++){
            Object key = keys.nextElement();
            write.println("Key: " + key + " value: " + hashish.get(key));
	} // for

	write.close();
        
	} // method
    
    public Hashtable hash(ArrayList<String>s,int size){
	Hashtable hash = new Hashtable(size);	
	for(int i = 0; i< s.size(); i++){
            int big = convertToInt(s.get(i));
            int index = big%size;
            hash.put(index,s.get(i));
	} // end for
        
	return hash;

	} // method
    
    public void printSize (){
        for (LinkedList<String> printList : list) {
            System.out.println(printList.size());
        } // for
        
    } // method
    
} // class
