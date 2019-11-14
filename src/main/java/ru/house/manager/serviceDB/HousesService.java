package ru.house.manager.serviceDB;
import ru.house.manager.BLDB.Util;
import ru.house.manager.daoDB.HousesDao;
import ru.house.manager.EntityDB.Houses;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import  java.sql.*;

public class HousesService extends Util implements HousesDao{

    Connection connection = getConnection();

    @Override
    public void add(Houses House) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO HOUSES_HMS (manage_company_id, adress, city_name, amount_of_residents, access_token) VALUES(?, ?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement((sql));
            preparedStatement.setInt(1,House.getManageCompanyId());
            preparedStatement.setString(2,House.getAdress());
            preparedStatement.setString(3, House.getCity());
            preparedStatement.setInt(4, House.getResidentsNumber());
            preparedStatement.setString(5, House.getAccessToken());

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
    public Houses getById(int id) throws SQLException {

        String sql = "SELECT manage_company_id, adress, city_name, amount_of_residents, access_token FROM houses_HMS WHERE house_ID = ?";
        PreparedStatement preparedStatement = null;
        Houses house = new Houses();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            house.setManageCompanyId(resultSet.getInt("manage_company_id"));
            house.setAccessToken(resultSet.getString("access_token"));
            house.setAdress(resultSet.getString("adress"));
            house.setResidentsNumber(resultSet.getInt("AMOUNT_OF_RESIDENTS"));
            house.setCity(resultSet.getString("city_name"));

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
        return house;
    }

}
