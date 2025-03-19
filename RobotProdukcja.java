/** Klasa RobotProdukcja dziedzicząca po klasie RobotFabryczny. */
// `final` - nie można dziedziczyć od klasy RobotProdukcja.
public final class RobotProdukcja extends RobotFabryczny {

    public RobotProdukcja(String nazwa, Zadanie zadanie) {
        super(nazwa, zadanie);
    }

}
