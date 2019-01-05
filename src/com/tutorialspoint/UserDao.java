package com.tutorialspoint;  

import java.io.File; 
import java.io.FileInputStream; 
import java.io.FileNotFoundException;  
import java.io.FileOutputStream; 
import java.io.IOException; 
import java.io.ObjectInputStream; 
import java.io.ObjectOutputStream; 
import java.util.ArrayList; 
import java.util.List;  

public class UserDao { 
   public List<User> getAllUsers(){ 
      
      List<User> userList = null; 
      try { 
         File file = new File("/tmp/Users.dat"); 
         int x=4; 
         if (!file.exists()) { 
	           while(x-->0) {
	        	 User user = new User(x, "Atchom"+x, "Maestro"+x); 
	            userList = new ArrayList<User>(); 
	            userList.add(user); 
	            saveUserList(userList); 
	           }
         } 
         else{ 
            FileInputStream fis = new FileInputStream(file); 
            ObjectInputStream ois = new ObjectInputStream(fis); 
            userList = (List<User>) ois.readObject(); 
            ois.close(); 
         } 
      } catch (IOException e) { 
         e.printStackTrace(); 
      } catch (ClassNotFoundException e) { 
         e.printStackTrace(); 
      }   
      return userList; 
   } 
   private void saveUserList(List<User> userList){ 
      try { 
    	 
    	  File file = new File("/tmp/Users.dat"); 
         FileOutputStream fos;  
         fos = new FileOutputStream(file); 
         ObjectOutputStream oos = new ObjectOutputStream(fos); 
         oos.writeObject(userList); 
         oos.close(); 
      } catch (FileNotFoundException e) { 
         e.printStackTrace(); 
      } catch (IOException e) { 
         e.printStackTrace(); 
      } 
   }    
}