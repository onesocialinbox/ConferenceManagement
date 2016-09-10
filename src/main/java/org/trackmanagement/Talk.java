package org.trackmanagement;

import java.time.LocalTime;

/**
 * Each presentation topic is represented as talk. 
 * Also break events (lunch/networking) are considered as talk
 * @author vijay
 */
public class Talk {
	
	private LocalTime startTime;
	private String title;
	private int duration;

	//Flag to test if the talk is scheduled
	private boolean scheduled;
	
	public Talk(String title, int duration) {
		this.title = title;
		this.duration = duration;
	}
	

	public LocalTime getStartTime() {
		return startTime;
	}

	public String getTitle() {
		return title;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public long getDuration() {
		return duration;
	}

	public boolean isScheduled() {
		return scheduled;
	}


	public void setScheduled(boolean scheduled) {
		this.scheduled = scheduled;
	}
	

}
