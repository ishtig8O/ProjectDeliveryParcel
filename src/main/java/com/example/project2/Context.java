package com.example.project2;

public class Context {
    private final static Context instance = new Context();


    public static Context getInstance() {
        return instance;
    }

    public static String getDBName() {
        return "jdbc:mysql://localhost:8080/project2";
    }

    private Integer id;
    private boolean isClient;

    private String mainPage;

    public int getId() {
        return id;
    }

    public boolean getIsClient() {
        return isClient;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIsClient(boolean isClient) {this.isClient = isClient;
    }

    public void setMainPage(String mainPage) {this.mainPage = mainPage;
    }

    public String getMainPage() {
        return this.mainPage;
    }
}