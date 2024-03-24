import java.util.Random;
//
//public class EmployeeBook {
//    private final Employee[] EMPLOYEES = new Employee[10];
//    private final Random RANDOM = new Random();
//    private final String[] FIRST_NAME = {"Алексей", "Александр", "Артём", "Андрей", "Борис", "Владимир", "Виктор", "Георгий", "Дмитрий", "Евгений"};
//    private final String[] PATRONYMIC_NAME = {"Алексеевич", "Александрович", "Артёмович", "Андреевич", "Борисович", "Владимирович", "Викторович", "Георгиевич", "Дмитриевич", "Евгениевич"};
//    private final String[] SUR_NAME = {"Алексеев", "Александров", "Артёмов", "Андреев", "Борисов", "Владимиров", "Викторов", "Георгиев", "Дмитриев", "Евгениев"};
//
//    /**
//     * Метод создает объект Employee, заполняя поля случайными значениями в заданных диапазонах
//     *
//     * @return Employee - объект сотрудника, содержащий ФИО, оклад, номер отдела, ID
//     */
//    public Employee generateEmployee() {
//        return new Employee(
//                SUR_NAME[RANDOM.nextInt(SUR_NAME.length)] + " " +
//                        FIRST_NAME[RANDOM.nextInt(FIRST_NAME.length)] + " " +
//                        PATRONYMIC_NAME[RANDOM.nextInt(PATRONYMIC_NAME.length)],
//                RANDOM.nextInt(50000, 100000),
//                RANDOM.nextInt(1, 6)
//        );
//    }
//
//
//
//
//}
