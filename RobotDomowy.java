public class RobotDomowy extends Robot implements PorozumieniePlus {

    protected RobotDomowy(String nazwa) {
        super(nazwa);
    }

    public void powitanie() {
        System.out.println(this.getNazwa() + " o numerze fabrycznym " + this.getNrFabryczny() + " mówi witaj");
    }

    public String toString() {
        return "RobotDomowy {\n" +
                "    dataProdukcji: " + this.getDataProdukcji() + ",\n" +
                "    nazwa: " + this.getNazwa() + ",\n" +
                "    identyfikator: " + this.getIdentyfikator() + ",\n" +
                "    ileZadan: " + this.getIleZadan() + ",\n" +
                "    si: " + this.getSi() + ",\n" +
                "    nrFabryczny: " + this.getNrFabryczny() + "\n" +
                "}";
    }

}
