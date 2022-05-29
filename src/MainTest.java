import java.util.Arrays;

public class MainTest {
    public static void main(String[] args) {
        String dictFile = "Resources/textFreq.txt";
        Dictionnary dict = new Dictionnary(dictFile);
        System.out.println(Arrays.asList(dict.readDict()));
    }
}