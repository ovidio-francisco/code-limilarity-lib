package codeSimilarity;

public class Configurations {
	
	/** Sets how the document will splitted */
	public enum Granularity { BY_CHAR, BY_WORD, BY_LINE }
	
	
	private String extensions = "";
	private Granularity granularity = Granularity.BY_WORD;

	public Granularity getGranularity() {
		return granularity;
	}

	public void setGranularity(Granularity granularity) {
		this.granularity = granularity;
	}

	public String getExtensions() {
		return extensions;
	}

	public void setExtentions(String extentions) {
		this.extensions = extentions;
	}
}
