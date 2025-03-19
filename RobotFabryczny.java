/** Klasa RobotFabryczny dziedzicząca po klasie Robot. */
// `abstract` - nie można utworzyć żadnych obiektów klasy RobotFabryczny – służy
// tylko do stworzenia hierarchii robotów
public abstract class RobotFabryczny extends Robot {
    private Zadanie zadanie;

    public Zadanie getZadanie() {
        return zadanie;
    }

    public RobotFabryczny(String nazwa, Zadanie zadanie) {
        super(nazwa);
        this.zadanie = zadanie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof RobotFabryczny))
            return false;
        if (!super.equals(o)) // sprawdza też `null`
            return false;

        RobotFabryczny other = (RobotFabryczny) o;

        return this.zadanie == other.zadanie;
    }
}
