package com.headfirst.designpatterns.chapter6;

public class Stereo {

    private String name;

    public Stereo (String name) {
        this.name = name;
    }

    int volume;

    public void on() {
        System.out.println( name + " stereo is powered up");
    }

    public void off() {
        System.out.println( name + " stereo is shutting down");
    }

    public void setCd() {
        System.out.println("Setting " + name + " stereo cd mode");
    }

    public void setRadio() {
        System.out.println("Setting " + name + " stereo radio mode");
    }
    public void setDvd() {
        System.out.println("Setting " + name + " stereo dvd mode");
    }

    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("Setting " + name + " stereo volume to " + volume);

    }

}
