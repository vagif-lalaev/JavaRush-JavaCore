public class Parking {
    //парковка машин
    public static void main(String[] args) {
        boolean park [][][] = new boolean[2][3][4];
        park [0][0][1] = true;
        park [0][2][1] = true;
        park [1][0][3] = true;
        park [1][2][0] = true;
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[0].length; j++) {
                for (int k = 0; k < park[0][0].length; k++) {
                    System.out.println("array[" + i + "][" + j + "[]" + k + "] = " + park[i][j][k]);
                }
                System.out.println();
            }
        }
    }
}
