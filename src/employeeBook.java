import java.util.Random;

public class employeeBook {

    private Employee[] employees;

    public employeeBook(int n) {
        this.employees = new Employee[n];
    }


//    private static Random random = new Random();
//    private static String[] firstName = {"Алексей", "Александр", "Артём", "Андрей", "Борис", "Владимир", "Виктор", "Георгий", "Дмитрий", "Евгений"};
//    private static String[] patronymicName = {"Алексеевич", "Александрович", "Артёмович", "Андреевич", "Борисович", "Владимирович", "Викторович", "Георгиевич", "Дмитриевич", "Евгениевич"};
//    private static String[] surName = {"Алексеев", "Александров", "Артёмов", "Андреев", "Борисов", "Владимиров", "Викторов", "Георгиев", "Дмитриев", "Евгениев"};
//
//    private static Employee generateEmployee() {
//        return new Employee(
//                surName[random.nextInt(surName.length)] + " " +
//                        firstName[random.nextInt(firstName.length)] + " " +
//                        patronymicName[random.nextInt(patronymicName.length)],
//                random.nextInt(50000, 100000),
//                random.nextInt(1, 6)
//        );
//    }

}
