public class StringBilder {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder();
        int count = 100;
        s.append("Some text");
        for (int i = 0; i < count; i++) {
            s.append(i);
            System.out.println(s);
        }
//        String s = "Some text";
//        int count = 100;
//        String r;
//        for(int i = 0; i<100;i++){
//            s +=i;
//            System.out.println(s);
//        }
    }
}
