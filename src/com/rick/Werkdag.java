package com.rick;

/**
 * Created by Rick on 7-6-2016.
 */
public class Werkdag {
    private String datum;
    private String dagVanWeek;
    private String beginTijd;
    private String eindTijd;

    public Werkdag(String beginTijd, String dagVanWeek, String datum, String eindTijd) {
        this.beginTijd = beginTijd;
        this.dagVanWeek = dagVanWeek;
        this.datum = datum;
        this.eindTijd = eindTijd;
    }

    public String getBeginTijd() {
        return beginTijd;
    }

    public void setBeginTijd(String beginTijd) {
        this.beginTijd = beginTijd;
    }

    public String getDagVanWeek() {
        return dagVanWeek;
    }

    public void setDagVanWeek(String dagVanWeek) {
        this.dagVanWeek = dagVanWeek;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getEindTijd() {
        return eindTijd;
    }

    public void setEindTijd(String eindTijd) {
        this.eindTijd = eindTijd;
    }
}
