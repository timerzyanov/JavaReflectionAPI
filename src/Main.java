import transport.Car;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {

    private static final String SPACE = "     ";

    public static void main(String[] args) {

        String info = "Рефлексия — это механизм исследования данных о программе во время её выполнения.\n" +
                "Рефлексия позволяет исследовать информацию о полях, методах и конструкторах классов.\n\n";
        System.out.println(info);

        //Примеры получения Класс класса
        printClassExamples();

        //Примеры получения информации переменных класса
        printFieldsExamples();

        //Примеры получения информации о методах класса
        printMethodExamples();
    }


    /**
     * Примеры получения Класс класса
     */
    private static void printClassExamples() {
        System.out.println("Примеры получения Класс класса:");

        try {
            Class<?> carClass1 = Class.forName("transport.Car");
            System.out.println("1 способ методом Class.forName(\"имя.пакета.ИмяКласса\"):");
            System.out.println(SPACE + carClass1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Car car = new Car();
        Class<? extends Car> carClass2 = car.getClass();
        System.out.println("2 способ методом getClass() у экземпляра класса:");
        System.out.println(SPACE + carClass2);

        Class<Car> carClass3 = Car.class;
        System.out.println("3 способ ИмяКласса.class:");
        System.out.println(SPACE + carClass3);
    }

    /**
     * Примеры получения информации переменных класса
     */
    private static void printFieldsExamples() {
        System.out.println("\n\nПримеры получения информации переменных класса:");

        System.out.println("1 способ методом getDeclaredFields(). Метод возвращает все объявленные переменные в классе:");
        Class<Car> carClass1 = Car.class;
        Field[] declaredFields = carClass1.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(SPACE + field);
        }

        System.out.println("2 способ методом getDeclaredField(fieldName). Метод возвращает переменную по её имени:");
        Class<Car> carClass2 = Car.class;
        try {
            Field powerField = carClass2.getDeclaredField("power");
            System.out.println(SPACE + powerField);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        System.out.println("3 способ методом getFields(). Метод возвращает только public переменные:");
        Class<Car> carClass3 = Car.class;
        Field[] fields = carClass3.getFields();
        for (Field field : fields) {
            System.out.println(SPACE + field);
        }

        System.out.println("4 способ методом getField(fieldName). Метод возвращает только public переменную по её имени:");
        Class<Car> carClass4 = Car.class;
        try {
            Field numberField = carClass4.getField("number");
            System.out.println(SPACE + numberField);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    /**
     * Примеры получения информации о методах класса
     */
    private static void printMethodExamples() {
        System.out.println("\n\nПримеры получения информации о методах класса:");

        System.out.println("1 способ методом getDeclaredMethods(). Метод возвращает все объявленные методы в классе:");
        Class<Car> carClass1 = Car.class;
        Method[] declaredMethods = carClass1.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(SPACE + method);
        }

        System.out.println("2 способ методом getDeclaredMethod(methodName). Метод возвращает метод в классе по её имени:");
        Class<Car> carClass2 = Car.class;
        try {
            Method printNumberMethod = carClass2.getDeclaredMethod("printNumber");
            System.out.println(SPACE + printNumberMethod);

            Method setPowerMethod = carClass2.getDeclaredMethod("setPower", int.class);
            System.out.println(SPACE + setPowerMethod);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        System.out.println("3 способ методом getMethods(). Метод возвращает все public методы класса и public методы его родительского класса/интерфейсов:");
        Class<Car> carClass3 = Car.class;
        Method[] methods = carClass3.getMethods();
        for (Method method : methods) {
            System.out.println(SPACE + method);
        }

        System.out.println("4 способ методом getMethod(methodName). Метод возвращает только public метод класса по её имени:");
        Class<Car> carClass4 = Car.class;
        try {
            Method notifyAllMethod = carClass4.getMethod("notifyAll");
            System.out.println(SPACE + notifyAllMethod);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}