import java.time.LocalDate;

public class RobotFabryczny extends Robot {

    public RobotFabryczny(String nazwa) {
        super(nazwa);
    }

    public void meldunek() {
        long days = LocalDate.now().toEpochDay() - this.getDataProdukcji().toEpochDay();
        System.out.println("żyję " + days + " dni");
    }

}
