/** Klasa RobotProdukcja dziedzicząca po klasie RobotFabryczny. */
// `final` - nie można dziedziczyć od klasy RobotProdukcja.
public final class RobotProdukcja extends RobotFabryczny {

    public RobotProdukcja(String nazwa, Zadanie zadanie) {
        super(nazwa, zadanie);
    }

    public String toString() {
        return "RobotProdukcja {\n" +
                "    dataProdukcji: " + this.getDataProdukcji() + ",\n" +
                "    nazwa: " + this.getNazwa() + ",\n" +
                "    identyfikator: " + this.getIdentyfikator() + ",\n" +
                "    ileZadan: " + this.getIleZadan() + ",\n" +
                "    si: " + this.getSi() + ",\n" +
                "    nrFabryczny: " + this.getNrFabryczny() + "\n" +
                "    zadanie: " + this.getZadanie() + "\n" +
                "}";
    }

}
