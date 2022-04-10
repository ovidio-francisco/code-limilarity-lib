package docSimilarityGUI;

import codeSimilarity.Comparisons;

/**
 * @author Ovídio José Francisco
 */
public class Main {

    public static void main(String[] args) {

        Comparisons com = new Comparisons();
        
        FmMain f = new FmMain();
        f.setComparisons(com);
        f.setSize(1200, 700);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
    
}




/*
Create the executable by cliking in build.xml --> Run Target --> Other Target --> package-for-store

the Jar file will be in the store folder

https://www.oracle.com/technical-resources/articles/javase/single-jar.html


*/