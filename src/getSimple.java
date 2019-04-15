public class getSimple {

    public static void main(String[] args) {
        printObjectType(new Cat());
    }

    public static void printObjectType(Object o) {
        System.out.println(o.getClass().getSimpleName());
        //Напишите тут ваше решение
    }

    public static class Cat {

    }
}
