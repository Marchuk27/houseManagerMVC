package daoDB;
import EntityDB.TestUsers;

import java.sql.SQLException;
import java.util.List;
public interface UserTestDao {

    // create
    void add(TestUsers testUser) throws SQLException;

    // read
    List<TestUsers> getAll() throws SQLException;
    TestUsers getById(int id) throws SQLException;

    // update
    void update(TestUsers testUser) throws SQLException;

    // delete
    void remove(TestUsers testUser) throws SQLException;
}
