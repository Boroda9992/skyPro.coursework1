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
        findEmployeesWithSalaryLowerThan(99000);

        System.out.println("----Сотрудники с окладом больше или равно заданному числу----");
        findEmployeesWithSalaryHigherThan(66000);

        System.out.println("----Сотрудники по выбранному отделу с окладом больше заданного числа----");
        findEmployeesWithSalaryHigherThanByDepartment(66000, 2);

        System.out.println("----Сотрудники по выбранному отделу с окладом меньше заданного числа----");
        findEmployeesWithSalaryLowerThanByDepartment(150000, 2);

    }

    /**
     * Метод печатает данные всех сотрудников.
     */
    public static void printEmployees() {
        for (Employee employee : EMPLOYEES) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    /**
     * Метод печатает данные всех сотрудников из выбранного отдела.
     *
     * @param department - (int) целое число от 1 до 5.
     */
    public static void printEmployeesByDepartment(int department) {
        for (Employee employee : EMPLOYEES) {
            if (employee != null && department == employee.getDepartment()) {
                System.out.println("ID: " + employee.getId());
                System.out.println("ФИО: " + employee.getFullName());
                System.out.println("Оклад: " + employee.getSalary());
            }
        }
    }

    /**
     * Метод печатает ФИО всех сотрудников.
     */
    public static void printEmployeesNames() {
        for (Employee employee : EMPLOYEES) {
            if (employee != null) {
                System.out.println(employee.getFullName());
            }
        }
    }

    /**
     * Метод печатает ФИО всех сотрудников из выбранного отдела.
     *
     * @param department - (int) целое число от 1 до 5.
     */
    public static void printEmployeesNamesByDepartment(int department) {
        for (Employee employee : EMPLOYEES) {
            if (employee != null && department == employee.getDepartment()) {
                System.out.println(employee.getFullName());
            }
        }
    }

    /**
     * Метод считает сумму окладов для всех сотрудников.
     *
     * @return - (int) sum - сумма окладов в виде целого числа.
     */
    private static int calculateSumOfSalaries() {
        int sum = 0;
        for (Employee employee : EMPLOYEES) {
            if (employee != null) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    /**
     * Метод считает сумму окладов для всех сотрудников из выбранного отдела.
     *
     * @param department - (int) целое число от 1 до 5.
     * @return - (int) sum - сумма окладов в виде целого числа.
     */
    private static int calculateSumOfSalariesByDepartment(int department) {
        int sum = 0;
        for (Employee employee : EMPLOYEES) {
            if (employee != null && department == employee.getDepartment()) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    /**
     * Метод считает средний оклад для всех сотрудников.
     *
     * @return - (double) sum/count если число сотрудников count не равно нулю. В противном случае, если в базе нет сотрудников, возвращает ноль.
     */
    private static double calculateAverageSalary() {
        int count = 0;
        double sum = 0;
        for (Employee employee : EMPLOYEES) {
            if (employee != null) {
                count++;
                sum += employee.getSalary();
            }
        }
        if (count != 0) {
            return sum / count;
        } else {
            return 0;
        }

    }

    /**
     * Метод считает средний оклад для всех сотрудников из выбранного отдела.
     *
     * @param department - (int) целое число от 1 до 5.
     * @return - (double) sum/count если число сотрудников count не равно нулю. В противном случае, если в базе нет сотрудников, возвращает ноль.
     */
    private static double calculateAverageSalaryByDepartment(int department) {
        int count = 0;
        double sum = 0;
        for (Employee employee : EMPLOYEES) {
            if (employee != null && department == employee.getDepartment()) {
                count++;
                sum += employee.getSalary();
            }
        }
        if (count != 0) {
            return sum / count;
        } else {
            return 0;
        }
    }

    /**
     * Метод находит сотрудника с максимальным окладом.
     *
     * @return - (Employee) возвращает объект сотрудника с максимальным окладом, или null, если сотрудников в базе нет.
     */
    private static Employee findEmployeeWithMaxSalary() {
        Employee employeeWithMaxSalary = null;
        double maxSalary = Integer.MIN_VALUE;
        for (Employee employee : EMPLOYEES) {
            if (employee != null && maxSalary < employee.getSalary()) {
                maxSalary = employee.getSalary();
                employeeWithMaxSalary = employee;
            }
        }
        return employeeWithMaxSalary;
    }

    /**
     * Метод находит сотрудника с максимальным окладом из выбранного отдела.
     *
     * @param department - (int) целое число от 1 до 5.
     * @return - (Employee) возвращает объект сотрудника с максимальным окладом из выбранного отдела. Вернет null, если отдел пуст.
     */
    private static Employee findEmployeeWithMaxSalaryByDepartment(int department) {
        Employee employeeWithMaxSalary = null;
        double maxSalary = Integer.MIN_VALUE;
        for (Employee employee : EMPLOYEES) {
            if (employee != null && maxSalary < employee.getSalary() && department == employee.getDepartment()) {
                maxSalary = employee.getSalary();
                employeeWithMaxSalary = employee;
            }
        }
        return employeeWithMaxSalary;
    }

    /**
     * Метод находит сотрудника с минимальным окладом.
     *
     * @return - (Employee) возвращает объект сотрудника с минимальным окладом, или null, если сотрудников в базе нет.
     */
    private static Employee findEmployeeWithMinSalary() {
        Employee employeeWithMinSalary = null;
        double minSalary = Integer.MAX_VALUE;
        for (Employee employee : EMPLOYEES) {
            if (employee != null && minSalary > employee.getSalary()) {
                minSalary = employee.getSalary();
                employeeWithMinSalary = employee;
            }
        }
        return employeeWithMinSalary;
    }

    /**
     * Метод находит сотрудника с минимальным окладом из выбранного отдела.
     *
     * @param department - (int) целое число от 1 до 5.
     * @return - (Employee) возвращает объект сотрудника с минимальным окладом из выбранного отдела. Вернет null, если отдел пуст.
     */
    private static Employee findEmployeeWithMinSalaryByDepartment(int department) {
        Employee employeeWithMinSalary = null;
        double minSalary = Integer.MAX_VALUE;
        for (Employee employee : EMPLOYEES) {
            if (employee != null && minSalary > employee.getSalary() && department == employee.getDepartment()) {
                minSalary = employee.getSalary();
                employeeWithMinSalary = employee;
            }
        }
        return employeeWithMinSalary;
    }

    /**
     * Метод увеличивает оклад всех сотрудников на заданный процент.
     *
     * @param bonus - (int) процент, на который будут повышены оклады всех сотрудников.
     */
    private static void raiseAllSalaryByPercent(int bonus) {
        double index = (double) 1 + ((double) bonus / 100);
        System.out.println(index);
        for (Employee employee : EMPLOYEES) {
            if (employee != null) {
                System.out.println("ID: " + employee.getId() + " | Old salary: " + employee.getSalary());
                employee.setSalary((int) (employee.getSalary() * index));
                System.out.println("ID: " + employee.getId() + " | New salary: " + employee.getSalary());
            }
        }
    }

    /**
     * Метод увеличивает оклад всех сотрудников, из выбранного отдела, на заданный процент.
     *
     * @param bonus      - (int) процент, на который будут повышены оклады всех сотрудников.
     * @param department - (int) целое число от 1 до 5.
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

    /**
     * Метод находит сотрудников с окладом ниже заданного числа.
     *
     * @param number - (int) целое число, с которым будут сравниваться оклады всех сотрудников.
     */
    private static void findEmployeesWithSalaryLowerThan(int number) {
        for (Employee employee : EMPLOYEES) {
            if (employee != null && number > employee.getSalary()) {
                System.out.println(employee);
            }
        }
    }

    /**
     * Метод находит сотрудников с окладом выше заданного числа.
     *
     * @param number - (int) целое число, с которым будут сравниваться оклады всех сотрудников.
     */
    private static void findEmployeesWithSalaryHigherThan(int number) {
        for (Employee employee : EMPLOYEES) {
            if (employee != null && number <= employee.getSalary()) {
                System.out.println(employee);
            }
        }
    }

    /**
     * Метод находит сотрудников, из выбранного отдела, с окладом ниже заданного числа.
     * @param number - (int) целое число, с которым будут сравниваться оклады всех сотрудников.
     * @param department - (int) целое число от 1 до 5.
     */
    private static void findEmployeesWithSalaryLowerThanByDepartment(int number, int department) {
        for (Employee employee : EMPLOYEES) {
            if (employee != null && department == employee.getDepartment() && number > employee.getSalary()) {
                System.out.println(employee);
            }
        }
    }

    /**
     * Метод находит сотрудников, из выбранного отдела, с окладом выше заданного числа.
     * @param number - (int) целое число, с которым будут сравниваться оклады всех сотрудников.
     * @param department - (int) целое число от 1 до 5.
     */
    private static void findEmployeesWithSalaryHigherThanByDepartment(int number, int department) {
        for (Employee employee : EMPLOYEES) {
            if (employee != null && department == employee.getDepartment() && number < employee.getSalary()) {
                System.out.println(employee);
            }
        }
    }


    private static void addEmployee(Employee newEmployee) {
        boolean added = false;
        for (int i = 0; i < EMPLOYEES.length; i++) {
            if (EMPLOYEES[i] == null) {
                EMPLOYEES[i] = newEmployee;
                added = true;
                break;
            }
        }
        if (!added) {
            System.out.println("Сотрудник не добавлен! Возможно, массив полон.");
        }
    }

}