package com.rick;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Rick on 7-6-2016.
 */
public class Werkdag {
    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String Subject = "Werken";
    private String datum;
    private String dagVanWeek;
    private String beginTijd;
    private String eindTijd;

    public boolean moetWerken;

    public Werkdag(String beginTijd, String dagVanWeek, String datum, String eindTijd) throws ParseException {
        this.dagVanWeek = dagVanWeek;
        moetWerken(beginTijd);
        correctDate(datum);
        if (moetWerken) correctTijden(beginTijd, eindTijd);
    }

    private void moetWerken(String beginTijd) {
        moetWerken = (!beginTijd.equals("-"));
    }

    private void correctTijden(String beginTijd, String eindTijd) throws ParseException {
        SimpleDateFormat original = new SimpleDateFormat("HH:mm");
        Date beginTijdDate = original.parse(beginTijd);
        Date eindTijdDate = original.parse(eindTijd);

        SimpleDateFormat nieuw = new SimpleDateFormat("h:mm a");
        this.beginTijd = nieuw.format(beginTijdDate);
        this.eindTijd = nieuw.format(eindTijdDate);
    }

    private void correctDate(String datumStr) throws ParseException {
        SimpleDateFormat original = new SimpleDateFormat("dd-MM-yyyy");
        Date datumDate = original.parse(datumStr);
        SimpleDateFormat nieuw = new SimpleDateFormat("MM/dd/yyyy");
        datum = nieuw.format(datumDate);
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

    @Override
    public String toString() {
        return "Werkdag{" +
                "Subject=Werken" +
                ", Start Date=" + datum +
                ", Start Time=" + beginTijd  +
                ", End Time=" + eindTijd +
                ", Location=Jumbo Bert Vis Steenwijk" +
                '}';
    }
}
