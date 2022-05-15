package codeSimilarity;

import java.io.File;

public class Main {

	public static void main(String[] args) {
			
		Comparisons com = new Comparisons();
		
		com.addPath(new File("test-files"));	
		com.getConfig().setExtentions("cs,sql,txt,java,cpp");
		
		com.showDocs();
		com.compare();

		System.out.println(com.toCSV());
	}
}



