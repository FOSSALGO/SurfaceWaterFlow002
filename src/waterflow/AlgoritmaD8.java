package waterflow;

public class AlgoritmaD8 implements Algorithm {

    private Data data = null;

    public AlgoritmaD8(Data data) {
        this.data = data;
        this.flowDirection();
    }

    @Override
    public void flowDirection() {
        if (this.data != null) {
            //array neighbous-------------------------------------------------------
            Titik[] position = new Titik[9];
            position[0] = new Titik(0, 0);//D0
            position[1] = new Titik(-1, 0);//D1
            position[2] = new Titik(-1, 1);//D2
            position[3] = new Titik(0, 1);//D3
            position[4] = new Titik(1, 1);//D4
            position[5] = new Titik(1, 0);//D5
            position[6] = new Titik(1, -1);//D6
            position[7] = new Titik(0, -1);//D7
            position[8] = new Titik(-1, -1);//D8        
            //end of inisialiasi array neighbous------------------------------------

            //array children--------------------------------------------------------
            int[][] children = new int[9][];
            children[0] = new int[]{1, 2, 3, 4, 5, 6, 7, 8};//1, 2, 3, 4, 5, 6, 7, 8};
            //end of inisialisasi array children------------------------------------

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
