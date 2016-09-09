package org.trackmanagement;

import java.time.LocalTime;

public class MorningSession extends Session {
	
	public MorningSession(LocalTime startTime, LocalTime endTime) {
		super(startTime, endTime);
	}

	public Talk getBreakEvent() {
		Talk lunchEvent = new Talk("Lunch Event", 60);
		lunchEvent.setStartTime(LocalTime.of(12, 0));
		return lunchEvent;
	}

}
