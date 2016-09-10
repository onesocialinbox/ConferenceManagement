package org.trackmanagement;

import java.time.LocalTime;

public class EveningSession extends Session {
	
	public EveningSession(LocalTime startTime, LocalTime endTime) {
		super(startTime, endTime);
	}
	
	public Talk getBreakEvent() {
		Talk networkingEvent = new Talk(TrackConfiguration.NETWORKING_EVENT, 0);
		networkingEvent.setStartTime(LocalTime.of(17, 0));
		return networkingEvent;
	}

}
