package ru.house.manager.daoDB;
import ru.house.manager.EntityDB.Users;

import java.sql.SQLException;
import java.util.List;
public interface UsersDao {

    // create
    void add(Users User) throws SQLException;

    // read
    List<Users> getAll() throws SQLException;
    Users getById(int id) throws SQLException;

    // update
    void update(Users User) throws SQLException;

    // delete
    void remove(Users User) throws SQLException;
    int getLastId() throws SQLException;
}
