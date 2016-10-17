package kareta.laboratoryworks.lab4;

public class Address {
    private String country;
    private String city;
    private String street;
    private String building;

    public Address(String country, String city, String street, String buiding) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.building = buiding;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    @Override
    public String toString() {
        return "Address{" +
                "country " + getCountry() +
                ", city " + getCity() +
                ", street " + getStreet() +
                ", building " + getBuilding() +
                '}';
    }
}
