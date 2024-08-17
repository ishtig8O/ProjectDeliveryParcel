package com.example.project2;

public class Context {
    private final static Context instance = new Context();



    public static Context getInstance() {
        return instance;
    }

    private Integer id;
    private boolean isClient;

    public int getId() {
        return id;
    }

    public boolean getIsClient() {
        return isClient;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIsClient(boolean isClient) {
        this.isClient = isClient;
    }

}