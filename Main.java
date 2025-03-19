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
            robot.meldunek();
        }

        for (Robot robot : roboty) {
            if (robot instanceof RobotSkladanie) {
                ((RobotSkladanie) robot).powitanie();
            }
        }
    }
}