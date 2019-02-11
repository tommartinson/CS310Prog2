package edu.sdsu.cs.datastructures;

import java.util.Comparator;


public class WeightedEdge<E> implements IEdge<E> {
    private Comparator gauge = Comparator.naturalOrder();
    private IVertex start;
    private IVertex destination;
    private int cost;


    public WeightedEdge(){}
    public WeightedEdge(Comparator comparator){
        gauge = comparator;
    }

    public Comparator comparator() {
        return gauge;
    }

    public void setStart(IVertex startVertex){
        start = startVertex;
    }

    public void setDestination(IVertex endVertex){
        destination = endVertex;
    }

    public void setWeight(int weight){
        cost = weight;
    }
    @Override
    public IVertex getStart(){
        return start;
    }
    @Override
    public IVertex getDestination(){
        return destination;
    }
    @Override
    public int getWeight(){
        return cost;
    }
}