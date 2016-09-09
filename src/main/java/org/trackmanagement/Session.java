package org.trackmanagement;

import java.time.LocalTime;
import java.util.List;

public abstract class Session {
	
	private LocalTime startTime;
	private LocalTime endTime;

	private List<Talk> allEvents;
	
	public Session(LocalTime startTime, LocalTime endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public boolean canScheduleTalk(Talk currentEvent, LocalTime currentTrackTime) {
		return currentTrackTime.isBefore(endTime);
	}

	public abstract Talk getBreakEvent();
	
	public List<Talk> getAllEvents() {
		return allEvents;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	

}
