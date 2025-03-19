public enum Zadanie {
    SKRAWANIE,
    ZGRZEWANIE,
    MODELOWANIE,
    PODNOSNIK,
    LAKIEROWANIE,
    SKLEJANIE;

    public String toString() {
        switch (this) {
            case SKRAWANIE:
                return "Skrawanie";
            case ZGRZEWANIE:
                return "Zgrzewanie";
            case MODELOWANIE:
                return "Modelowanie";
            case PODNOSNIK:
                return "Podnosnik";
            case LAKIEROWANIE:
                return "Lakierowanie";
            case SKLEJANIE:
                return "Sklejanie";
            default:
                return "Nieznane zadanie";
        }
    }

    public static Zadanie losujZadanie() {
        // values() - zwraca tablicę wartości enuma
        // bierzemy z niej losowy element
        return values()[new java.util.Random().nextInt(values().length)];
    }
}
