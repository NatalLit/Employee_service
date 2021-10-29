import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Comparator;

public class EmployeeService implements Comparable<Employee> {
    public Employee[] generatedEmployees;

    public EmployeeService() {
    }

    public void setGeneratedEmployees(Employee[] generatedEmployees) {
        this.generatedEmployees = generatedEmployees;
    }


    public void printEmployees() {
        for (Employee employee : generatedEmployees) {
            System.out.println(" {" +
                    "id=" + employee.id +
                    ", name='" + employee.name + '\'' +
                    ", age=" + employee.age +
                    ", salary=" + employee.salary +
                    ", gender='" + employee.gender + '\'' +
                    '}');
        }
    }


    public double calculateSalaryAndBonus() {
        double calculate = 0.0;
        for (Employee employee : generatedEmployees) {
            calculate += employee.salary;
        }
        return calculate;
    }


    public Employee getById(int id) {
        for (Employee employee : generatedEmployees) {
            if (employee.id == id) {
                return employee;
            }
        }
        return null;
    }


    public Employee[] getByName(String name) {
        Employee[] tempArray = new Employee[generatedEmployees.length];
        int count = 0;
        for (int i = 0; i < generatedEmployees.length; i++) {

            if (generatedEmployees[i].name.contains(name)) {
                tempArray[count] = generatedEmployees[i];
                count++;
            }
        }

        return Arrays.copyOfRange(tempArray, 0, count);
    }



    public Employee[] sortByName() {

        Comparator<Employee> employeeNameComparator = Comparator.comparing(Employee::getName);
        Arrays.sort(generatedEmployees, employeeNameComparator);

        return generatedEmployees;
    }


    @Override
    public int compareTo(Employee o) {
        return 0;
    }

    public static Comparator<Employee> NameandSalaryComparator = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            int flag = o1.getName().compareTo(o2.getName());

            if (flag == 0) flag = (int) (o2.getSalary() - o1.getSalary());
            ;
            return flag;
        }
    };

    public void sortByNameAndSalary() {
        Arrays.sort(generatedEmployees, NameandSalaryComparator);
       System.out.println(" Сортировка по имени и зарплате:\n" + Arrays.toString(generatedEmployees));
    }


    public int findEmployeIndex(int id) {
        for (int i = 0; i < generatedEmployees.length; i++) {
            if (generatedEmployees[i].id == id) {
                return i;
            }
        }
        return -1;
    }


    public Employee edit(Employee employee) {

        int index = findEmployeIndex(employee.id);
        if (index == -1) {
            return null;
        } else {
            Employee oldInfo = generatedEmployees[index];
            generatedEmployees[index] = employee;
            return oldInfo;
        }
    }


    public Employee remove(int id) {
        int index = findEmployeIndex(id);
        Employee deletedEmplyee = null;
        Employee[] newEmployeeArray = new Employee[generatedEmployees.length - 1];

        if (index == -1) {
            return null;
        } else {
            int newArrayCounter = 0;
            for (int i = 0; i < generatedEmployees.length; i++) {
                if (i == index) {
                    deletedEmplyee = generatedEmployees[i];
                } else {
                    newEmployeeArray[newArrayCounter] = generatedEmployees[i];
                    newArrayCounter++;
                }
            }
        }
        generatedEmployees = newEmployeeArray;
        return deletedEmplyee;
            }


    void add(Employee employee){
        int index = findEmployeIndex(employee.id);
        if(index>=0){
            System.out.println("Пользователь с таким id существует");
        }else {
            Employee[] newEmployeeArray = new Employee[generatedEmployees.length + 1];
            newEmployeeArray = Arrays.copyOf(generatedEmployees, generatedEmployees.length + 1);
            newEmployeeArray[newEmployeeArray.length - 1] = employee;
            generatedEmployees = newEmployeeArray;
        }
    }

}


