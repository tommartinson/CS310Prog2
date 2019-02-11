package edu.sdsu.cs.datastructures;
import java.util.*;

public class WDGraph<V,E> implements IGraph<V,E> {

    private Map<String,List<IEdge<E>>> graphMap = new HashMap<>();
    private List<IVertex<V>> vertexList = new ArrayList<>();
    private List<IEdge<E>> edgeList = new ArrayList<>();

    private int numEdges;

    public WDGraph(){}

    @Override
    public String toString(){
        String ret = "\nConstructed Graph: \n";
        ret+=numVertices()+" vertices\n"+numEdges()+" edges\n\n";
        ret+="Connection List:\n";
        //iterate through the map
        for(Map.Entry<String, List<IEdge<E>>> entry : graphMap.entrySet()){
            String key = entry.getKey();
            List<IEdge<E>> value = entry.getValue();
            ret+=key+": ";
            for(int i = 0;i<value.size();i++){
                numEdges++;
                String destName = value.get(i).getDestination().getName();
                int weight = value.get(i).getWeight();
                ret+= destName+"("+weight+") ";
            }
            ret+="\n";

        }
        return ret;
    }

    /**needs to be fixed add to Ivertex list on the side*/
    @Override
    public Iterable<IVertex<V>> vertices() {
        return new Iterable<IVertex<V>>(){
            @Override
            public Iterator<IVertex<V>> iterator(){
                return vertexList.iterator();

            }
        };


    }

    @Override
    public Iterable<IEdge<E>> edges() {
        return new Iterable<IEdge<E>>(){
            @Override
            public Iterator<IEdge<E>> iterator(){
                return edgeList.iterator();

            }
        };

    }

    @Override
    public int numEdges() {
        //numEdges +1 for each loop through edges
        return numEdges;
    }

    @Override
    public int numVertices() {
        //keySet() returns set of keys, size() returns length of the set;
        return graphMap.keySet().size();
    }
    /**Not sure if this works or not*/
    @Override
    public int minimumDistance(IVertex<V> start, IVertex<V> end) {
        int distance = -1;
        for(int i = 0;i<graphMap.get(start.getName()).size();i++){
            if(graphMap.get(start.getName()).get(i).getDestination().getName() == end.getName()){
                distance = graphMap.get(start.getName()).get(i).getWeight();
            }
        }
        return distance;
    }

    @Override
    public Iterable<IEdge> shortestPath(IVertex start, IVertex end) {
        return null;
    }

    @Override
    public void connectVertices(IVertex start, IVertex end, int weight) {
        WeightedEdge newEdge = new WeightedEdge();
        newEdge.setWeight(weight);
        newEdge.setDestination(end);
        newEdge.setStart(start);
        addEdge(newEdge);
    }

    @Override
    public void addVertex(IVertex<V> toAdd) {
        vertexList.add(toAdd);
        graphMap.put(toAdd.getName(), new LinkedList<IEdge<E>>());

    }

    @Override
    public void addEdge(IEdge<E> toAdd) {
        if(graphMap.get(toAdd.getStart().getName())==null){
            System.out.println("Vertex: "+toAdd.getStart().getName()+" not found as a key.");
        }else {
            graphMap.get(toAdd.getStart().getName()).add(toAdd);
            edgeList.add(toAdd);
            numEdges++;
        }

    }
}
