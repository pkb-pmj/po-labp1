import java.time.LocalDate;
import java.util.Random;

/**
 * Klasa Robot implementująca interfejs Porozumienie.
 */
// `abstract` - nie można utworzyć żadnych obiektów klasy Robot – służy tylko do
// stworzenia hierarchii robotów
public abstract class Robot implements Porozumienie {
    /** dataProdukcji – losowa wartość z przedziału lat (2000 - 2021) */
    private LocalDate dataProdukcji;

    public LocalDate getDataProdukcji() {
        return dataProdukcji;
    }

    /**
     * nazwa (łańcuch - jedno z dostępnych imion dla robotów), Dostępne imiona to:
     * Adam1000, Roman2, Aleks900, Zosia Samosia, Ala2, Robert01, Ula
     */
    private String nazwa;

    public String getNazwa() {
        return nazwa;
    }

    /**
     * identyfikator (losowo wygenerowany łańcuch 5 znaków, niezmienny podczas
     * istnienia obiektu – wykorzystaj metodę do generowania łańcucha)
     */
    private String identyfikator;

    public String getIdentyfikator() {
        return identyfikator;
    }

    /**
     * ileZadan (licznik informujący o tym, ile dany robot wykonał zadań od początku
     * bieżącego cyklu, zmienna w momencie powstania nowego robota jest równa 0).
     */
    // `protected` żeby dało się użyć licznika np. w klasie `RobotSkladanie` do
    // wykonania zadania z limitem
    protected int ileZadan = 0;

    public int getIleZadan() {
        return ileZadan;
    }

    /** SztucznaInteligencja si (obiekt SztucznaInteligencja) */
    private SztucznaInteligencja si = new SztucznaInteligencja();

    public SztucznaInteligencja getSi() {
        return si;
    }

    /**
     * nrFabryczny – numer nadawany podczas tworzenia obiektu, niezmienny podczas
     * istnienia obiektu (wykorzystaj pole statyczne oraz pole finalne)
     */
    // a więc wykorzystujemy pole finalne żeby nie dało się zmienić numeru
    // fabrycznego w żaden sposób po stworzeniu obiektu
    private final int nrFabryczny;

    public int getNrFabryczny() {
        return nrFabryczny;
    }

    // oraz pole statyczne żeby przechowywać globalnie ostatni numer i żeby każdy
    // stworzony robot miał kolejny numer o 1 większy.
    private static int licznikNrFabryczny = 0;

    protected Robot(String nazwa) {
        this.nazwa = nazwa;

        // bierzemy początek roku 2000 i koniec roku 2021
        // i zamieniamy na *dni od 01.01.1970* (od początku "epoki Unixa")
        long start = LocalDate.of(2000, 1, 1).toEpochDay();
        long end = LocalDate.of(2021, 12, 31).toEpochDay();
        // generujemy losową liczbę całkowitą, bierzemy wartość bezwzględną i
        // "przenosimy" ją pomiędzy te dni
        long day = Math.abs(new Random().nextLong()) % (end - start) + start;
        // i tworzymy datę z dnia "epoki"
        this.dataProdukcji = LocalDate.ofEpochDay(day);

        this.identyfikator = generateRandomString(5);

        // i tutaj zwiększamy licznik numerów fabrycznych o 1
        licznikNrFabryczny++;
        // i dajemy robotowi aktualny numer
        this.nrFabryczny = licznikNrFabryczny;
    }

    private String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String s = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            s += characters.charAt(random.nextInt(characters.length()));
        }
        return s;
    }

    public abstract String toString();

    /**
     * zadanieWykonaj – metoda Robotów symulująca działanie robota, polega na
     * zwiększeniu licznika ileZadan o losową liczbę z przedziału [1,20], w
     * przypadku robotów z limitem - po przekroczeniu limitu metoda wypisuje na
     * konsolę komunikat ostrzegający i nie zwiększa licznika ileZadan ponad wartość
     * limit.
     */
    public void zadanieWykonaj() {
        // losowa liczba z przedziału [1, 20] (czyli [0, 20) + 1)
        int amount = new Random().nextInt(20) + 1;
        this.ileZadan += amount;
    }

    // metoda `meldunek` potrzebuje tylko nazwy daty produkcji, więc można ją
    // zaimplementować na klasie `Robot`, żeby nie trzeba było implementować jej w
    // każdej klasie dziedziczącej po `Robot`
    public void meldunek() {
        // tu znowu zamiana na *dni od początku "epoki"*
        long days = LocalDate.now().toEpochDay() - this.getDataProdukcji().toEpochDay();
        System.out.println("Żyję " + days + " dni.");
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (!(o instanceof Robot))
            return false;
        // UWAGA: dla klas dziedziczących po `Robot` nie zostanie sprawdzone, czy to ta
        // sama klasa, ani czy dodatkowe pola (`limit`, `zadanie`) są równe.
        // Efekt uboczny: jest możliwa sytuacja, że np. robot.equals(robotSkladanie) ==
        // true, a robotSkladanie.equals(robot) == false. Bardzo możliwe że tego nie
        // chcemy, wtedy należy co najmniej sprawdzić, czy obiekty są tej samej klasy:
        // if (this.getClass() != other.getClass()) return false;

        Robot other = (Robot) o;

        return this.dataProdukcji.equals(other.dataProdukcji) && this.nazwa.equals(other.nazwa)
                && this.identyfikator.equals(other.identyfikator) && this.ileZadan == other.ileZadan
                && this.si.equals(other.si);
        // Porównywanie nrFabryczny trochę nie ma sensu, bo każdy robot ma inny numer,
        // więc jest to w zasadzie równoważne z `this == other`.
        // Identyfikator też zazwyczaj będzie inny, bo jest losowy, ale no można go
        // sprawdzić. Ale można też nie sprawdzać.

        // no chyba że właśnie tego chcemy, żeby `equals` zwracało `true` tylko kiedy
        // porównujemy robota samego ze sobą ...ale to chyba mało interesujące
    }
}
