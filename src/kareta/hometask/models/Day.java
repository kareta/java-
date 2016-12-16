package kareta.hometask.models;

public enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY, NODAY;

    public static Day fromString(String day) {
        switch (day) {
            case "monday":
                return MONDAY;
            case "tuesday":
                return TUESDAY;
            case "wednesday":
                return WEDNESDAY;
            case "thursday":
                return THURSDAY;
            case "friday":
                return FRIDAY;
            case "saturday":
                return SATURDAY;
            case "sunday":
                return SUNDAY;
            default:
                return NODAY;
        }
    }
}
