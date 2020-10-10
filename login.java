
  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author hp
 */
public class login {
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
                 PreparedStatement pst=con.prepareStatement(" select * from cmc where username=? and password=? ");
              
                 pst.setString(1,name);
             
pst.setString(2,pass);
         ResultSet a= pst.executeQuery();
         while(a.next()){
           //  System.out.println(a.getString(1));
             System.out.println("welcome"+name);
         }
        
     }
catch(    ClassNotFoundException | SQLException a){
                          System.out.println(a.getMessage());
        
         }

    
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
