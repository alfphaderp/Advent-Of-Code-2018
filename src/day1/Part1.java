package day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Part1 {
	public static void main(String[] args) throws IOException {
		System.out.println(Files.lines(Paths.get("day/1/input"))
				.parallel()
				.mapToInt(Integer::parseInt)
				.sum());
	}
}
