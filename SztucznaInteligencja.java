import java.util.Random;

public class SztucznaInteligencja {
    private String reprezentacjaDanych;

    public String getReprezentacjaDanych() {
        return reprezentacjaDanych;
    }

    private static final String[] mozliweReprezentacjeDanych = { "binarna", "rozmyta", "przybliżona" };

    public SztucznaInteligencja() {
        this.reprezentacjaDanych = mozliweReprezentacjeDanych[new Random().nextInt(mozliweReprezentacjeDanych.length)];
    }

    public SztucznaInteligencja(String reprezentacjaDanych) {
        this.reprezentacjaDanych = reprezentacjaDanych;
    }
}
