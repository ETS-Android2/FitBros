package com.example.fitbros;

public class Workout {

    private String name;
    private int image;
    private String description;
    private String amountReps;

    public Workout(String name, int image, String description, String amountReps) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.amountReps = amountReps;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAmountReps() {
        return amountReps;
    }

    public void setAmountReps(String amountReps) {
        this.amountReps = amountReps;
    }
}
