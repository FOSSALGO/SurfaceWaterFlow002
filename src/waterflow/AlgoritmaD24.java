package waterflow;

public class AlgoritmaD24 implements Algorithm {

    private Data data = null;

    public AlgoritmaD24(Data data) {
        this.data = data;
        this.flowDirection();
    }

    @Override
    public void flowDirection() {
        if (this.data != null) {
            //array neighbous-----------------------------------------------
            Titik[] position = new Titik[25];
            position[0] = new Titik(0, 0);//D0
            position[1] = new Titik(-1, 0);//D1
            position[2] = new Titik(-1, 1);//D2
            position[3] = new Titik(0, 1);//D3
            position[4] = new Titik(1, 1);//D4
            position[5] = new Titik(1, 0);//D5
            position[6] = new Titik(1, -1);//D6
            position[7] = new Titik(0, -1);//D7
            position[8] = new Titik(-1, -1);//D8
            position[9] = new Titik(-2, 0);//D9
            position[10] = new Titik(-2, 1);//D10
            position[11] = new Titik(-2, 2);//D11
            position[12] = new Titik(-1, 2);//D12
            position[13] = new Titik(0, 2);//D13
            position[14] = new Titik(1, 2);//D14
            position[15] = new Titik(2, 2);//D15
            position[16] = new Titik(2, 1);//D16
            position[17] = new Titik(2, 0);//D17
            position[18] = new Titik(2, -1);//D18
            position[19] = new Titik(2, -2);//D19
            position[20] = new Titik(1, -2);//D20
            position[21] = new Titik(0, -2);//D21
            position[22] = new Titik(-1, -2);//D22
            position[23] = new Titik(-2, -2);//D23
            position[24] = new Titik(-2, -1);//D24
            //end of inisialiasi array neighbous----------------------------

            //array children------------------------------------------------
            int[][] children = new int[25][];
            children[0] = new int[]{1, 2, 3, 4, 5, 6, 7, 8};//1, 2, 3, 4, 5, 6, 7, 8};
            children[1] = new int[]{24, 9, 10};
            children[2] = new int[]{10, 11, 12};
            children[3] = new int[]{12, 13, 14};
            children[4] = new int[]{14, 15, 16};
            children[5] = new int[]{16, 17, 18};
            children[6] = new int[]{18, 19, 20};
            children[7] = new int[]{20, 21, 22};
            children[8] = new int[]{22, 23, 24};
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
