/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.Serializable;

/**
 *
 * @author asus
 */
public class Element  implements Serializable {
    String name="";
    String position_title="";
    String agancy_name="";
    String agancy_website="";
    String nomination_date="";
    String confirmation_date="";
    
    int renomination=-1;
    int confirmed=-1;
    int holdover=-1;
    
        
    
    public Element(String n){name=n;};
   public String get_name(){return name;}
    public String get_position(){return position_title;}
     public String get_agancy_name(){return agancy_name;}
      public String get_agancy_website(){return agancy_website;}
       public String get_nomination_date(){return nomination_date;}
        public String get_confirmation_date(){return confirmation_date;}
        public int get_renomination(){return renomination;}
         public int get_confirmed(){return confirmed;}
          public int get_holdover(){return holdover;}
}
