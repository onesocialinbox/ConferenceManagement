package org.trackmanagement;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Conference console outputter 
 * @author vijay
 *
 */
public class ConferenceDisplay {

	public static void printConferenceDetails(Conference conference) {
		StringBuilder outputter = buildConferenceOutputFormat(conference);
		System.out.println(outputter.toString());
	}

	public static StringBuilder buildConferenceOutputFormat(Conference conference) {
		StringBuilder outputter = new StringBuilder();
		List<Track> tracks = conference.getTracks();
		for (Track track : tracks) {
			outputter.append((track.getTrackName() + ":")).append("\n");
			List<Talk> talks = track.getTalks();
			for (Talk talk : talks) {
				outputter.append(formatTimeWithAmPm(talk.getStartTime())).append(" ").append(talk.getTitle())
						.append(" ").append(formatDuration(talk)).append("\n");
			}
		}
		return outputter;
	}

	private static String formatDuration(Talk talk) {
		return talk.getTitle().equals(TrackConfiguration.NETWORKING_EVENT)
				|| talk.getTitle().equals(TrackConfiguration.LUNCH_EVENT) ? "" : talk.getDuration() + "min";
	}

	private static String formatTimeWithAmPm(LocalTime time) {
		return time.format(DateTimeFormatter.ofPattern("hh:mma"));
	}

}
