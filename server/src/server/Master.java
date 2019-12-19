/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;
import java.util.Arrays;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author asus
 */
public class Master {
    public static void main(String args[]) throws Exception {
        
     Socket s=new Socket("localhost",7000); ;  //create a server socket with port 6666
           ObjectOutputStream out=new ObjectOutputStream(s.getOutputStream());
             ObjectInputStream in=new ObjectInputStream( s.getInputStream());
           // PrintWriter out=new PrintWriter(s.getOutputStream(),true);
            try {
               
              
              out.writeObject("read|me|Alonso,Jorge Luis");
              
            System.out.println("data retrived: "+in.readObject());


            } catch (Exception e) {
                System.out.println("server: "+e);
                
                s.close();  //close the server socket
            }
        }
        
        
}
