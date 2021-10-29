import java.util.Arrays;
import java.util.Random;

public class EmployeeFactory {

    public EmployeeFactory() {
    }

    String[] MaleNames = {"Andrey", "Sergey", "Victor"};
    String[] FemaleNames = {"Svetlana", "Natalia", "Victoria"};
    String[] gender = {"male", "female"};
    int idCount = 1;

    Developer[] getRandomDevelopers(int size) {

        Random random = new Random();
        Developer[] randomDevelopers = new Developer[size];
        for (int i = 0; i < size; i++) {
            Developer developer = new Developer();
            developer.id = idCount;
            idCount++;
            developer.age = random.nextInt(44) + 18;
            developer.salary = developer.calculateSalary(random.nextDouble() * 1);
            developer.fixedBugs = random.nextInt(30);
            developer.gender = gender[random.nextInt(gender.length)];

            if (developer.gender.equals(gender[0])) {
                developer.name = MaleNames[random.nextInt(MaleNames.length)];

            } else {
                developer.name = FemaleNames[random.nextInt(FemaleNames.length)];
            }
            randomDevelopers[i] = developer;

        }

        return randomDevelopers;
    }


    Manager[] getRandomManagers(int size) {

        Random random = new Random();
        Manager[] randomManagers = new Manager[size];
        for (int i = 0; i < size; i++) {
            Manager manager = new Manager();
            manager.id = idCount;
            idCount++;
            manager.age = random.nextInt(44) + 18;
            manager.salary = manager.calculateSalary();
            manager.gender = gender[random.nextInt(gender.length)];
            if (manager.gender.equals(gender[0])) {
                manager.name = MaleNames[random.nextInt(MaleNames.length)];
            } else {
                manager.name = FemaleNames[random.nextInt(FemaleNames.length)];

            }
            randomManagers[i] = manager;
        }
        return randomManagers;
    }

    Designer[] getRandomDesigners(int size) {

        Random random = new Random();
        Designer[] randomDesigners = new Designer[size];
        for (int i = 0; i < size; i++) {
            Designer designer = new Designer();
            designer.id = idCount;
            idCount++;
            designer.age = random.nextInt(44) + 18;
            designer.salary = designer.calculateSalary();
            designer.workedDays = random.nextInt(30);
            designer.rate = random.nextDouble() * 10;
            designer.gender = gender[random.nextInt(gender.length)];
            if (designer.gender.equals(gender[0])) {
                designer.name = MaleNames[random.nextInt(MaleNames.length)];
            } else {
                designer.name = FemaleNames[random.nextInt(FemaleNames.length)];
            }
            randomDesigners[i] = designer;
        }
        return randomDesigners;
    }


    public Employee[] generateEmployees(int size) {

        Random random = new Random();

        int developerCount = random.nextInt(size);
        int managerCount = random.nextInt(size - developerCount);
        int designerCount = size - developerCount - managerCount;
        // System.out.println(developerCount +" " +managerCount+" " +designerCount);
        Developer[] developers = getRandomDevelopers(developerCount);
        Manager[] managers = getRandomManagers(managerCount);
        Designer[] designers = getRandomDesigners(designerCount);

        Employee[] generatedEmployees = new Employee[size];
        int index = 0;

        for (Developer developer : developers) {
            //  System.out.println(developer.name);
            generatedEmployees[index] = developer;
            //System.out.println(generateEmployees[index]);
            index++;

        }
        for (Manager manager : managers) {
            generatedEmployees[index] = manager;
            index++;
        }

        for (Designer designer : designers) {
            generatedEmployees[index] = designer;
            index++;
        }

        return generatedEmployees;
    }
}

