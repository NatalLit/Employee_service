import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        EmployeeFactory testEmployeeFactory = new EmployeeFactory();
        Employee[] testGeneratedEmployees = testEmployeeFactory.generateEmployees(5);
        EmployeeService testEmployService = new EmployeeService();
        Employee testEmployee = new Employee(2, "Andrey", 32, 10_000, "male");


//тестируем метод void printEmployees() -> вывод на экран информации о сотрудниках
        testEmployService.setGeneratedEmployees(testGeneratedEmployees);
        testEmployService.printEmployees();


//тестируем метод double calculateSalaryAndBonus() -> возвращает количество денег
// необходимое для выплаты зарплат для всех сотрудников в этом месяце
        System.out.println(testEmployService.calculateSalaryAndBonus());


//тестируем метод getById -> возвращает сотрудника по заданному id
        System.out.println(testEmployee = testEmployService.getById(testEmployee.id));


//тестируем метод Employee[] getByName(String) -> возвращает сотрудника по заданному имени
        System.out.println(Arrays.toString(testEmployService.getByName("Andrey")));


//тестируем метод Employee[] sortByName()
        System.out.println(Arrays.toString(testEmployService.sortByName()));


//тестируем метод Employee[]sortByNameAndSalary()
       testEmployService.sortByNameAndSalary();


//тестируем метод Employee edit(Employee) -> находит сотрудника по id,
// и подменяет информацию о нем на новую. Старую версию сотрудника метод возвращает.
        System.out.println(testEmployService.edit(testEmployee));


//тестируем метод Employee remove(long id) -> находит сотрудника по id, и удаляет его из массива.
// Возвращает ссылку на удаленного сотрудника. Массив сокращается на 1.
        System.out.println(testEmployService.remove(1));


//тестируем метод void add(Employee) -> Добавляет нового сотрудника. Массив увеличивается на 1.
       testEmployService.add(testEmployee);
       testEmployService.printEmployees();

    }
}
