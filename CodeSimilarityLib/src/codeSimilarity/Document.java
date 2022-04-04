package codeSimilarity;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import codeSimilarity.Configurations.Granularity;

public class Document {
	private File file;
	private File root;
	private String[] tokens;	
	
	public Document(File file, Granularity gran) {
		this.file = file;
		this.tokens = FileUtils.getTokens(this.file, gran);
	}

	public Document(File file, Granularity gran, File root) {
		this.file = file;
		this.tokens = FileUtils.getTokens(this.file, gran);
		this.root = root;
	}

	public File getFile() {
		return file;
	}

	public String[] getTokens() {
		return tokens;
	}

	@Override
	public String toString() {
		return getSimpleName();
	}	
	
	@Override
	public boolean equals(Object obj) {
		Document other = (Document) obj;
		return this.file.getAbsoluteFile().equals(other.file.getAbsoluteFile());
	}
		

	public static List<Document> findDocs(Set<File> paths, String extentions, Granularity gran) {
		List<Document> list = new ArrayList<Document>();
		String[] ex = extentions.split("\\s+|\\.|,");
		
		FileFilter filter = FileUtils.newFileFilter(ex);

		for(File path : paths)
			if (path.exists() && (path.isDirectory() || FileUtils.checkExtention(path, ex))) // case the path is file with non accpetible extention. It is necessary just for top paths, no filter here :/
				findDocs(list, path, filter, gran, path);

		return list;
	}

	private static void findDocs(List<Document> list, File path, FileFilter filter, Granularity gran, File root) {

		if (path.isDirectory())
			for(File f : path.listFiles(filter))
				findDocs(list, f, filter, gran, root);
		else
			list.add(new Document(path, gran, root));

	}

	public File getRoot() {
		return root;
	}

	public String getSimpleName() {
		String result = FileUtils.removePath(file, root).toString();
		
		if(result.startsWith("/"))
			result = result.replaceFirst("/", "");
		
		return result;
	}
	
	
	
	
	
	
	
}
