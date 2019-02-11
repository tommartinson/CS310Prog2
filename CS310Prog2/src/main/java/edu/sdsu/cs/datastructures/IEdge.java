package edu.sdsu.cs.datastructures;

public interface IEdge<E> {


    IVertex getStart();
    IVertex getDestination();
    int getWeight();


}
