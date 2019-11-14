package ru.house.manager.EntityDB;

public class Houses {
    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    public int getManageCompanyId() {
        return manageCompanyId;
    }

    public void setManageCompanyId(int manageCompanyId) {
        this.manageCompanyId = manageCompanyId;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getResidentsNumber() {
        return residentsNumber;
    }

    public void setResidentsNumber(int residentsNumber) {
        this.residentsNumber = residentsNumber;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    private int houseId;
    private int manageCompanyId;
    private String adress;
    private String city;
    private int residentsNumber;
    private String accessToken;

    public Houses() {

    }
}
