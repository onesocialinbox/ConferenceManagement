package org.trackmanagement;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ConferenceManagementApp {

	private static final String FILE_DELIMIT = ",";

	public static void main(String[] args) {
		
		List<Talk> talkList = readTalksFromFile();
		
		Conference conference = TrackOrganizer.organizeTalks(talkList);
		ConferenceDisplay.printConferenceDetails(conference);
		
	}

	private static List<Talk> readTalksFromFile() {
		List<Talk> talks = new ArrayList<Talk>();

		try {
			List<String> lines = Files.readAllLines(new File("src/main/resources/input5.txt").toPath(),
					Charset.defaultCharset());

			for (String line : lines) {
				String[] talkAndDuration = line.split(FILE_DELIMIT);
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
