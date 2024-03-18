import java.util.Random;

public class Main {
    private final static Employee[] EMPLOYEES = new Employee[10];
    private final static Random RANDOM = new Random();
    private final static String[] FIRST_NAME = {"Алексей", "Александр", "Артём", "Андрей", "Борис", "Владимир", "Виктор", "Георгий", "Дмитрий", "Евгений"};
    private final static String[] PATRONYMIC_NAME = {"Алексеевич", "Александрович", "Артёмович", "Андреевич", "Борисович", "Владимирович", "Викторович", "Георгиевич", "Дмитриевич", "Евгениевич"};
    private final static String[] SUR_NAME = {"Алексеев", "Александров", "Артёмов", "Андреев", "Борисов", "Владимиров", "Викторов", "Георгиев", "Дмитриев", "Евгениев"};

    /**
     * Метод создает объект Employee, заполняя поля случайными значениями в заданных диапазонах
     *
     * @return Employee
     */
    private static Employee generateEmployee() {
        return new Employee(
                SUR_NAME[RANDOM.nextInt(SUR_NAME.length)] + " " +
                        FIRST_NAME[RANDOM.nextInt(FIRST_NAME.length)] + " " +
                        PATRONYMIC_NAME[RANDOM.nextInt(PATRONYMIC_NAME.length)],
                RANDOM.nextInt(50000, 100000),
                RANDOM.nextInt(1, 6)
        );
    }

    public static void main(String[] args) {

        for (int i = 0; i < EMPLOYEES.length; i++) {
            EMPLOYEES[i] = generateEmployee();
        }

        System.out.println("----Сводная информация о сотрудниках----");
        printEmployees();

        System.out.println("----ФИО сотрудников----");
        printEmployeesNames();

        System.out.println("----Сумма окладов----");
        System.out.println(calculateSumOfSalaries());

        System.out.println("----Средний оклад----");
        System.out.println(calculateAverageSalary());

        System.out.println("----Сотрудник с максимальным окладом----");
        System.out.println(findEmployeeWithMaxSalary());

        System.out.println("----Сотрудник с минимальным окладом----");
        System.out.println(findEmployeeWithMinSalary());

        System.out.println("----Вычислить среднюю зарплату по отделу----");
        System.out.println(calculateAverageSalaryFromDepartment(findEmployeeWithMaxSalary().getDepartment()));

        System.out.println("----Добавить сотрудника----");
        addEmployee(generateEmployee());

        System.out.println("----Увеличить оклад----");
        raiseAllSalaryByPercent(10);

        System.out.println("----Увеличить оклад по отделу----");
        raiseAllSalaryByPercentByDepartment(10, 2);

        System.out.println("----Сотрудник с минимальным окладом по отделу----");
        System.out.println(findEmployeeWithMinSalaryByDepartment(2));

        System.out.println("----Сотрудник с максимальным окладом по отделу----");
        System.out.println(findEmployeeWithMaxSalaryByDepartment(2));

        System.out.println("----Сумма окладов по отделу----");
        System.out.println(calculateSumOfSalariesByDepartment(2));

        System.out.println("----Средний оклад по отделу----");
        System.out.println(calculateAverageSalaryByDepartment(2));

        System.out.println("----Список сотрудников по отделу----");
        printEmployeesByDepartment(2);

        System.out.println("----Имена сотрудников по отделу----");
        printEmployeesNamesByDepartment(2);

        System.out.println("----Сотрудники с окладом меньше чем заданное число----");
        showEmployeesWithSalaryLowerThan(99000);

        System.out.println("----Сотрудники с окладом больше или равно заданному числу----");
        showEmployeesWithSalaryHigherThan(66000);

    }

    /**
     * Метод печатает конкатенацию всех полей из всех объектов Employee
     */
    public static void printEmployees() {
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee);
        }
    }

    public static void printEmployeesByDepartment(int department) {
        System.out.println("///////// Отдел: " + department);
        for (Employee employee : EMPLOYEES) {
            if (department == employee.getDepartment()) {
                System.out.println("ID: " + employee.getId());
                System.out.println("ФИО: " + employee.getFullName());
                System.out.println("Оклад: " + employee.getSalary());
            }
        }
    }

    /**
     * Метод печатает параметр fullName из всех объектов Employee
     */
    public static void printEmployeesNames() {
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee.getFullName());
        }
    }

    public static void printEmployeesNamesByDepartment(int department) {
        System.out.println("///////// Отдел: " + department);
        for (Employee employee : EMPLOYEES) {
            if (department == employee.getDepartment()) {
                System.out.println(employee.getFullName());
            }
        }
    }

    /**
     * Метод считает сумму параметров salary для всех сотрудников.
     *
     * @return int
     */
    private static int calculateSumOfSalaries() {
        int sum = 0;
        for (Employee employee : EMPLOYEES) {
            sum += employee.getSalary();
        }
        return sum;
    }

    private static int calculateSumOfSalariesByDepartment(int department) {
        int sum = 0;
        for (Employee employee : EMPLOYEES) {
            if (department == employee.getDepartment()) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    /**
     * Метод вычисляет среднее значение всех параметров salary для всех сотрудников.
     *
     * @return double
     */
    private static double calculateAverageSalary() {
        int count = 0;
        for (Employee employee : EMPLOYEES) {
            if (employee != null) {
                count++;
            }
        }
        return (double) calculateSumOfSalaries() / count;
    }

    /**
     * Метод считает средний оклад по отделу
     *
     * @param department - целое число типа int, отражающее номер отдела.
     * @return (double) средний оклад по отделу.
     */
    private static double calculateAverageSalaryByDepartment(int department) {
        int count = 0;
        double averageByDepartment;
        for (Employee employee : EMPLOYEES) {
            if (employee != null && department == employee.getDepartment()) {
                count++;
            }
        }
        return (double) calculateSumOfSalariesByDepartment(department) / count;
    }

    /**
     * Метод находит сотрудника с максимальным окладом и возвращает объект этого сотрудника.
     * Возвращает null, если ничего не нашел (пустой массив, другой отдел и т.д.)
     *
     * @return Employee
     */
    private static Employee findEmployeeWithMaxSalary() {
        Employee employeeWithMaxSalary = null;
        double maxSalary = Integer.MIN_VALUE;
        for (Employee employee : EMPLOYEES) {
            if (maxSalary < employee.getSalary()) {
                maxSalary = employee.getSalary();
                employeeWithMaxSalary = employee;
            }
        }
        return employeeWithMaxSalary;
    }

    private static Employee findEmployeeWithMaxSalaryByDepartment(int department) {
        Employee employeeWithMaxSalary = null;
        System.out.println("///////// Отдел: " + department);
        double maxSalary = Integer.MIN_VALUE;
        for (Employee employee : EMPLOYEES) {
            if (maxSalary < employee.getSalary() && department == employee.getDepartment()) {
                maxSalary = employee.getSalary();
                employeeWithMaxSalary = employee;
            }
        }
        return employeeWithMaxSalary;
    }

    /**
     * Метод находит сотрудника с максимальным окладом и возвращает объект этого сотрудника.
     * Возвращает null, если ничего не нашел (пустой массив, другой отдел и т.д.)
     *
     * @return Employee
     */
    private static Employee findEmployeeWithMinSalary() {
        Employee employeeWithMinSalary = null;
        double minSalary = Integer.MAX_VALUE;
        for (Employee employee : EMPLOYEES) {
            if (minSalary > employee.getSalary()) {
                minSalary = employee.getSalary();
                employeeWithMinSalary = employee;
            }
        }
        return employeeWithMinSalary;
    }

    private static Employee findEmployeeWithMinSalaryByDepartment(int department) {
        Employee employeeWithMinSalary = null;
        System.out.println("///////// Отдел: " + department);
        double minSalary = Integer.MAX_VALUE;
        for (Employee employee : EMPLOYEES) {
            if (minSalary > employee.getSalary() && department == employee.getDepartment()) {
                minSalary = employee.getSalary();
                employeeWithMinSalary = employee;
            }
        }
        return employeeWithMinSalary;
    }


    private static double calculateAverageSalaryFromDepartment(int department) {
        int count = 0;
        int sum = 0;
        for (Employee employee : EMPLOYEES) {
            if (employee != null && department == employee.getDepartment()) {
                count++;
                sum += employee.getSalary();
            }
        }
        if (count != 0) {
            return (double) sum / count;
        }
        return 0;
    }

    private static void addEmployee(Employee newEmployee) {
        boolean added = false;
        for (int i = 0; i < EMPLOYEES.length; i++) {
            if (EMPLOYEES[i] == null) {
                EMPLOYEES[i] = newEmployee;
                added = true;
                break;
            }
            if (!added) {
                System.out.println("Сотрудник не добавлен! Возможно, массив полон.");
            }
        }
    }

    /**
     * Метод принимает целое число, в качестве процента, на который будет увеличен оклад всех сотрудников.
     * Для удобства, метод сам переводит int в double, позволяя просто писать целое число в параметр.
     *
     * @param bonus - целое число типа int, отражающее процент, на который будут повышены оклады всех сотрудников.
     */
    private static void raiseAllSalaryByPercent(int bonus) {
        double index = (double) 1 + ((double) bonus / 100);
        System.out.println(index);
        System.out.println("Увеличение оклада на " + bonus + " процентов.");
        for (Employee employee : EMPLOYEES) {
            if (employee != null) {
                System.out.println("ID: " + employee.getId() + " | Old salary: " + employee.getSalary());
                employee.setSalary((int) (employee.getSalary() * index));
                System.out.println("ID: " + employee.getId() + " | New salary: " + employee.getSalary());
                System.out.println("-----------------------------------");
            }
        }
    }

    /**
     * Метод принимает целое число, в качестве процента, на который будет увеличен оклад всех сотрудников, а так же номер отдела.
     *
     * @param bonus      - целое число типа int, отражающее процент, на который будут повышены оклады всех сотрудников.
     * @param department - целое число типа int, отражающее номер отдела, сотрудникам которого будет увеличен оклад.
     */
    private static void raiseAllSalaryByPercentByDepartment(int bonus, int department) {
        double index = (double) 1 + ((double) bonus / 100);
        System.out.println(index);
        System.out.println("Увеличение оклада на " + bonus + " процентов. Для " + department + " отдела.");
        for (Employee employee : EMPLOYEES) {
            if (employee != null && department == employee.getDepartment()) {
                System.out.println("ID: " + employee.getId() + " | Old salary: " + employee.getSalary());
                employee.setSalary((int) (employee.getSalary() * index));
                System.out.println("ID: " + employee.getId() + " | New salary: " + employee.getSalary());
                System.out.println("-----------------------------------");
            }
        }
    }

    private static Employee showEmployeesWithSalaryLowerThan (int number){
        for (Employee employee : EMPLOYEES){
            if (number > employee.getSalary()){
                System.out.println(employee);
            }
        }
        return null;
    }
    private static Employee showEmployeesWithSalaryHigherThan (int number){
        for (Employee employee : EMPLOYEES){
            if (number <= employee.getSalary()){
                System.out.println(employee);
            }
        }
        return null;
    }


}