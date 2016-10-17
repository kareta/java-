package kareta.laboratoryworks.lab4;

public class AddressValidator {

    public static final String COUNTRY_PATTERN = "[a-zA-Z]{2,}";
    public static final String CITY_PATTERN = "[a-zA-Z]{2,}";
    public static final String STREET_PATTERN = "[a-zA-Z]{2,}";
    public static final String BUILDING_PATTERN = "[a-zA-Z0-9]{2,}";

    public static void verifyCountry(String country) throws AddressException {
        if (!country.matches(COUNTRY_PATTERN)) {
            throw new AddressException("Country is incorrect.");
        }
    }

    public static void verifyCity(String city) throws AddressException {
        if (!city.matches(CITY_PATTERN)) {
            throw new AddressException("City is incorrect.");
        }
    }

    public static void verifyStreet(String street) throws AddressException {
        if (!street.matches(STREET_PATTERN)) {
            throw new AddressException("Street is incorrect.");
        }
    }

    public static void verifyBuilding(String building) throws AddressException {
        if (!building.matches(BUILDING_PATTERN)) {
            throw new AddressException("Building is incorrect.");
        }
    }
}
