package com.example.ahand.assignment2;

import android.media.Image;

/**
 * Created by ahand on 4/28/17.
 */

public class Automobile {

    private int make_id;
    private String make;

    public Automobile(int make_id, String make) {
        this.make_id = make_id;
        this.make = make;
    }

    public int getMake_id() {
        return make_id;
    }

    public void setMake_id(int make_id) {
        this.make_id = make_id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }
}
