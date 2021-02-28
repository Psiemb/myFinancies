package myApplications.myFinancies.dao;

public enum Month {

    JAN("1"), FEB("2");

    private String id;

    Month(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
