package serviceDB;
import BLBD.Util;
import com.sun.xml.xsom.XSTerm;
import com.sun.xml.xsom.visitor.XSTermFunction;
import daoDB.UserTestDao;
import EntityDB.TestUsers;
import oracle.jdbc.proxy.annotation.Pre;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserTestService extends Util implements UserTestDao{

    Connection connection = getConnection();

    @Override
    public void add(TestUsers testUser) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO TEST_USERS (ID, FULL_NAME, BIRTH_DATE) VALUES(?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement((sql));


            preparedStatement.setInt(1, testUser.getId());
            preparedStatement.setString(2, testUser.getFullName());
            preparedStatement.setString(3, testUser.getBirthDate());

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
    public List<TestUsers> getAll() throws SQLException {
        List<TestUsers> testUsersList = new ArrayList<>();

        String sql = "SELECT ID, FULL_NAME, BIRTH_DATE FROM TEST_USERS";
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                TestUsers testUsers = new TestUsers();
                testUsers.setId(resultSet.getInt("ID"));
                testUsers.setFullName(resultSet.getString("FULL_NAME"));
                testUsers.setBirthDate(resultSet.getString("BIRTH_DATE"));

                testUsersList.add(testUsers);
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
        return  testUsersList;
    }

    @Override
    public TestUsers getById(int id) throws SQLException {

        String sql = "SELECT ID, FULL_NAME, BIRTH_DATE FROM TEST_USERS WHERE ID = ?";
        PreparedStatement preparedStatement = null;
        TestUsers testUsers = new TestUsers();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            testUsers.setId(resultSet.getInt("ID"));
            testUsers.setFullName(resultSet.getString("FULL_NAME"));
            testUsers.setBirthDate(resultSet.getString("BIRTH_DATE"));

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
        return  testUsers;
    }

    @Override
    public void update(TestUsers testUser) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE TEST_USERS SET FULL_NAME = ?, BIRTH_DATE = ? WHERE ID = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, testUser.getFullName());
            preparedStatement.setString(2, testUser.getBirthDate());
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
    public void remove(TestUsers testUser) throws SQLException {
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
