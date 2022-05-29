import java.util.Comparator;

public class Node {
    private Integer freq;
    private Character label;
    private Node leftChild;
    private Node rightChild;

    public Integer getFreq() {
        return freq;
    }

    public void setFreq(Integer freq) {
        this.freq = freq;
    }

    public Character getLabel() {
        return label;
    }

    public void setLabel(Character label) {
        this.label = label;
    }

    public void setChildren(Node leftChild, Node rightChild){
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }



    public Node(Integer freq, Character label){
        this.freq = freq;
        this.label = label;
    }

    public static Comparator<Node> compareFreq = new Comparator<Node>() {
        //Comparer les fréquences des deux nodes
        //Retourne >0 ou 0
        @Override
        public int compare(Node node1, Node node2) {
            return node1.getFreq().compareTo(node2.getFreq());
        }
    };

    @Override
    public String toString(){
        return this.getFreq() + " " + this.getLabel() + " " + this.getLeftChild() + " " + this.getRightChild() + "\n";
    }
}