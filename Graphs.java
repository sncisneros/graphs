import java.util.LinkedList;

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
        Graphs graph = new Graphs(6);

        graph.addEdges(0,3);
        graph.addEdges(0,4);
        graph.addEdges(1,2);
        graph.addEdges(2, 3);
        graph.addEdges(2,4);
        graph.addEdges(2,5);
        graph.addEdges(1, 1);

        graph.displayGraph();

    }


}