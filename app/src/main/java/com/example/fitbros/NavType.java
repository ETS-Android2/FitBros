package com.example.fitbros;

public class NavType {

    // NavType class for ListView on HomeFragment added by Cordelle 2019-11-03

    private String name;
    private String description;

    public NavType() {

    }

    public NavType(String name, String description) {

        this.name = name;
        this.description = description;

    }

    // auto-generate getters and setters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // custom generate the toString OVERRIDE

    @Override
    public String toString() {

        return this.name;

    }
}
