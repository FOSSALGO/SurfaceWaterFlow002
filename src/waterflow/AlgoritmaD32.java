package waterflow;

public class AlgoritmaD32 implements Algorithm {

    private Data data = null;

    public AlgoritmaD32(Data data) {
        this.data = data;
        this.flowDirection();
    }

    @Override
    public void flowDirection() {
        if (this.data != null) {
            //array neighbous-----------------------------------------------
            Titik[] position = new Titik[33];
            position[0] = new Titik(0, 0);//D0
            position[1] = new Titik(-1, 0);//D1
            position[2] = new Titik(-1, 1);//D2
            position[3] = new Titik(0, 1);//D3
            position[4] = new Titik(1, 1);//D4
            position[5] = new Titik(1, 0);//D5
            position[6] = new Titik(1, -1);//D6
            position[7] = new Titik(0, -1);//D7
            position[8] = new Titik(-1, -1);//D8
            position[9] = new Titik(-2, 1);//D9
            position[10] = new Titik(-1, 2);//10
            position[11] = new Titik(1, 2);//11
            position[12] = new Titik(2, 1);//12
            position[13] = new Titik(2, -1);//13
            position[14] = new Titik(1, -2);//14
            position[15] = new Titik(-1, -2);//15
            position[16] = new Titik(-2, -1);//16
            position[17] = new Titik(-3, 1);//17
            position[18] = new Titik(-3, 2);//18
            position[19] = new Titik(-2, 3);//19
            position[20] = new Titik(-1, 3);//20
            position[21] = new Titik(1, 3);//21
            position[22] = new Titik(2, 3);//22
            position[23] = new Titik(3, 2);//23
            position[24] = new Titik(3, 1);//24
            position[25] = new Titik(3, -1);//25
            position[26] = new Titik(3, -2);//26
            position[27] = new Titik(2, -3);//27
            position[28] = new Titik(1, -3);//28
            position[29] = new Titik(-1, -3);//29
            position[30] = new Titik(-2, -3);//30
            position[31] = new Titik(-3, -2);//31
            position[32] = new Titik(-3, -1);//32
            //end of inisialiasi array neighbous----------------------------

            //array children------------------------------------------------
            int[][] children = new int[33][];
            children[0] = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
            children[1] = new int[]{16, 9};
            children[2] = new int[]{9, 10};
            children[3] = new int[]{10, 11};
            children[4] = new int[]{11, 12};
            children[5] = new int[]{12, 13};
            children[6] = new int[]{13, 14};
            children[7] = new int[]{14, 15};
            children[8] = new int[]{15, 16};
            children[9] = new int[]{17, 18};
            children[10] = new int[]{19, 20};
            children[11] = new int[]{21, 22};
            children[12] = new int[]{23, 24};
            children[13] = new int[]{25, 26};
            children[14] = new int[]{27, 28};
            children[15] = new int[]{29, 30};
            children[16] = new int[]{31, 32};
            //end of inisialisasi array children----------------------------

            //jalankan Algoritma
            Algorithm algorithm = new AlgorithmDX(this.data, position, children);
            this.data = algorithm.getData();
        }//end of if(this.data!=null)
    }//end of flowDirection()

    @Override
    public Data getData() {
        return this.data;
    }

}//end of class
