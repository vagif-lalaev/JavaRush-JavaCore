public class ProverkaNaNechotnost {
    public static void main(String[] args) {
        System.out.println(oddOrNot(4));
    }

    public static boolean oddOrNot(int num) {
        return (num & 1) != 0;
    }
}
