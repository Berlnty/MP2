
package server;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Request implements Runnable{
    Object lock;
    String req,action;
    ObjectOutputStream inc;
    
    
    
    public Request(Object t1,String req,String action,ObjectOutputStream inc){
    this.lock=t1;
    this. req=req;
    this.action=action;
    this.inc=inc;
    }
    
    
    
    @Override
    public void run() {
        check_availability();
        
         switch(action){
             case "set":set(req);
             case "delete_cell":deleteCell(req);
              case"delete_row":deleteRow(req);
             case "add":addRow(req);
             case "read":readRows(req);
         
         }
         
    }
    
    
    void check_availability(){
    synchronized(lock){
    
    }
    
    }
 void set( String queries){
 
 synchronized(lock){
 
  DBConnect connect=new DBConnect();
        
  
    String query ="";
     connect.getData(query);
    
 }
 
 }
  void deleteRow( String queries){
 
 synchronized(lock){
 
  DBConnect connect=new DBConnect();
        
  
    String query ="";
     connect.getData(query);
      
 }
 
 }
    void deleteCell( String queries){
 
 synchronized(lock){
  DBConnect connect=new DBConnect();
        
  
    String query ="";
     connect.getData(query);
      
 
 }
 
 }
    void readRows( String queries){
 
  DBConnect connect=new DBConnect();
        
  
    String[] query= queries.trim().split(":");
    String send="SELECT * FROM `nominations_appointments` WHERE `Name`='"+query[0]+"'";
    send= connect.getData(send);
    try{
    System.out.println("message: "+send);
     inc.writeObject(send);
    }catch(Exception e){}
 
 }
 void addRow( String queries){
 
 synchronized(lock){
 
  DBConnect connect=new DBConnect();
        
  
    String query ="";
     connect.getData(query);
      
 
 }
 
 }
    
}
