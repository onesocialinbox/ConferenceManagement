package org.trackmanagement;

import java.time.LocalTime;

/**
 * Morning session start/endtime  adds break event (i.e Talk). 
 * @author vijay
 *
 */
public class MorningSession extends Session {
	
	public MorningSession(LocalTime startTime, LocalTime endTime) {
		super(startTime, endTime);
	}

	public Talk getBreakEvent() {
		Talk lunchEvent = new Talk(TrackConfiguration.LUNCH_EVENT, 60);
		lunchEvent.setStartTime(LocalTime.of(12, 0));
		return lunchEvent;
	}

}
