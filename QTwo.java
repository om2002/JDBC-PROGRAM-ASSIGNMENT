import java.sql.*;
import java.io.*;
import java.util.*;

public class QTwo {

 static void A(){
          try{
              Scanner in = new Scanner(System.in);
 
        //Registering the Driver
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
   
        //Getting the connection
         Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/lab1","root","om#12prakash");
         System.out.println("Connection established......");

        //Creating a Statement object
        Statement stmt = con.createStatement();
         
         System.out.print("ENTER  NAME OF ROOM :   ");
         String s = in.nextLine();
         System.out.println(); 


         s = "'"+s;
         s = s + "'";
         String s1="select name from class where room = ";  
         String s3=s1.concat(s);
      //   System.out.println(s3); 

        //Retrieving the data
         ResultSet rs = stmt.executeQuery(s3);
   
           System.out.println("name of course are following   "); 
  
            // Condiion check 
            while (rs.next()) { 
                String name = rs.getString("name");
                System.out.println(name); 
            } 
              System.out.println();
         }


        catch(Exception e){ System.out.println(e+"there is exception");
       }  
}

 static void B(){
          try{
              Scanner in = new Scanner(System.in);
 
        //Registering the Driver
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
   
        //Getting the connection
         Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/lab1","root","om#12prakash");
         System.out.println("Connection established......");

        //Creating a Statement object
        Statement stmt = con.createStatement();
         
         System.out.print("ENTER  NAME OF COURSE :   ");
         String s = in.nextLine();
         System.out.println(); 

         s = "'"+s;
         s = s + "'";
         String s1=" select room,meets_at  from class where name = ";  
         String s3=s1.concat(s);
         //System.out.println(s3); 

        //Retrieving the data
         ResultSet rs = stmt.executeQuery(s3);
   
           System.out.print("name of room is   "); 
  
            // Condiion check 
            while (rs.next()) { 
                String room = rs.getString("room");
                String meets_at = rs.getString("meets_at");
                System.out.println(room + "    meeting time is    "+ meets_at); 
            } 
              System.out.println();
         }


        catch(Exception e){ System.out.println(e+"there is exception");
       }  
}



static void C(){
          try{
              Scanner in = new Scanner(System.in);
 
        //Registering the Driver
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
   
        //Getting the connection
         Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/lab1","root","om#12prakash");
         System.out.println("Connection established......");

        //Creating a Statement object
        Statement stmt = con.createStatement();
         
         System.out.print("ENTER  NAME OF FACULTY :   ");
         String s = in.nextLine();
         System.out.println(); 


         s = "'"+s;
         s = s + "'";
         s = s +")";
         String s1="select name from class where fid in (select fid from faculty where fname = ";  
         String s3=s1.concat(s);
      //   System.out.println(s3); 

        //Retrieving the data
         ResultSet rs = stmt.executeQuery(s3);
   
           System.out.println("name of course are following   "); 
  
            // Condiion check 
            while (rs.next()) { 
                String name = rs.getString("name");
                System.out.println(name); 
            } 
              System.out.println();
         }


        catch(Exception e){ System.out.println(e+"there is exception");
       }  
}

static void D(){
          try{
              Scanner in = new Scanner(System.in);
 
        //Registering the Driver
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
   
        //Getting the connection
         Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/lab1","root","om#12prakash");
         System.out.println("Connection established......");

        //Creating a Statement object
        Statement stmt = con.createStatement();
         
         String s1=" select fname,fid from faculty where deptid = 20 and fid in (select fid from class where room = 'R128')";  
       

        //Retrieving the data
         ResultSet rs = stmt.executeQuery(s1);
   
           System.out.println("name of faculty are following   "); 
  
            // Condiion check 
            while (rs.next()) {
                int fid =  rs.getInt("fid");
                String name = rs.getString("fname");
                System.out.println(name +"     "+fid); 
            } 
              System.out.println();
         }


        catch(Exception e){ System.out.println(e+"there is exception");
       }  
}



   public static void main(String args[]) throws Exception {
       Scanner in = new Scanner(System.in);
       int n;

       while(true){
       System.out.println("ENTER 1 FOR A ");
       System.out.println("ENTER 2 FOR B ");
       System.out.println("ENTER 3 FOR C ");
       System.out.println("ENTER 4 FOR D ");
       System.out.println("ENTER 5 FOR EXIT ");
       System.out.println("ENTER YOUR CHOICE ");

       n = in.nextInt();
       if(n==1)
        A();
       else if(n==2)
        B();
       else if(n==3)
        C();
       else if(n==4)
       D();
       else
        break;
       
    }
  
  }
}