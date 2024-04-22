import java.util.LinkedList;
import java.util.Scanner;

public class Graphs{
    int vertices;
    LinkedList<Integer> adjVertices[];

    public Graphs(int vertices){
        this.vertices = vertices;

        adjVertices = new LinkedList[vertices];
        //create a list of adj vertices for each vertex
        for(int i=0; i < vertices; i++){
            adjVertices[i] = new LinkedList<>();
        }
    }

    void addEdges(int sourceVertex, int destVertex){
        //add edge to both source and dest vertices
        //add condition if there is a loop
        if(sourceVertex!=destVertex){
        adjVertices[sourceVertex].add(destVertex);
        adjVertices[destVertex].add(sourceVertex);
        }
        else{
            adjVertices[sourceVertex].add(destVertex);
        }

    }


    void displayGraph(){
        //display list of adjacent vertices for each vertex

        for(int i=0; i<vertices; i++){
            //check that there are at least 1 adj vertices
            if(adjVertices[i].size()>0){
                System.out.println("Degree for Vertex " +i+ " : " + adjVertices[i].size());
                System.out.print("The adjacent vertices: ");
                for(int j=0; j<adjVertices[i].size(); j++){
                    System.out.print(adjVertices[i].get(j)+" ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args){

        Scanner s = new Scanner(System.in);

        System.out.println("Please enter the number of vertices in your graph:");
        int v = s.nextInt();

        //use number of edges to run loop 
        System.out.println("Please enter the number of edges in your graph:");
        int e = s.nextInt();

        Graphs graph = new Graphs(v);
        for(int i=0; i<e; i++){
            System.out.println("Please enter the source vertex, then the destination vertex:");
            int source = s.nextInt();
            int dest = s.nextInt();
            graph.addEdges(source, dest);
        }

        s.close();

        graph.displayGraph();

    }


}