 
package server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class Client implements Runnable{
    Socket s;
    ObjectOutputStream outc;
    ObjectInputStream inc;
    Object lock,t1,t2;
    char[] boundary=new char[]{'A','G','O','z'} ;
    
    public Client(Socket s,Object t1,Object t2){ 
    this.s =s;
    this.t1=t1;
    this.t2=t2;
    }
    
    
    @Override
    public void run() {
        
        
        try{
        //ArrayList<Thread> th=new ArrayList<Thread>();
       outc=new ObjectOutputStream(s.getOutputStream());
       inc=new ObjectInputStream( s.getInputStream());
        
        while(!s.isClosed()){
        
         String d=(String )inc.readObject();
         if(!d.equals("")){
         String[] queries= d.trim().replaceAll(" +"," ").split("|");
        String action=queries[0];
        for(int i=1;i< queries.length;++i){
            String key= queries[i].split(":")[0];
     Thread t=   new Thread(new Request( check_boudary(key),queries[i],action,outc));
     t.start();
     
        }
        
         
        
        }
      
        }
        }
        catch(Exception e){}
        
        
        
         }
    Object check_boudary(String key){
    if(key.charAt(0)>=boundary[0] && key.charAt(0)<=boundary[1])
        return t1;
    
    return t2;}
  
    
}
