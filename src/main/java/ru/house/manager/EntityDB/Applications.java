package ru.house.manager.EntityDB;

public class Applications {
    public Applications() {

    }
    private int applicationsId;

    public int getApplicationsId() {
        return applicationsId;
    }

    public void setApplicationsId(int applicationsId) {
        this.applicationsId = applicationsId;
    }

    public int getManageId() {
        return manageId;
    }

    public void setManageId(int manageId) {
        this.manageId = manageId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    private int manageId;
    private int userId;
    private String data;
    private String text;
    private String status;
    private String imageName;

}
