public class RobotDomowy extends Robot implements PorozumieniePlus {

    protected RobotDomowy(String nazwa) {
        super(nazwa);
    }

    public void powitanie() {
        System.out.println(this.getNazwa() + " o numerze fabrycznym " + this.getNrFabryczny() + " mówi witaj");
    }

}
