public class Employee {

    private static int idGenerator = 1;

    private int id;
    private int salary;
    private int department; // 1-5
    private String fullName;

    public Employee(String fullName, int salary, int department) {
        this.id = idGenerator++;
        this.fullName = fullName;
        this.salary = salary;
        this.department = department;

    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", оклад: " + salary +
                ", отдел: " + department +
                ", ФИО: '" + fullName;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
    public int getId() {
        return this.id;
    }

    public double getSalary() {
        return this.salary;
    }

    public int getDepartment() {
        return this.department;
    }

}
