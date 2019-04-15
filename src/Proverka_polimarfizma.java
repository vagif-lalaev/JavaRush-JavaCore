public class Proverka_polimarfizma {
     static class Animal{
         int s = 1;
         String ss = "animal tut";
        void anim(){
            System.out.println("я из анимал");
        }
        void anim2(){
            System.out.println("я снова из анимал тольлко 2");
        }
    }
     static class Cat extends Animal{
         int c = 2;
         String cc = "cat tut";
         void anim(){
             super.anim();
             System.out.println("я анимал из КЭТ");
         }
        void cat1(){
            System.out.println("я кот");
        }
        void cat2(){
            System.out.println("снова кот 2");
        }
    }
    public static void main(String[] args) throws ClassCastException {

        Animal tek = new Cat();
        Cat cek = (Cat)tek;
//        System.out.println(cek.c);
//        System.out.println(cek.s);
//        System.out.println(cek.cc);
//        ((Cat) tek).cat2();
//        tek.anim();
        cek.anim();
    }
}
