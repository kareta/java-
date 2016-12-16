package kareta.hometask.models;

//Пункт призначення, Номер рейсу, Тип літака, Час вильоту, Дні тижня, Номер
//        літака


import java.util.Date;

public class Flight {
    private String destination;
    private int raceNumber;
    private String planeType;
    private int planeNumber;
    private Date date;
    private Day day;

    public Flight(String destination, int raceNumber, String planeType, int planeNumber, Date date, Day day) {
        this.destination = destination;
        this.raceNumber = raceNumber;
        this.planeType = planeType;
        this.planeNumber = planeNumber;
        this.date = date;
        this.day = day;
    }

    public Flight() {}

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getRaceNumber() {
        return raceNumber;
    }

    public void setRaceNumber(int raceNumber) {
        this.raceNumber = raceNumber;
    }

    public String getPlaneType() {
        return planeType;
    }

    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }

    public int getPlaneNumber() {
        return planeNumber;
    }

    public void setPlaneNumber(int planeNumber) {
        this.planeNumber = planeNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }
}
