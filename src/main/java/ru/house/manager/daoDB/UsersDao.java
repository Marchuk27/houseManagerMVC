package ru.house.manager.daoDB;
import ru.house.manager.EntityDB.Users;

import java.sql.SQLException;
import java.util.List;
public interface UsersDao {

    // create
    void add(Users testUser) throws SQLException;

    // read
    List<Users> getAll() throws SQLException;
    Users getById(int id) throws SQLException;

    // update
    void update(Users testUser) throws SQLException;

    // delete
    void remove(Users testUser) throws SQLException;
}
