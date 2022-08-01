package waterflow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class AlgorithmDX implements Algorithm {

    private Data data = null;
    Titik[] position = null;
    int[][] children = null;

    public AlgorithmDX(Data data, Titik[] position, int[][] children) {
        this.data = data;
        this.position = position;
        this.children = children;
        this.flowDirection();
    }

    @Override
    public void flowDirection() {
        if (data != null && position != null && children != null) {
            //reset output----------------------------------------------------------
            int[][] result = null;
            ArrayList<Edge> graph = null;

            //baca data input-------------------------------------------------------
            double[][] dataElevasi = data.getElevasi();
            int rows = data.getRows();
            int cols = data.getCols();
            ArrayList<Titik> listTitikPusat = data.getListTitikPusat();

            //memulai persiapan pencarian---------------------------------------
            if (dataElevasi != null && listTitikPusat != null && !listTitikPusat.isEmpty()) {
                //set nilai deafault untuk array result = -2 -------------------
                result = new int[rows][cols];
                for (int i = 0; i < result.length; i++) {
                    Arrays.fill(result[i], -2);
                }

                //inisialisasi graph--------------------------------------------
                graph = new ArrayList<>();

                //membuat antrian titik untuk dievaluasi arah alirannya---------
                Queue<Titik> antrianTitik = new LinkedList<>();

                //masukkan semua titik pusat yang ada di list ke dalam antrian
                for (Titik titik : listTitikPusat) {
                    if (titik.getX() >= 0 && titik.getX() < rows && titik.getY() >= 0 && titik.getY() < cols && !antrianTitik.contains(titik)) {
                        result[titik.getX()][titik.getY()] = -1;
                        antrianTitik.add(titik);
                    }
                }

                //melakukan loop pencarian flow direction
                while (!antrianTitik.isEmpty()) {
                    Titik center = antrianTitik.poll();//baca titik center
                    System.out.println(center);
                    //origin
                    int io = center.getX();
                    int jo = center.getY();

                    //titik destination
                    int id = io;
                    int jd = jo;

                    int arah = 0;//initial arah 
                    int[] candidates = children[arah];//children in ring-1

                    //persiapan scan neighbours
                    //result[io][jo] = 0;//set initial result ini (io,jo)f
                    double MIN = Double.MAX_VALUE;//inisialisasi titik terndah dengan nilai MAX
                    while (candidates != null) {
                        int canditateArah = arah;
                        
                        //titik destination mula-mula
                        id = io + position[canditateArah].getX();
                        jd = jo + position[canditateArah].getY();
                        result[id][jd] = -1;//arah;//set initial result di titik center = 0
                        
                        for (int c = 0; c < candidates.length; c++) {
                            int direction = candidates[c];
                            Titik posisi = position[direction];
                            int I = io + posisi.getX();
                            int J = jo + posisi.getY();
                            if (I >= 0 && I < rows && J >= 0 && J < cols && dataElevasi[I][J] < MIN) {
                                MIN = dataElevasi[I][J];
                                canditateArah = direction;
                                id = I;
                                jd = J;
                            }
                        }

                        //reset candidates dengan children yang baru
                        candidates = null;

                        //set arah                       
                        if (MIN < dataElevasi[io][jo] && canditateArah != arah) {
                            arah = canditateArah;
                            candidates = children[arah];
                            //result[id][jd] = -1;
                        }
                        System.out.println("Akhirnya: " + Arrays.toString(candidates));
                    }//end of while (candidates != null)

                    //save graph dan tambahkan titik destination yang baru ke antrianTitik untuk dievaluasi pada iterasi berikutnya                    
                    if (arah > 0) {
                        result[io][jo] = arah;
                        Titik origin = center;
                        Titik destination = new Titik(id, jd);
                        Edge edge = new Edge(origin, destination);
                        graph.add(edge);//menambahkan edge baru ke graph
                        if (result[id][jd] < 0 && !antrianTitik.contains(destination)) {
                            antrianTitik.offer(destination);//tambahkan titik destination ke dalam antrian titik
                        }
                    }//end of if(arah>0)

                }//end of while (!antrianTitik.isEmpty())-----------------------

                //set result
                data.setResult(result);
                data.setGraph(graph);

            }//end of if (dataElevasi != null && listTitikPusat != null && !listTitikPusat.isEmpty())            
        }//if (data != null && position != null && children != null)
    }//end of flowDirection()

    @Override
    public Data getData() {
        return this.data;
    }

}
