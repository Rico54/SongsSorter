package ratings;

import ratings.datastructures.Graph;
import ratings.datastructures.Queue;

import java.util.ArrayList;
import java.util.HashMap;

public class DegreesOfSeparation {
    private Graph<String> graph = new Graph<>();
    private ArrayList<Movie> list;
    public DegreesOfSeparation(ArrayList<Movie> lis){
        this.list = lis;

    }
    //recursion bfs
//    public void helper() {
//        if (this.queue.getFront() != null) {
//            String dequeue = this.queue.dequeue();
//            for (String casts : this.graph.getAdjacencyList().get(dequeue)) {
//                if (!(this.cav.contains(casts))) {
//                    this.cav.add(casts);
//                    this.track.put(casts, this.track.get(dequeue) + 1);
//                    this.queue.enqueue(casts);
//                }
//            }
//            helper();
//        }
//    }
    public Graph<String> getGraph(){
        return this.graph;
    }
    public int degreesOfSeparation(String cast1, String cast2){
        Queue<String> queue = new Queue<>();
        HashMap<String, Integer> track = new HashMap<>();
        ArrayList<String> cav = new ArrayList<>();

        //cast member to graph node code
        HashMap<String,ArrayList<String>> tes = new HashMap<>();
        for(int i= 0; i< this.list.size(); i++){
            ArrayList<String> cast = this.list.get(i).getCast();
            for(int y = 0; y<cast.size(); y++){
                for(int x = 1; x<cast.size(); x++){
                    this.graph.addEdge(cast.get(y),cast.get(x));
                }
            }
        }

        //BFS starts
        if(this.graph.getAdjacencyList().containsKey(cast1)){
            queue.enqueue(cast1);
            track.put(cast1,0);
        }else{
            return -1;
        }
//        helper();
        while(queue.getFront() != null) {
            String dequeue = queue.dequeue();
            HashMap<String, ArrayList<String>> graph = this.graph.getAdjacencyList();
            if (graph != null) {
                if (graph.get(dequeue) != null) {
                    for (int casts = 0; casts < graph.get(dequeue).size(); casts++) {
                        if (!(track.containsKey(graph.get(dequeue).get(casts)))) {
                            track.put(graph.get(dequeue).get(casts), track.get(dequeue) + 1);
                            queue.enqueue(graph.get(dequeue).get(casts));
                        }
                    }
                } else {
                    return -1;
                }
            }
        }

        //used to find the degrees
        if(track.containsKey(cast2)){
            return track.get(cast2);
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {

        DegreesOfSeparation he = new DegreesOfSeparation(FileReader.readMovies("data/testsmalldegrees.csv"));

        System.out.println(he.degreesOfSeparation("same one","same one"));
        System.out.println(he.getGraph().getAdjacencyList());

    }

}
