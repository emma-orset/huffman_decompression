import java.util.Comparator;

public class Node {
    private Integer freq;
    private Character label;
    private Node leftChild;
    private Node rightChild;

    public Node(Integer freq, Character label){
        this.freq = freq;
        this.label = label;
    }

    public Integer getFreq(){
        return this.freq;
    }

    public Character getLabel(){
        return this.label;
    }

    public Node getLeftChild(){
        return this.leftChild;
    }

    public Node getRightChild(){
        return this.rightChild;
    }

    public void setChildren(Node leftChild, Node rightChild){
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public static Comparator<Node> compareFreq = new Comparator<Node>() {

        @Override
        public int compare(Node node1, Node node2) {
            return node1.getFreq().compareTo(node2.getFreq());
        }
    };

}