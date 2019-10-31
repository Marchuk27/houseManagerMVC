package EntityDB;
import java.util.Objects;

public class TestUsers {

    private int id;
    private String fullName;
    private String birthDate;

    public TestUsers() {

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }


    @Override
    public String toString() {
        return "TestUsers{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }
}
