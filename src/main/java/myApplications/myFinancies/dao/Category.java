package myApplications.myFinancies.dao;

public enum Category {

    HEALTH("1"), CLOTHES("2"), FOOD("3"), SPORT_AND_FUN("4"), UNCATEGORIZED("5");

    private String id;

    Category(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
