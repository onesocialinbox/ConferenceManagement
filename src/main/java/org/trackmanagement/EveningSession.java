package org.trackmanagement;

import java.time.LocalTime;

/**
 * Evening Session which includes break event (i.e Talk) 
 * @author vijay
 *
 */
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
