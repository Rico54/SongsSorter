package ratings.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Graph <N>{
    private HashMap<N, ArrayList<N>> adjacencyList;
    public Graph(){
        this.adjacencyList=new HashMap<>();
    }
    public boolean areConnected(N from,N to){
        return this.adjacencyList.containsKey(from) &&
                this.adjacencyList.get(from).contains(to);
    }
    public boolean validPath(ArrayList<N> path){
        for (int x=0;x<path.size()-1;x++){
            if (!areConnected(path.get(x),path.get(x+1))){
                return false;
            }
        }
        return true;
    }

    private void addNode(N a){
        if (!this.adjacencyList.containsKey(a)){
            this.adjacencyList.put(a,new ArrayList<>());
        }
    }
    public void addEdge(N from,N to){
        this.addNode(from);
        this.addNode(to);
        if(!this.adjacencyList.get(from).contains(to)) {
            this.adjacencyList.get(from).add(to);
        }
        if(!this.adjacencyList.get(to).contains(from)) {
            this.adjacencyList.get(to).add(from);
        }
    }
    public HashMap<N, ArrayList<N>> getAdjacencyList(){
        return this.adjacencyList;
    }
    @Override
    public String toString(){
        return this.adjacencyList.toString();
    }

    }