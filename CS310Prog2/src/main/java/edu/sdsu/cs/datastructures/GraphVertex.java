package edu.sdsu.cs.datastructures;

public class GraphVertex<V> implements IVertex<V> {
    private String name;


    @Override
    public String getName(){
        return name;
    }

    public void setName(String vertexName){
        name = vertexName;
    }
}
