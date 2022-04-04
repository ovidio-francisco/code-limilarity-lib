package codeSimilarity;

public class Blame implements Comparable<Blame> {
	private final Document suspect;
	private final FilesSimilarity filesSimilarity;
	
	public Blame(Document suspect, FilesSimilarity filesSimilarity) {
		this.suspect = suspect;
		this.filesSimilarity = filesSimilarity;
	}
	
	public int getSuspectSize() {
		return this.suspect.equals(filesSimilarity.getDoc1()) ? filesSimilarity.getDoc1Size() : filesSimilarity.getDoc2Size();		
	}
	
	public int getOtherSize() {
		return this.suspect.equals(filesSimilarity.getDoc1()) ? filesSimilarity.getDoc2Size() : filesSimilarity.getDoc1Size();		
	}
	
	public int getDistance() {
		return filesSimilarity.getDistance();
	}

	public double getSimilarity() {
		return filesSimilarity.getSimilarity();
	}
	
	public Document getTheOther() {
		return this.suspect.equals(filesSimilarity.getDoc1()) ? filesSimilarity.getDoc2() : filesSimilarity.getDoc1();
	}
	
	public Document getSuspect() {
		return suspect;
	}

	public FilesSimilarity getFilesSimilarity() {
		return filesSimilarity;
	}

	@Override
	public int compareTo(Blame o) {
		return this.suspect.getFile().getAbsoluteFile().compareTo(o.suspect.getFile().getAbsoluteFile());
	}

	@Override
	public String toString() {
		String result = "";
		result += String.format("%6.2f%%, %s, %s", getSimilarity()*100, suspect, getTheOther());
		
		return result;
	}	
	
	
}
