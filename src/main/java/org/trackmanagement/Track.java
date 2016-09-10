package org.trackmanagement;

import java.util.List;

/**
 * Track object holds details about all talks including lunch/networking breaks. 
 * @author vijay
 *
 */
public class Track {
	
	private String trackName;
	private List<Talk> talks;
	
	
	public Track(String trackName) {
		this.trackName = trackName;
	}

	public String getTrackName() {
		return trackName;
	}

	public List<Talk> getTalks() {
		return talks;
	}

	public void setTalks(List<Talk> talks) {
		this.talks = talks;
	}
}
