package codeSimilarity;

import java.io.File;

public class Main {

	public static void main(String[] args) {
			
		Comparisons com = new Comparisons();
		
		com.addPath(new File("test-files"));	
		com.getConfig().setExtentions("cs,sql,txt,java");
		
		com.compare();

		System.out.println(com.toCSV());

		
		for(Document f : com.getDocs()) {
			System.out.println("-->"+f);	
		}		
		
		System.out.println("\n------- Blameds -------- vai git\n");
		
		for(Blame b : com.makeBlameList()) {
			System.out.println(b);
		}		
	}
}

//http://tutorials.jenkov.com/java/packages.html


