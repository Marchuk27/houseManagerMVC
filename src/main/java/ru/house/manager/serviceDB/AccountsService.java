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
        String sql = "INSERT INTO ACCOUNTS_HMS (E_MAIL, HASH_PASSWORD, RESIDENT_FLAG, SALT) VALUES(?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement((sql));
            preparedStatement.setString(1, Account.geteMail());
            preparedStatement.setString(2, Account.getHashPassword());
            preparedStatement.setInt(3, Account.getResidentFlag());
            preparedStatement.setString(4, Account.getSalt());
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

        String sql = "SELECT ACCOUNT_ID, E_MAIL, HASH_PASSWORD, RESIDENT_FLAG, SALT FROM ACCOUNTS_HMS";
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Accounts account = new Accounts();
                account.setId(resultSet.getInt("ACCOUNT_ID"));
                account.seteMail(resultSet.getString("E_MAIL"));
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
        String sql = "SELECT E_MAIL, HASH_PASSWORD, RESIDENT_FLAG, SALT FROM ACCOUNTS_HMS WHERE ACCOUNT_ID = ?";
        PreparedStatement preparedStatement = null;
        Accounts account = new Accounts();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            account.seteMail(resultSet.getString("E_MAIL"));
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
    public Accounts getByEmail(String eMail) throws SQLException {
        String sql = "SELECT  HASH_PASSWORD, RESIDENT_FLAG, SALT, ACCOUNT_ID FROM ACCOUNTS_HMS WHERE E_MAIL = ?";
        PreparedStatement preparedStatement = null;
        Accounts account = new Accounts();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, eMail);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            account.setHashPassword(resultSet.getString("HASH_PASSWORD"));
            account.setResidentFlag(resultSet.getInt("RESIDENT_FLAG"));
            account.setSalt(resultSet.getString("SALT"));
            account.setId(resultSet.getInt("ACCOUNT_ID"));

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
        String sql = "UPDATE ACCOUNTS_HMS SET E_MAIL = ?, HASH_PASSWORD = ?, RESIDENT_FLAG = ?, SALT = ? WHERE ACCOUNT_ID = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,Account.geteMail());
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
        String sql = "DELETE FROM ACCOUNTS_HMS WHERE ACCOUNT_ID = ?";

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
