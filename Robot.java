import java.time.LocalDate;
import java.util.Random;

/**
 * Klasa Robot implementująca interfejs Porozumienie.
 * `abstract` - nie można utworzyć żadnych obiektów klasy Robot – służy tylko do
 * stworzenia hierarchii robotów
 */
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
    private int ileZadan = 0;

    public int getIleZadan() {
        return ileZadan;
    }

    /** SztucznaInteligencja si (obiekt SztucznaInteligencja) */
    private SztucznaInteligencja si;
    /**
     * nrFabryczny – numer nadawany podczas tworzenia obiektu, niezmienny podczas
     * istnienia obiektu (wykorzystaj pole statyczne oraz pole finalne)
     */
    private final int nrFabryczny;

    public int getNrFabryczny() {
        return nrFabryczny;
    }

    private static int licznikNrFabryczny = 0;

    protected Robot(String nazwa) {
        this.nazwa = nazwa;

        long start = LocalDate.of(2000, 1, 1).toEpochDay();
        long end = LocalDate.of(2021, 12, 31).toEpochDay();
        long day = new Random().nextLong() % (end - start) + start;
        this.dataProdukcji = LocalDate.ofEpochDay(day);

        this.identyfikator = generateRandomString(5);

        this.nrFabryczny = licznikNrFabryczny;
        licznikNrFabryczny++;
    }

    private String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String s = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            s += characters.charAt(random.nextInt(characters.length()));
        }
        return s;
    }
}
