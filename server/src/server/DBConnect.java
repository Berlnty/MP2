/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.sql.*;


public class DBConnect {
     Connection con;
         Statement st;
         ResultSet rs;
      public   DBConnect(){
         try{
        Class.forName("com.mysql.jdbc.Driver");
        con =DriverManager.getConnection("jdbc:mysql://localhost:3306/the_white_house","root","");
        st=con.createStatement();
         }
         catch(Exception e){
         System.out.println("Err in connection: "+e);
         }
         }
      
      
      public String getData(String query){
          String ret= "No data to return\n";
      try{
     // String query ="select * from `nominations_appointments` where `Name`= 'me'";
      rs= st.executeQuery(query);
    //  System.out.println("Records from: ");
 //     String out= rs.next();
  String back="";
     while(rs.next()){
        
     back+=("Name: "+ rs.getString("Name")+",Position Title: "+rs.getString("Position Title")+",Agency Name: "+rs.getString("Agency Name")+",Agency Website: "+rs.getString("Agency Website")+",Nomination Date: "+rs.getString("Nomination Date")+",Renomination: "+rs.getString("Renomination")
             +",Confirmation Vote: "+rs.getString("Confirmation Vote")+",Confirmed: "+rs.getString("Confirmed")+",Holdover: "+rs.getString("Holdover")+'\n');
      }
     if(!back.equals(""))
     ret= back;
      }
      catch(Exception e){
      System.out.println("error: "+e);
      
      return "couldn't execute the query\n";
       }
      return ret;
      }
}
