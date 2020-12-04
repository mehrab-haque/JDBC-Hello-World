import java.sql.*;

public class Main {


    public static void main(String[] args) {
        Main main=new Main();
        try {
            Connection connection=main.connect();
            main.query(connection);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","mehrab","pass");
        System.out.println("database connceted successfully");
        return connection;
    }

    private void query(Connection connection) throws SQLException {
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery("select * from users");
        while (resultSet.next()){
            int id=resultSet.getInt("id");
            String name=resultSet.getString("name");
            System.out.println("Id : "+id+" , Name : "+name);
        }
    }

}
