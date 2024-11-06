package estudioArray;

public class EstudioArrayBidi {
    public EstudioArrayBidi(){
        int[][] notas;
        notas = new int[3][4];
        int masCinco = 0;

        for (int x = 0; x < notas.length; x++) {
            for (int y = 0; y < notas[x].length; y++) {
                notas[x][y] = masCinco;
                masCinco += 5;
                System.out.printf("%3d ", notas[x][y]);
            }
            System.out.println("");
        }

        int notas2[][] = new int[4][10];
        int notas3[][] = {
                            {1,2,3,4,5},
                            {5,4,3,2,1},
                            {12,13,14,15,16}
                        };

        for (int x = 0; x < notas3.length; x++) {
            for (int y = 0; y < notas3[x].length; y++) {
                System.out.printf("%3d ", notas3[x][y]);
            }
            System.out.println("");
        }

        int[][] ke = new int[7][];
        int par = 0;
        System.out.println("------------------------------------------------------------");
        for (int x = ke.length -1; x > 0; x--) {
            ke[x] = new int[x+1];
            par += 2;
            for (int y = 0; y < ke[x].length; y++) {
                ke[x][y] = par;
                System.out.printf("%4d ", ke[x][y]);
            }
            System.out.println();
        }

    }
}
