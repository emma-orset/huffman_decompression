import java.io.*;
import java.util.HashMap;

public class Dictionnary {
    private String nameFile;

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
                    dict.put(line.charAt(0), Character.getNumericValue(line.charAt(2)));
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
