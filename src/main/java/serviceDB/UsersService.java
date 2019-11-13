package serviceDB;
import BLBD.Util;
import daoDB.UsersDao;
import EntityDB.Users;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersService extends Util implements UsersDao {

    Connection connection = getConnection();

    @Override
    public void add(Users testUser) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO SBER_USERS (FIRST_NAME, LAST_NAME, FATHER_NAME, PHONE_NUMBER, E_MAIL, ROOM_NUMBER) VALUES(?, ?, ?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement((sql));


            preparedStatement.setString(1, testUser.getFirstName());
            preparedStatement.setString(2, testUser.getLastName());
            preparedStatement.setString(3, testUser.getFatherName());
            preparedStatement.setString(4, testUser.getPhoneNumber());
            preparedStatement.setString(5, testUser.geteMail());
            preparedStatement.setString(6, testUser.getRoomNumber());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public List<Users> getAll() throws SQLException {
        List<Users> usersList = new ArrayList<>();

        String sql = "SELECT ID, FULL_NAME, BIRTH_DATE FROM TEST_USERS";
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Users users = new Users();
                users.setId(resultSet.getInt("ID"));
                //testUsers.setFullName(resultSet.getString("FULL_NAME"));
                //testUsers.setBirthDate(resultSet.getString("BIRTH_DATE"));

                usersList.add(users);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return usersList;
    }

    @Override
    public Users getById(int id) throws SQLException {

        String sql = "SELECT ID, FULL_NAME, BIRTH_DATE FROM TEST_USERS WHERE ID = ?";
        PreparedStatement preparedStatement = null;
        Users users = new Users();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            users.setId(resultSet.getInt("ID"));
            //testUsers.setFullName(resultSet.getString("FULL_NAME"));
            //testUsers.setBirthDate(resultSet.getString("BIRTH_DATE"));

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return users;
    }

    @Override
    public void update(Users testUser) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE TEST_USERS SET FULL_NAME = ?, BIRTH_DATE = ? WHERE ID = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            //preparedStatement.setString(1, testUser.getFullName());
            //preparedStatement.setString(2, testUser.getBirthDate());
            preparedStatement.setInt(3, testUser.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public void remove(Users testUser) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "DELETE  FROM TEST_USERS WHERE ID = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, testUser.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
