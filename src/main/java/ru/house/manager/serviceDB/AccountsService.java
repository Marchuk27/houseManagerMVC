package ru.house.manager.serviceDB;
import ru.house.manager.BLDB.Util;
import ru.house.manager.daoDB.AccountsDao;
import ru.house.manager.EntityDB.Accounts;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountsService extends Util implements AccountsDao{

    Connection connection = getConnection();

    @Override
    public void add(Accounts Account) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO ACCOUNTS_HM (ACCOUNT_ID, LOGIN, HASH_PASSWORD, RESIDENT_FLAG, SALT) VALUES(?, ?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement((sql));
            preparedStatement.setInt(1, Account.getId());
            preparedStatement.setString(2, Account.getLogin());
            preparedStatement.setString(3, Account.getHashPassword());
            preparedStatement.setInt(4, Account.getResidentFlag());
            preparedStatement.setString(5, Account.getSalt());
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
    public List<Accounts> getAll() throws SQLException {
        List<Accounts> accountsList = new ArrayList<>();

        String sql = "SELECT ACCOUNT_ID, LOGIN, HASH_PASSWORD, RESIDENT_FLAG, SALT FROM ACCOUNTS_HM";
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Accounts account = new Accounts();
                account.setId(resultSet.getInt("ACCOUNT_ID"));
                account.setLogin(resultSet.getString("LOGIN"));
                account.setHashPassword(resultSet.getString("HASH_PASSWORD"));
                account.setResidentFlag(resultSet.getInt("RESIDENT_FLAG"));
                account.setSalt(resultSet.getString("SALT"));
                accountsList.add(account);
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
        return accountsList;
    }

    @Override
    public Accounts getById(int id) throws SQLException {
        String sql = "SELECT LOGIN, HASH_PASSWORD, RESIDENT_FLAG, SALT FROM ACCOUNTS_HM WHERE ACCOUNT_ID = ?";
        PreparedStatement preparedStatement = null;
        Accounts account = new Accounts();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            account.setLogin(resultSet.getString("LOGIN"));
            account.setHashPassword(resultSet.getString("HASH_PASSWORD"));
            account.setResidentFlag(resultSet.getInt("RESIDENT_FLAG"));
            account.setSalt(resultSet.getString("SALT"));

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
        return account;
    }

    @Override
    public void update(Accounts Account) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE ACCOUNTS_HM SET LOGIN = ?, HASH_PASSWORD = ?, RESIDENT_FLAG = ?, SALT = ? WHERE ACCOUNT_ID = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,Account.getLogin());
            preparedStatement.setString(2, Account.getHashPassword());
            preparedStatement.setInt(3, Account.getResidentFlag());
            preparedStatement.setString(4, Account.getSalt());
            preparedStatement.setInt(5, Account.getId());

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
    public void remove(Accounts Account) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM ACCOUNTS_HM WHERE ACCOUNT_ID = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, Account.getId());

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
