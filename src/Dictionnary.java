import java.io.*;
import java.util.HashMap;

public class Dictionnary {
    private String nameFile;

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public Dictionnary(String nameFile) {
        this.nameFile = nameFile;
    }

    //Création d'un HashMap qui va stocker les caractères du dictionnaire associés à leur fréquence sous forme de clé/valeur
    public HashMap<Character,Integer> readDict() {
        HashMap<Character,Integer> dict = new HashMap<Character,Integer>();
        File document = new File(this.nameFile);
        try{
            BufferedReader file = new BufferedReader(new FileReader(document));
            String line;
            int numLine = 1;
            int lenghtDict = 1;

            //Tant que la ligne qu'on lit a quelque chose d'écrit
            while((line = file.readLine()) != null){

                //Obtenir la longueur du dictionnaire
                if (numLine == 1){
                    lenghtDict = Integer.parseInt(line);
                }

                //Parcourir le dictionnaire
                if (numLine > 2 && numLine <= lenghtDict + 2){
                    String freq="";

                    //Pour un grand texte, la fréquence du cacatère peut être >9
                    for(int i=2; i<line.length();i++) {
                        freq = freq + line.charAt(i);
                    }

                    //La clé du HM est le caractère et la valeur associée est la fréquence associée
                    dict.put(line.charAt(0), Integer.parseInt(freq));
                }
                numLine++;

            }
            file.close();

            //Si le HashMap n'a pas une longueur conforme, alors on l'efface
            if (dict.size() != lenghtDict){
                dict.clear();
           }

        }
        catch (IOException error){
            error.printStackTrace();
        }


        return dict;
    }


}
