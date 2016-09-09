package org.trackmanagement;

import java.time.LocalTime;

public class EveningSession extends Session {
	
	public EveningSession(LocalTime startTime, LocalTime endTime) {
		super(startTime, endTime);
	}
	
	public Talk getBreakEvent() {
		Talk networkingEvent = new Talk("Networking Event", 60);
		networkingEvent.setStartTime(LocalTime.of(17, 0));
		return networkingEvent;
	}

}
