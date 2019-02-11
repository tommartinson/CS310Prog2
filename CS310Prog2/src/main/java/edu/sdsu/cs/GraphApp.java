package edu.sdsu.cs;
import edu.sdsu.cs.datastructures.*;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class GraphApp
{
    private static List<String> cities;
    private static List<String> edgeStarts;
    private static List<String> edgeDests;
    private static List<Integer> edgeWeights;
    private static String vertFileName;
    private static String edgesFileName;

    public static void main( String[] args ) {
        IGraph newGraph = new WDGraph();

        vertFileName = "./cities.csv";
        edgesFileName = "./edges.csv";
        if(args.length == 2){
            vertFileName = args[0];
            edgesFileName = args[1];
        }
        if(args.length!=0 && args.length!=2){

            System.out.println("Error: Incorrect number of input arguments (0 or 2 expected), "+args.length+
                    " provided");
        }
        getVerticesFromFile();

        for (int i = 0;i<cities.size();i++){
            GraphVertex newVert = new GraphVertex();
            String nameOfVertex = cities.get(i);
            newVert.setName(nameOfVertex);
            newGraph.addVertex(newVert);
        }


        getEdgesFromFile();
        /**Uncomment to test WDGraph toString*/
        //System.out.println(newGraph);

        for (int i = 0;i<edgeStarts.size();i++){
            //create new edge
            WeightedEdge newEdge = new WeightedEdge();

            //create start vertex
            GraphVertex startVertex = new GraphVertex();
            String edgeStart = edgeStarts.get(i);
            startVertex.setName(edgeStart);

            //add start vertex to edge
            newEdge.setStart(startVertex);

            //create end vertex
            GraphVertex endVertex = new GraphVertex();
            String edgeEnd = edgeDests.get(i);
            endVertex.setName(edgeEnd);

            //add end vertex to edge
            newEdge.setDestination(endVertex);

            //add weight to edge
            newEdge.setWeight(edgeWeights.get(i));

            //add edge to graph

            newGraph.addEdge(newEdge);

        }
        System.out.println(newGraph);

    }

    public static void getVerticesFromFile (){
        try {
            Path vertexFileDest = Paths.get(vertFileName);

            List<String> fileContents;
            fileContents = Files.readAllLines(vertexFileDest, Charset.defaultCharset());
            cities = new ArrayList<>();

            for (int i = 0; i < fileContents.size(); i++) {
                cities.add(fileContents.get(i).split(",")[0]);
            }

        } catch(Exception e){
            e.printStackTrace();
        }
    }


    public static void getEdgesFromFile(){
        try {
            Path edgeFileDest = Paths.get(edgesFileName);

            List<String> fileContents;
            fileContents = Files.readAllLines(edgeFileDest, Charset.defaultCharset());
            edgeStarts = new ArrayList<>();
            edgeDests = new ArrayList<>();
            edgeWeights = new ArrayList<>();


            for (int i = 0; i < fileContents.size(); i++) {
                edgeStarts.add(fileContents.get(i).split(",")[0]);
                edgeDests.add(fileContents.get(i).split(",")[1]);
                edgeWeights.add(Integer.parseInt((fileContents.get(i).split(",")[2])));
            }

        } catch(Exception e){
            e.printStackTrace();
        }
    }


}