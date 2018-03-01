package dao;

import java.sql.*;

public class Logindao {
    public boolean checkInfo(String user,String pwd){
        boolean flag=false;
        try{
            Connection con=null;
            Statement st=null;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login_data","login","login");
                st=con.createStatement();
                String sql="Select * from login where username=\""+user+"\" and password=\""+pwd+"\";";
                ResultSet rt=st.executeQuery(sql);
                rt.last();
                int i=rt.getRow();
                if(i==1){
                    flag=true;
                }else{
                    flag=false;
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
            finally {
                if(st!=null){
                    st.close();
                    st=null;
                }
                if(con!=null){
                    con.close();
                    con=null;
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
