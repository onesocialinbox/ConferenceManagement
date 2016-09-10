package org.trackmanagement;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TrackConfiguration {
	
	public static List<Session> getAllSessions() {
		Session morning = new MorningSession(LocalTime.of(9, 0), LocalTime.of(12, 0));
		Session afterNoon = new EveningSession(LocalTime.of(13, 0), LocalTime.of(17, 0));
		
		List<Session> allSessions = new ArrayList<Session>();
		allSessions.add(morning);
		allSessions.add(afterNoon);
		return allSessions;
		
	}

	public static final LocalTime LUNCH_TIME = LocalTime.of(12, 0);
	public static final LocalTime TRACK_CUTOFF_TIME = LocalTime.of(16, 0);
	public static final LocalTime NETWORKING_CUTOFF_TIME = LocalTime.of(17, 0);
	public static final LocalTime TRACK_START_TIME = LocalTime.of(9, 0);
	public static final String FILE_DELIMIT = " ";
	public static final String NETWORKING_EVENT = "Networking Event";
	public static final String LUNCH_EVENT = "Lunch";
	public static final String INPUTFILE = "src/main/resources/input.txt";
}
