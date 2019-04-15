public class Madifikator_dostupa {

    interface V {
        int getV();
    }

    interface G {
        int getV();
    }


    static class Cat  {
        public int getV(){
            return 10;
        }
        public int getProba(){
            return 777;
        }
    }
    static class Doc extends Cat implements V, G {


        @Override
        public int getV() {
            return super.getV();
        }

        public int getRrr(){
            return 333;
        }
    }

    public static void main(String[] args) {
        Cat k = new Cat();
        System.out.println(k.getV());
        Doc d = new Doc();
        System.out.println(d.getV());
        Cat r = new Doc();
        System.out.println(r.getV());
        System.out.println(((Doc)r).getRrr());
        System.out.println(r.getProba());
        System.out.println(d.getProba());
        System.out.println(d.getV());

    }
}
