import java.sql.*;
import java.io.*;
import java.util.*;

public class QOne {

   public static void main(String args[]) throws Exception {

       //Scanner class fro input
       Scanner in = new Scanner(System.in);
 
      //Registering the Driver
      DriverManager.registerDriver(new com.mysql.jdbc.Driver());

      //Getting the connection
       Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/lab1","root","om#12prakash");
      System.out.println("Connection established......");

      //Creating a Statement object
      Statement stmt = con.createStatement();

      //Retrieving the data
      ResultSet rs = stmt.executeQuery("Show tables");

      System.out.println("Tables and Tables number are shown of  the current database: ");

      int count = 1;
      while(rs.next()) {
         String g = rs.getString(1);
         System.out.print(" TABLE NUMBER " + count + " TABLE NAME " + g);
         count++;
         System.out.println();
      }

      System.out.print("ENTER A VALID TABLE NUMBER TO SHOW : ");
      
      int n = in.nextInt();
 
      if(n>count){
      System.out.println("Envalid nuber ---terminate -------");
      
     }
     ResultSet rs1  = stmt.executeQuery("Show tables");
     int n1 = 0;
     while(n1!=n){
     n1++;
     rs1.next();
     }

      String s1="SELECT * FROM ";  
      String s2=rs1.getString(1);
      String s3=s1.concat(s2);  
      rs = stmt.executeQuery(s3);
 
    if(n==1){
        System.out.println("name \t\t   meets_at  \t\t  room  \t\t  fid"); 
  
            // Condiion check 
            while (rs.next()) { 
  
                int fid = rs.getInt("fid"); 
                String name = rs.getString("name"); 
                String room = rs.getString("room"); 
                String meets_at = rs.getString("meets_at"); 
                System.out.println(name  + "  \t\t  " + meets_at + "  \t\t  " + room + "  \t\t  " + fid); 
            } 
       }

     else if(n==2){
        System.out.println("snum  \t\t   cname"); 
  
            // Condiion check 
            while (rs.next()) { 
  
                int snum= rs.getInt("snum"); 
                String cname = rs.getString("cname"); 
                System.out.println(snum + "  \t\t  " +cname ); 
            } 
       }

      else if(n==3){
        System.out.println("fid \t\t  fname  \t\t  deptid"); 
  
            // Condiion check 
            while (rs.next()) { 
  
                int fid = rs.getInt("fid"); 
                String fname = rs.getString("fname"); 
                int deptid= rs.getInt("deptid");
                System.out.println(fid  + "  \t\t  " + fname + "  \t\t  " + deptid); 
            } 
       }
     else{
           System.out.println("snum  \t\t  sname  \t\t  major  \t\t  level \t\t  age "); 
  
            // Condiion check 
            while (rs.next()) { 
  
                int snum = rs.getInt("snum"); 
                String sname = rs.getString("sname");
                String major = rs.getString("major");
                String level = rs.getString("level");
                int age= rs.getInt("age");
                System.out.println(snum  + "  \t\t  " + sname + "  \t\t  " + major + "  \t\t  " + level + "  \t\t  " + age ); 
            }    
      }
  }
}