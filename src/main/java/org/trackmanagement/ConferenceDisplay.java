package org.trackmanagement;

import java.util.List;

public class ConferenceDisplay {

	public static void printConferenceDetails(Conference conference) {
		StringBuilder outputter = buildConferenceOutputFormat(conference);
		System.out.println(outputter.toString());
	}

	public static StringBuilder buildConferenceOutputFormat(Conference conference) {
		StringBuilder outputter = new StringBuilder();
		List<Track> tracks = conference.getTracks();
		for (Track track : tracks) {
			outputter.append(("Name: " + track.getTrackName())).append("\n");
			List<Talk> talks = track.getTalks();
			for (Talk talk : talks) {
				outputter.append(talk.getStartTime()).append(" ")
						.append(talk.getTitle()).append(" ")
						.append(talk.getDuration()).append("\n");
			}
		}
		return outputter;
	}

}
