package kareta.laboratoryworks.lab4;

public class Address {
    private String country;
    private String city;
    private String street;
    private String buiding;

    public Address(String country, String city, String street, String buiding) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.buiding = buiding;
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

    public String getBuiding() {
        return buiding;
    }

    public void setBuiding(String buiding) {
        this.buiding = buiding;
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", buiding='" + buiding + '\'' +
                '}';
    }
}
