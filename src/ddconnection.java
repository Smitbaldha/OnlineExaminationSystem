import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
// import java.sql.*;

public class ddconnection 
{
    public static void main(String[] args)
    {
        
        try
        { 
            int i=0;
            int rollno = 5;
            String name = "Nirav";
            String branch="C.E.";
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/testing","root","$Jhb@111");          
                       
            Statement st1 = con.createStatement();
            int count = st1.executeUpdate("INSERT INTO testing.student VALUES ('"+rollno+"', '"+name+"','"+branch+"')");
            System.out.println(count+" Row/s Affected.\n");
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from testing.student");           
            while(rs.next())
            {
                System.out.println(rs.getString(1) + " : " +rs.getString(2)+ " : " +rs.getString(3));
                i++;
            }
            System.out.print("\n");
            System.out.println("Total rows= "+i);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
