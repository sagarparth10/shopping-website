/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 *
 * @author hp
 */
public class Database {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection con= null;
        Scanner scanner=new Scanner(System.in);
        System.out.println("please provide below details to connect oracle database");
     System.out.println("enter name");
     String name = scanner.nextLine();
     System.out.println("enter password");
     String pass = scanner.nextLine();
     
     try
     {
         Class.forName("oracle.jdbc.driver.OracleDriver");
                 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","system");
                 PreparedStatement pst=con.prepareStatement("insert into cmc values(?,?)");
                 pst.setString(1,name);
                 pst.setString(2,pass);
        int a= pst.executeUpdate();
        if(a>0)
        {
                     System.out.println(a);
                     System.out.println("register successfully");
        }
        else
        {
                         System.out.println("oops register unsuccessful");
        
        }}
catch(Exception a){
                          System.out.println(a.getMessage());
        
         }
     
    }
    }
