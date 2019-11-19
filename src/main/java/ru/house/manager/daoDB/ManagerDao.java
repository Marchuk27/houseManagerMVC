package ru.house.manager.daoDB;
import ru.house.manager.EntityDB.Managers;
import java.sql.SQLException;
import java.util.List;

public interface ManagerDao {
    // create
    void add(Managers Manager) throws SQLException;
    Managers getById(int id) throws SQLException;
    Managers getByAccountId(int id) throws SQLException;
}
