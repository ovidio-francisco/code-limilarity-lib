package codeSimilarity;

import codeSimilarity.Configurations.Granularity;

public final class FilesSimilarity implements Comparable<FilesSimilarity> {

	private final Document doc1;
	private final Document doc2;
	private final int doc1Size;
	private final int doc2Size;
	private final int distance;
	private final double similarity;

	public FilesSimilarity(Document file1, Document file2, Granularity gran){
	
		this.doc1 = file1;
		this.doc2 = file2;

		String[] t1 = FileUtils.getTokens(this.doc1.getFile(), gran);
		String[] t2 = FileUtils.getTokens(this.doc2.getFile(), gran);

		this.doc1Size = t1.length;
		this.doc2Size = t2.length;	
		int larger = t1.length > t2.length ? t1.length : t2.length;

		if (larger == 0) {
			this.similarity = (double)larger;
			this.distance   = 0;
			return;
		}

		this.distance = Levenshtein.compare(t1, t2);
		this.similarity = 1 - (double)this.distance / larger;
	}

	public Document getDoc1() {
		return this.doc1;
	}

	public Document getDoc2() {
		return this.doc2;
	}

	public int getDoc1Size() {
		return this.doc1Size;
	}

	public int getDoc2Size() {
		return this.doc2Size;
	}

	public int getDistance() {
		return this.distance;
	}

	public double getSimilarity() {
		return this.similarity;
	}

	@Override
	public int compareTo(FilesSimilarity other) {

		double s1 = this.similarity;
		double s2 = other.similarity;

		if ( s1 > s2 )
			return -1;
		else
			if ( s2 > s1 )
				return 1;
			else
				return 0;
	}

	@Override
	public boolean equals(Object obj) {
		FilesSimilarity other = (FilesSimilarity) obj;
		
		String s1 = this.doc1.getFile().getAbsolutePath();
		String s2 = other.doc1.getFile().getAbsolutePath();
				
		return s1.equals(s2);
	}
	
	
}


