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
        return null;
    }

    @Override
    public Accounts getById(int id) throws SQLException {
        return null;
    }

    @Override
    public void update(Accounts Account) throws SQLException {

    }

    @Override
    public void remove(Accounts Account) throws SQLException {

    }
}
