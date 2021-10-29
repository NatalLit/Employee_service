public class Manager extends Employee{
    public Manager() {
    }

    public Manager(int id, String name, int age, int salary, String gender) {
        super(id, name, age, salary, gender);
    }

    public double calculateSalary (){
        return this.salary;
    }

}
