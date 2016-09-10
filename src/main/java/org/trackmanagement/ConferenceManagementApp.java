package org.trackmanagement;

import java.util.List;

public class ConferenceManagementApp {

	static final String FILE_DELIMIT = ",";

	public static void main(String[] args) {
		
		String fileName = "src/main/resources/input.txt";
		
		List<Talk> talkList = TalkFileReader.readTalksFromFile(fileName);
		
		Conference conference = TrackOrganizer.organizeTalks(talkList);
		ConferenceDisplay.printConferenceDetails(conference);
	}
}
