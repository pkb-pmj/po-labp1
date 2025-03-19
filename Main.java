class Main {
    public static void main(String[] args) {
        String[] nazwy = { "Adam1000", "Roman2", "Aleks900", "Zosia Samosia", "Ala2", "Robert01", "Ula" };

        Robot[] roboty = {
                new RobotDomowy(nazwy[0]),
                new RobotDomowy(nazwy[1]),
                new RobotProdukcja(nazwy[2], Zadanie.losujZadanie()),
                new RobotProdukcja(nazwy[3], Zadanie.losujZadanie()),
                new RobotSkladanie(nazwy[4], Zadanie.losujZadanie()),
                new RobotSkladanie(nazwy[5], Zadanie.losujZadanie()),
        };

        for (Robot robot : roboty) {
            System.out.println(robot);
            robot.meldunek();
            if (robot instanceof RobotSkladanie) {
                ((RobotSkladanie) robot).powitanie();
            } else if (robot instanceof RobotDomowy) {
                ((RobotDomowy) robot).powitanie();
            }
            System.out.println();
        }

        for (Robot robot : roboty) {
            robot.zadanieWykonaj();
            robot.meldunek();
            System.out.println();
        }

        for (Robot robot : roboty) {
            System.out.println(robot);
            robot.meldunek();
            if (robot instanceof RobotSkladanie) {
                ((RobotSkladanie) robot).powitanie();
            } else if (robot instanceof RobotDomowy) {
                ((RobotDomowy) robot).powitanie();
            }
            System.out.println();
        }

        int takieSame = 0;
        for (Robot r1 : roboty) {
            for (Robot r2 : roboty) {
                if (r1 == r2)
                    continue;
                if (r1.equals(r2)) {
                    takieSame++;
                    System.out.println(r1.getNazwa() + " i " + r2.getNazwa() + " są takie same");
                }
            }
        }
        if (takieSame > 0) {
            System.out.println("Są identyczne roboty");
        } else {
            System.out.println("Brak identycznych robotów");
        }
    }
}