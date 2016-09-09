package org.trackmanagement;

import java.util.List;

public class ConferenceDisplay {

	public static void printConferenceDetails(Conference conference) {
		
		List<Track> tracks = conference.getTracks();
		for (Track track : tracks) {
			System.out.println("Name: " + track.getTrackName());
			List<Talk> talks = track.getTalks();
			for (Talk talk : talks) {
				System.out.println(talk.getStartTime() + " :::" + talk.getTitle() + "  Time " + talk.getDuration());
			}
		}
		
	}

}
