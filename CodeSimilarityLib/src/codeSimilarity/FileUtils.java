package codeSimilarity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
	
	
	public static String removePath(File file, File path) {
		
		if(file.equals(path)) 
			return file.getName();

		return file.getAbsolutePath().replaceFirst(path.getAbsolutePath(), "");
	}
	
	public static boolean checkExtention(File file, String[] extensions) {
		
		boolean result = false;
		result |= extensions.length == 0;
		result |= (extensions.length == 1 && extensions[0].trim().length() == 0);  // case the extensions is a empty String
		result |= extensions == null;


		for(String extention : extensions)
			result |= file.getName().endsWith("."+extention);

		return result;
	}

	public static File[] findFiles(File[] paths, String extentions) {
		List<File> list = new ArrayList<File>();
		String[] ex = extentions.split("\\s+|\\.|,");
		
		FileFilter filter = FileUtils.newFileFilter(ex);

		for(File path : paths)
			if (path.exists() && (path.isDirectory() || checkExtention(path, ex))) // case the path is file with non accpetible extention. It is necessary just for top paths, no filter here :/
				findFiles(list, path, filter);

		return list.toArray(new File[0]);
	}

	public static void findFiles(List<File> list, File path, FileFilter filter) {

		if (path.isDirectory())
			for(File f : path.listFiles(filter))
				findFiles(list, f, filter);
		else
			list.add(path);

	}

	public static FileFilter newFileFilter(String[] ex) {
		return new FileFilter() {
			@Override
			public boolean accept(File file) {
				return file.isDirectory() || checkExtention(file, ex);
			}
		};
	}

	public static String readFile(File file) {
		StringBuilder sb = new StringBuilder();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));

			String s;
			while ((s = br.readLine()) != null) {
				sb.append(s+"\n");
			}

			br.close();
			
		} catch (Exception e) {
			System.out.println(e);
			sb.append(e.getMessage());
		}
		
		return sb.toString();
	}
	
	public static void saveFile(File file, String content) {
		try {
			FileWriter writer = new FileWriter(file);
			writer.write(content);
			writer.close();			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static String[] getTokens(File f, Configurations.Granularity gran) {
		List<String> tokens = new ArrayList<String>();
		String sep;
	
		switch(gran) {
			case BY_CHAR: sep = "";            break;
			case BY_WORD: sep = "\\s+|\\.|,";  break;
			case BY_LINE: sep = "\n";          break;
			default: sep = " ";
		}

		try {
			BufferedReader br = new BufferedReader(new FileReader(f));

			String s;
			while ((s = br.readLine()) != null) {
				String[] ts = s.split(sep);
				
				for(String t : ts)
					if(!t.isEmpty())
						tokens.add(t);
			}

			br.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}

		return tokens.toArray(new String[0]);
	}

}
