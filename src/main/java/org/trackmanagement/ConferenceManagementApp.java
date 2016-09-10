package org.trackmanagement;

import java.util.List;

public class ConferenceManagementApp {

	public static void main(String[] args) {
		
		List<Talk> talkList = TalkFileReader.readTalksFromFile(TrackConfiguration.INPUTFILE);
		
		Conference conference = TrackOrganizer.organizeTalks(talkList);
		ConferenceDisplay.printConferenceDetails(conference);
	}
}
