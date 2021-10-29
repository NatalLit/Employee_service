import java.util.Random;

public class Developer extends  Employee {
    int fixedBugs;

    public Developer() {
    }

    public Developer(int id, String name, int age, int salary, String gender, int fixedBugs) {
        super(id, name, age, salary, gender);
    }

    public void setFixedBugs(int fixedBugs) {
        this.fixedBugs = fixedBugs;
    }

    public double calculateSalary (double coefficient){
    Random random = new Random();
    boolean randomBoolean = random.nextBoolean();
    double salaryWithBonus = (this.salary+(double) fixedBugs * coefficient)*(randomBoolean?2:0);

    return salaryWithBonus;

}


}
