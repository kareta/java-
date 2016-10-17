package kareta.laboratoryworks.lab4;

public class SubscriberValidator {

    public static final String NAME_PATTERN = "[a-zA-Z ,.'-]+";
    public static final String SURNAME_PATTERN = "[a-zA-Z ,.'-]+";

    public static void verifyName(String name) throws SubscriberException {
        if (!name.matches(NAME_PATTERN)) {
            throw new SubscriberException("Name is incorrect.");
        }
    }

    public static void verifySurname(String name) throws SubscriberException {
        if (!name.matches(SURNAME_PATTERN)) {
            throw new SubscriberException("Surname is incorrect.");
        }
    }

    public static void verifyCityTalkSeconds(long cityTalkSeconds) throws SubscriberException {
        if (cityTalkSeconds < 0) {
            throw new SubscriberException("Time cannot be negative");
        }
    }

    public static void verifyIntercityTalkSeconds(long intercityTalkSeconds) throws SubscriberException {
        if (intercityTalkSeconds < 0) {
            throw new SubscriberException("Time cannot be negative");
        }
    }
}
