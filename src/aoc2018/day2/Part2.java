package aoc2018.day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Part2 {
	public static void main(String[] args) throws IOException {
		List<String> labels = Files.lines(Paths.get("2018/day/2/input"))
				   .parallel()
				   .collect(Collectors.toList());
		
		search:
		for(String label1 : labels)
			for(String label2 : labels)
				if(areSimilar(label1, label2)) {
					System.out.println(commonLettersOf(label1, label2));
					break search;
				}
	}
	
	public static boolean areSimilar(String str1, String str2) {
		boolean diffFound = false;
		for(int i = 0; i < str1.length(); i++) {
			if(str1.charAt(i) != str2.charAt(i)) {
				if(!diffFound)
					diffFound = true;
				else
					return false;
			}
		}
		return diffFound == true;
	}
	
	public static String commonLettersOf(String str1, String str2) {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < str1.length(); i++)
			if(str1.charAt(i) == str2.charAt(i))
				sb.append(str1.charAt(i));
		
		return sb.toString();
	}
}
