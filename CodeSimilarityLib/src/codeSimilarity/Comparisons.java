package codeSimilarity;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Comparisons {
	private Set<File>             paths       = new HashSet<>();
	private List<Document>        docs        = new ArrayList<>();
	private List<FilesSimilarity> comparisons = new ArrayList<>();
	private Configurations config = null;
	
	private MessagePrinter mpProcessing = MessagePrinter.getDefaultMessagePrinter();
	private MessagePrinter mpFilesCount = MessagePrinter.getDefaultMessagePrinter();
	private MessagePrinter mpCount      = MessagePrinter.getDefaultMessagePrinter();	

	public Comparisons(Configurations config) {
		this.config = config;
	}
	
	public Comparisons() {
		Configurations config = new Configurations();
		config.setGranularity(Configurations.Granularity.BY_WORD);
		
		this.config = config;
	}
	
//	public List<Blame> makeBlameList() {
//		List<Blame> list = new ArrayList<>();
//		List<Document> aux = new ArrayList<>();
//		
//		for(FilesSimilarity fs : comparisons) {
//			Document d1 = fs.getDoc1();
//			Document d2 = fs.getDoc2();
//			
//			if(!aux.contains(d1)) {
//				list.add(new Blame(d1, fs));
//				aux.add(d1);
//			}
//			
//			if(!aux.contains(d2)) {
//				list.add(new Blame(d2, fs));
//				aux.add(d2);
//			}
//		}
//		
//		return list;
//	}

	public List<FilesSimilarity> compare() {
		
		if (docs.size() == 0) 
			createDocuments();
		
		comparisons.clear();
				
		for(int i=0; i<docs.size(); i++)
			for(int j=i+1; j<docs.size(); j++) {
				
				Document doc1 = docs.get(i);
				Document doc2 = docs.get(j);
							
				mpProcessing.show(String.format("Processing %s and %s", doc1.getSimpleName(), doc2.getSimpleName()));
				comparisons.add(new FilesSimilarity(doc1, doc2, config.getGranularity()));
			}
				
		Collections.sort(comparisons);

		mpProcessing.show("Done.");
		mpCount.show(comparisons.size() + " Comparisons");

		return comparisons;
	}

	public String toCSV() {

		StringBuilder sb = new StringBuilder();

		sb.append("Size 1, Size 2, Distance, Similarity, File 1, File 2\n"); 
		
		
		for(FilesSimilarity cf : comparisons)
			sb.append(String.format("%4d, %4d, %3d, %6.2f%%, %s, %s\n", 
						cf.getDoc1Size(),
						cf.getDoc2Size(),
						cf.getDistance(), 
						cf.getSimilarity() * 100, 
						cf.getDoc1(), 
						cf.getDoc2())
					);

		return sb.toString();
	}

	public void addPath(File path) {
		mpFilesCount.show("Adding files...");
		paths.add(path);
	}

	public void createDocuments() {
		mpFilesCount.show("Creating documents...");

		
		docs = Document.findDocs(paths, config.getExtensions(), config.getGranularity());
		
		/*
		File[] p = paths.toArray(new File[0]);
		
		File[] files = FileUtils.findFiles(p, config.getExtensions());
		
		docs.clear();
		
		for(File f : files) 
			docs.add(new Document(f, config.getGranularity()));
		*/
		mpFilesCount.show(docs.size() + " files");
	}
	
	public void showDocs() {
		System.out.println("Documents to compare:");
		for(Document f : getDocs()) {
			System.out.println("  "+f);	
		}		
	}
	
	
	public List<FilesSimilarity> getComparisons() {
		return comparisons;
	}

	public File[] getPaths() {
		return paths.toArray(new File[0]);
	}

	public List<Document> getDocs() {
		if (docs.size() == 0) 
			createDocuments();
		
		return docs;
	}
	
	public Configurations getConfig() {
		return this.config;
	}

	public void setConfig(Configurations config) {
		this.config = config;
	}

	public MessagePrinter getMPProcessing() {
		return mpProcessing;
	}

	public void setMPProcessing(MessagePrinter mpProcessing) {
		this.mpProcessing = mpProcessing;
	}

	public MessagePrinter getMPFilesCount() {
		return mpFilesCount;
	}

	public void setMPFilesCount(MessagePrinter mpFilesCount) {
		this.mpFilesCount = mpFilesCount;
	}

	public MessagePrinter getMPCount() {
		return mpCount;
	}

	public void setMPCount(MessagePrinter mpCount) {
		this.mpCount = mpCount;
	}
}
