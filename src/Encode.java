import java.util.HashMap;

public class Encode {
    private HashMap<Character, String> encode = new HashMap<Character, String>();

    public Encode() {
    }

    public HashMap<Character, String> dictEncode(Node node, String code) {
        if(node == null){
            return null;
        }
        if (node.getLabel() != null){
            this.encode.put(node.getLabel(), code);
        }
        this.dictEncode(node.getLeftChild(), code + "0");
        this.dictEncode(node.getRightChild(), code + "1");
        return this.encode;
    }

}
