
public class DiGraph {
    //G = (V - vertices, E - edges - adjacency matrix)
    //List<String> labels ... Vertices
    public double[][] W; //adjacency matrix - using our textbook
    //add edge  public void AddEdge(int i, int j, double weight){...}
    //remove edge

    //add vertex - optional
    //remove vertex - optional

    //n - number of vertices
    public DiGraph(int n) {
        W = new double[n][n];
    }

    public void floyd(){
        double[][] D = W.clone();
        int n = W.length;

          //let's display the result
          System.out.println("D("+ 0 +")");
          for(int row=0; row<n; row++){
              for(int col =0; col < n; col++)
              {
                  System.out.print(String.format("%10s", D[row][col]));
              }
              System.out.println();
          }
          System.out.println("===============================");


        //compute D(0), D(1), ..., D(n-1), what is n - num vertices / width of the array?
        for(int k = 0; k<n; k++)
        {
            //compute D(k)
            for(int i=0; i<n; i++)
            {
                for(int j=0; j<n; j++)
                {
                    //D(k)[i][j] = min(D(k-1)[i][j],D(k-1)[i][k]+D(k-1)[k][j] )
                    D[i][j] = Math.min(D[i][j], D[i][k]+D[k][j]);
                }
            }
     
     
            //let's display the result
            System.out.println("D("+ (k+1) +")");
            for(int row=0; row<n; row++){
                for(int col =0; col < n; col++)
                {
                    System.out.print(String.format("%10s", D[row][col]));
                }
                System.out.println();
            }
            System.out.println("===============================");
        }

    }

    public static void main(String[] args) {
        DiGraph g = new DiGraph(6); //we'll have 6 vertices/nodes

        //the adjacency matrix ...
        g.W[0][0] = 0;
        g.W[0][1] = 30;
        g.W[0][2] = Double.POSITIVE_INFINITY;
        g.W[0][3] = 5;
        g.W[0][4] = Double.POSITIVE_INFINITY;
        g.W[0][5] = Double.POSITIVE_INFINITY;
        
        g.W[1][0] = 30;
        g.W[1][1] = 0;
        g.W[1][2] = 40;
        g.W[1][3] = Double.POSITIVE_INFINITY;
        g.W[1][4] = 4;
        g.W[1][5] = 18;

        g.W[2][0] = Double.POSITIVE_INFINITY;
        g.W[2][1] = 40;
        g.W[2][2] = 0;
        g.W[2][3] = Double.POSITIVE_INFINITY;
        g.W[2][4] = Double.POSITIVE_INFINITY;
        g.W[2][5] = 50;


        g.W[3][0] = 5;
        g.W[3][1] = Double.POSITIVE_INFINITY;
        g.W[3][2] = Double.POSITIVE_INFINITY;
        g.W[3][3] = 0;
        g.W[3][4] = Double.POSITIVE_INFINITY;
        g.W[3][5] = 2;


        g.W[4][0] = Double.POSITIVE_INFINITY;
        g.W[4][1] = 4;
        g.W[4][2] = Double.POSITIVE_INFINITY;
        g.W[4][3] = Double.POSITIVE_INFINITY;
        g.W[4][4] = 0;
        g.W[4][5] = 15;

        g.W[5][0] = Double.POSITIVE_INFINITY;
        g.W[5][1] = 18;
        g.W[5][2] = 50;
        g.W[5][3] = 2;
        g.W[5][4] = 15;
        g.W[5][5] = 0;

      

        g.floyd();
    }
}