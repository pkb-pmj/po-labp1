class Main {
    public static void main(String[] args) {
        String[] nazwy = { "Adam1000", "Roman2", "Aleks900", "Zosia Samosia", "Ala2", "Robert01", "Ula" };

        Robot[] roboty = {
                new RobotFabryczny(nazwy[0])
        };

        for (Robot robot : roboty) {
            robot.meldunek();
        }
    }
}