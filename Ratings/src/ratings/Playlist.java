//package ratings;
//
//
//import ratings.datastructures.*;
//
//
//public class Playlist {
//    private BST<Song> rot;
//    private Comparator<Song> comparator;
//
//    public Playlist(Comparator<Song> compare) {
//        this.comparator = compare;
//        this.rot = null;
//
//    }
//
//    public void addSong(Song value) {
//        if (this.rot == null){
//            this.rot = new BST<Song>(this.comparator);
//        }
//        this.rot.insert(value);
//    }
//
//
//
//    public BinaryTreeNode<Song> getSongTree()
//    {
//        if(this.rot == null){
//            return null;
//        }
//        return this.rot.getRoot();
//    }
//
//    LinkedListNode<Song> song;
//    public LinkedListNode<Song> getSongList(BinaryTreeNode<Song> takein) {
//        if (takein != null) {
//            getSongList(takein.getRight());
//            if (this.song == null) {
//                this.song = new LinkedListNode<>(takein.getValue(), null);
//            } else {
//                this.song = new LinkedListNode<>(takein.getValue(), this.song);
//            }
//            getSongList(takein.getLeft());
//            return this.song;
//
//        }
//        return this.song;
//    }
//
//    public LinkedListNode<Song> getSongList() {
//        return getSongList(getSongTree());
//    }
//    public static void main(String[] args) {
//        Song song1 = new Song("first", "Nirvana", "vabnZ9-ex7o");
//        song1.addRating(new Rating("person", 4));
//        song1.addRating(new Rating("person", 5));
//        song1.bayesianAverageRating(2,3);
//        Song song2 = new Song("sec", "bba", "sec");
//        song2.addRating(new Rating("yessir", 5));
//        song2.addRating(new Rating("nosir", 4));
//        Song song3 = new Song("third", "three", "san");
//        song3.addRating(new Rating("best", 3));
//        song3.addRating(new Rating("ova", 1));
//        Playlist first = new Playlist(new SongTitleComparator());
//        System.out.println(first.getSongTree());
//        first.addSong(song2);
//        first.addSong(song1);
//        first.addSong(song3);
//
//        System.out.println(first.getSongTree());
//
//    }
//
//
//}
package ratings;


import ratings.datastructures.BinaryTreeNode;
import ratings.datastructures.Comparator;
import ratings.datastructures.LinkedListNode;


import java.util.ArrayList;

public class Playlist {
    private BinaryTreeNode<Song> root;
    private Comparator<Song> comparator;
    private LinkedListNode<Song> song;

    public Playlist(Comparator<Song> compare){
        this.comparator = compare;
        this.root = null;
        this.song = null;
    }
    public void addSong(Song value){
        if (this.root == null) {
            this.root = new BinaryTreeNode<Song>(value, null, null);
        } else {
            this.insertHelper(this.root, value);
        }

    }
    private void insertHelper(BinaryTreeNode<Song> node, Song toInsert) {
        if (this.comparator.compare(toInsert,node.getValue())) {
            if (node.getLeft() == null) {
                node.setLeft(new BinaryTreeNode<Song>(toInsert, null, null));
            } else {
                insertHelper(node.getLeft(), toInsert);
            }
        } else {
            if (node.getRight() == null) {
                node.setRight(new BinaryTreeNode<Song>(toInsert, null, null));
            } else {
                insertHelper(node.getRight(), toInsert);
            }
        }
    }


    public BinaryTreeNode<Song> getSongTree(){
        return this.root;
    }

    ArrayList<Song> out = new ArrayList<>();

    public ArrayList inOrderTraversal(BinaryTreeNode<Song> node) {

        if (node != null) {
            inOrderTraversal(node.getLeft());
            out.add(node.getValue());
            inOrderTraversal(node.getRight());
            return out;
        } else {
            return null;
        }
    }

    public LinkedListNode<Song> getSongList(BinaryTreeNode<Song> takein) {
        if(takein != null){
            getSongList(takein.getRight());
            if (this.song == null) {
                this.song = new LinkedListNode<>(takein.getValue(), null);
            }else {
                this.song = new LinkedListNode<>(takein.getValue(), this.song);
            }
            getSongList(takein.getLeft());
            return this.song;

        }
        return null;
    }

    public LinkedListNode<Song> getSongList(){
        return getSongList(getSongTree());
    }





}
