package main.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FileReaderTest {

	public static ArrayList<String> getStringArray(String filePath) throws IOException {
		ArrayList<String> list = new ArrayList<String>();

		BufferedReader br = null;
		int count = 0;

		try {
			File textFile = new File(filePath);
			br = new BufferedReader(new FileReader(textFile));

			String line = "";
			while ((line = br.readLine()) != null) {
				String trimLine = line.trim();
				if (trimLine.length() == 0) {
					continue;
				}
				StringTokenizer st = new StringTokenizer(trimLine, ",");
				while (st.hasMoreTokens()) {
					list.add(st.nextToken());
				}
				count++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("File read failed, error line:" + count + ".");
		} finally {
			if (br != null) {
				br.close();
			}
		}
		System.out.println("Totally " + count + " lines in file.");
		return list;
	}

	public static void main(String[] args) {
		ArrayList<String> list = null;
		
		try {
			list = getStringArray("C:/Users/xuxiaoji/workspace/JavaProject4Test/src/test/resource/Testfile.csv");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("List size: " + list.size() + ".");
		
		for(int i = 0; i<list.size(); i++){
			System.out.println(list.get(i));
		}
		
	}
}
