import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String files[] = {"alice", "extraitAlice", "textesimple", "texteperso", "exemple"};

        for (String file : files) {
            String path = "Resources/" + file + "/" + file;


            Tree tree = new Tree(path + "_freq.txt");
            Encode encode = new Encode();
            BinaryFile binFile = new BinaryFile(path + "_comp.bin");
            HashMap<String, String> dictEncode = encode.dictEncode(tree.getRoot(), "");
            String text = binFile.readBinFile();

            try {
                FileWriter newFile = new FileWriter(path + ".txt");
                String character = "";
                String newText = "";
                for (int i = 0; i < text.length(); i++) {

                    character += text.charAt(i);
                    for (String c : dictEncode.keySet()) {
                        if (character.compareTo(dictEncode.get(c)) == 0) {
                            newText += c;
                            character = "";
                        }
                    }
                }

                newText = newText.replace("\\n", "\n");
                newFile.write(newText);

                newFile.close();
            } catch (IOException e) {
                System.out.println("Error.");
                e.printStackTrace();
            }

            File openBinFile =new File(path + "_comp.bin");
            File openFile =new File(path + ".txt");

            if(openBinFile.exists() && openFile.exists()){
                //Détermination du taux de compression (en octets)
                double bytesB = openBinFile.length();
                double bytes = openFile.length();

                double amount = 1 - bytesB/bytes;

                System.out.println("* * * * * "+file+" * * * * *");
                System.out.println("bytes file "+ path + ".txt : " + bytes+ " octets");
                System.out.println("bytes binary file " + path + "_comp.bin : " + bytesB+ " octets");
                System.out.println("The amount for these files is : " + amount + "\n\n");

            }else{
                System.out.println("Files not find");
            }

        }

    }
}