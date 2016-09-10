package org.trackmanagement;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class TalkFileReader {

	public static List<Talk> readTalksFromFile(String fileName) {
		List<Talk> talks = new ArrayList<Talk>();
	
		try {
			List<String> lines = Files.readAllLines(new File(fileName).toPath(),
					Charset.defaultCharset());
	
			for (String line : lines) {
				String[] talkAndDuration = line.split(ConferenceManagementApp.FILE_DELIMIT);
				int duration = 0;
				if ("lightning".equalsIgnoreCase(talkAndDuration[1])) {
					duration = 5;
				} else {
					duration = Integer.parseInt(talkAndDuration[1]);
				}
				talks.add(new Talk(talkAndDuration[0], duration));
			}
	
		} catch (IOException e) {
			e.printStackTrace();
		}
		return talks;
	}
}
