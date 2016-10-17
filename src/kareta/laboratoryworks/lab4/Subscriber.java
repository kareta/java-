package kareta.laboratoryworks.lab4;

import kareta.laboratoryworks.lab3.Person;

public class Subscriber extends Person {

    private Address address;
    private long cityTalkSeconds;
    private long intercityTalkSeconds;

    public Subscriber(String name, String surname, Address address) {
        super(name, surname);
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public long getCityTalkSeconds() {
        return cityTalkSeconds;
    }

    public void setCityTalkSeconds(long cityTalkSeconds) {
        this.cityTalkSeconds = cityTalkSeconds;
    }

    public long getIntercityTalkSeconds() {
        return intercityTalkSeconds;
    }

    public void setIntercityTalkSeconds(long intercityTalkSeconds) {
        this.intercityTalkSeconds = intercityTalkSeconds;
    }

    public void addCityTalkSeconds(long cityTalkSeconds) {
        this.cityTalkSeconds += cityTalkSeconds;
    }

    public void addIntercityTalkSeconds(long intercityTalkSeconds) {
        this.intercityTalkSeconds += intercityTalkSeconds;
    }
}
