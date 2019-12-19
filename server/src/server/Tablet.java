/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;
import java.util.Arrays;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author asus
 */

public class Tablet extends Thread{
   ArrayList<String> arr=new ArrayList<String>();
    Object lock;
    Tablet(){}
    
    
    @Override
    public void run() {
        super.run();
        check_availability();
      switch( check_query(""))
              {
              
          case 1:set();
          case 2:delete();
          default:;   
              
              };
       
       
    }
    int  check_query(String query){

    
    return 0;}
        void set(){
        synchronized(lock){}
       
        }
    void delete(){
    synchronized(lock){}
    }
    void update(){
    synchronized(lock){}
    }
    void check_availability(){
    synchronized(lock){}
    
    
    }
    }

