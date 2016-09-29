package kareta.laboratoryworks.lab3;

public enum Mark {
    UNSATISFACTORY, SATISFACTORY, GOOD, EXCELLENT;

    @Override
    public String toString() {
        switch (this) {
            case UNSATISFACTORY:
                return "2";
            case SATISFACTORY:
                return "3";
            case GOOD:
                return "4";
            case EXCELLENT:
                return "5";
        }
        return "2";
    }
}
