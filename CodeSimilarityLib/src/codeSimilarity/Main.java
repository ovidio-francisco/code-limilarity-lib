package codeSimilarity;

import java.io.File;

public class Main {

	public static void main(String[] args) {
			
		Comparisons com = new Comparisons();
		
		com.addPath(new File("test-files"));	
		com.getConfig().setExtentions("cs,sql,txt,java");
		com.showDocs();
		
		com.compare();

		System.out.println(com.toCSV());


		
//		System.out.println("\n------- Blamed --------\n");
		
//		for(Blame b : com.makeBlameList()) {
//			System.out.println(b);
//		}		
	}
}

//http://tutorials.jenkov.com/java/packages.html


