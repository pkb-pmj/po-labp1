import java.time.LocalDate;
import java.util.Random;

/**
 * Klasa RobotSkladanie dziedziczy po RobotFabryczny, implementująca rozszerzoną
 * wersję interfejsu Porozumienie o nazwie PorozumieniePlus.
 */
// `final` - nie można dziedziczyć od klasy RobotSkladanie.
public final class RobotSkladanie extends RobotFabryczny implements PorozumieniePlus {
    /**
     * limit (ile w ciągu jednego cyklu produkcyjnego dany robot może wykonać zadań,
     * zmienna losowana z przedziału [1,10])
     */
    private int limit;

    public RobotSkladanie(String nazwa, Zadanie zadanie) {
        super(nazwa, zadanie);

        // losowa liczba całkowita z zakresu [0, 10] (czyli [0, 11))
        this.limit = new Random().nextInt(11);
    }

    @Override
    public void zadanieWykonaj() {
        // losowa liczba z przedziału [1, 20] (czyli [0, 20) + 1)
        int amount = new Random().nextInt(20) + 1;
        // w przypadku robotów z limitem - po przekroczeniu limitu metoda wypisuje na
        // konsolę komunikat ostrzegający i nie zwiększa licznika ileZadan ponad wartość
        // limit.
        if (this.ileZadan + amount > this.limit) {
            System.out.println("Przekroczono limit ilości zadań");
            return;
        }
        this.ileZadan += amount;
        // ale można to też zinterpretować na przykład tak:
        // this.ileZadan += amount;
        // if (this.ileZadan > this.limit) {
        // System.out.println("Przekroczono limit ilości zadań");
        // this.ileZadan = this.limit;
        // }
    }

    public void meldunek() {
        long days = LocalDate.now().toEpochDay() - this.getDataProdukcji().toEpochDay();
        System.out.println("Żyję " + days + " dni, mogę wykonać jeszcze " + (this.limit - this.ileZadan) + " zadań.");
    }

    public void powitanie() {
        System.out.println(this.getNazwa() + " o numerze fabrycznym " + this.getNrFabryczny() + " mówi witaj");
    }

    public String toString() {
        return "RobotSkladanie {\n" +
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
