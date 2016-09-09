package org.trackmanagement;

import java.time.LocalTime;

public class Talk {
	
	private LocalTime startTime;
	private boolean scheduled;
	
	private String title;
	private int duration;
	
	
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
