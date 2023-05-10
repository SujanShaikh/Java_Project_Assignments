package jdbcConnections;

import java.sql.*;

public class ConnectionFileDemo {
    public static void main(String[] args) {

        try {
            Connection connection;
            PreparedStatement preparedStatement;
            ResultSet resultSet;

            //1. Loading Driver
            Class.forName("com.mysql.jdbc.Driver");
            //2.Establish Connection
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/eltp_jan_2023","root","Sujan@123");
            //3. Prepare Statement
            preparedStatement=connection.prepareStatement("SELECT * FROM Student WHERE sname='sujan'");
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getInt(3));
            }




        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
