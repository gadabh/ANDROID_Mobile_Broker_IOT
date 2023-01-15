package com.example.myapplicationfinaaaaaaaaaaaaaaaaaaaaaaaaaaaaal;

public class Personne {

    private String Date_and_Time;
    private String Name;

    public Personne(String Date_and_Time, String topic) {
        this.Name = topic;
        Date_and_Time = Date_and_Time;

    }

    public Personne() {
    }

    public String getDate_and_Time() {
        return Date_and_Time;
    }

    public void setDate_and_Time(String Date_and_Time) {
        Date_and_Time = Date_and_Time;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
}
