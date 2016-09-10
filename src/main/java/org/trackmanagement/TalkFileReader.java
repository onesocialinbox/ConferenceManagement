package org.trackmanagement;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * Read and parse talks details from file to Talk list objects. 
 * @author vijay
 *
 */
public class TalkFileReader {

	public static List<Talk> readTalksFromFile(String fileName) {
		List<Talk> talks = new ArrayList<Talk>();
	
		try {
			List<String> lines = Files.readAllLines(new File(fileName).toPath(),
					Charset.defaultCharset());
	
			for (String line : lines) {
				String durationInfo = line.substring(line.lastIndexOf(TrackConfiguration.FILE_DELIMIT)+1);
				String talkTitle = line.substring(0, line.lastIndexOf(TrackConfiguration.FILE_DELIMIT));
				int duration = 0;
				if ("lightning".equalsIgnoreCase(durationInfo)) {
					duration = 5;
				} else {
					String durationValue = durationInfo.replace("min", "");
					duration = Integer.parseInt(durationValue);
				}
				talks.add(new Talk(talkTitle, duration));
			}
	
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Input file is not in the right format", e);
		}
		return talks;
	}
}
