package util;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Util {
	public static List<String> getLines(String path) {
		try {
			return Files.lines(Paths.get(path))
					    .parallel()
					    .collect(Collectors.toList());
		} catch(IOException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
