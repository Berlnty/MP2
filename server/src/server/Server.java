package server;
import java.awt.*;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.*;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Scanner; 
import java.sql.*;  


public class Server {
     ArrayList<String> ranges=new ArrayList<String>();
static Object T1= new Object();
static Object T2= new Object();
     public static void main(String args[])throws Exception{
        
      /*  Socket s=new Socket("localhost",6000); 
       boolean endstart=false;
  
        ObjectOutputStream out=new ObjectOutputStream(s.getOutputStream());
             ObjectInputStream in=new ObjectInputStream( s.getInputStream());*/
        try{
            /*
            while(!endstart){
            
            endstart=start(out,in);
            }*/
            
         ServerSocket  ss = new ServerSocket(7000);  
           System.out.println("server");
            
            
           try{
               while(true){
         new Thread(new Client(ss.accept(),T1,T2)).start();
         
            //update to master
               }
         }
         catch(Exception e){}
    
     finally{
           
           ss.close();
           }
            
             
           
        }
        catch(Exception e){
            System.out.println("client: "+e);
               // s.close();  //close the socket
        }
        
     }
     
     static boolean start( ObjectOutputStream out, ObjectInputStream in) throws IOException, ClassNotFoundException{
        out.writeObject("server is ready");
            Element[] in_data = (Element[])in.readObject();
            insert_database(in_data);
            set_metadata();
     return true;
     }
     
     
     static void insert_database(Element[] arr){
         DBConnect connect=new DBConnect();
        
      for(int i=0;i<arr.length;++i){
          String query ="INSERT INTO `nominations_appointments`(`Name`, `Position Title`, `Agency Name`, `Agency Website`, `Nomination Date`, `Renomination`, `Confirmation Vote`, `Confirmed`, `Holdover`) VALUES ("+arr[i].get_name()+","+arr[i].get_position()+","+arr[i].get_agancy_name()+","+arr[i].get_agancy_website()+","+arr[i].get_nomination_date()+","+arr[i].get_renomination()+","+arr[i].get_confirmation_date()+","+arr[i].get_confirmed()+","+arr[i].get_holdover()+")";
           connect.getData(query);
      }
     
     }
     static void    set_metadata(){
     
     
     
     }
     
    
}
