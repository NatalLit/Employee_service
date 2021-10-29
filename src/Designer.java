public class Designer extends Employee{
    double rate;
    int workedDays;

    public Designer() {
    }

    public Designer(int id, String name, int age, int salary, String gender, double rate, int workedDays) {
        super(id, name, age, salary, gender);
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setWorkedDays(int workedDays) {
        this.workedDays = workedDays;
    }

        public double calculateSalary (){
        double salaryWithBonus = salary + rate * workedDays;
    return salaryWithBonus;
    }

}
