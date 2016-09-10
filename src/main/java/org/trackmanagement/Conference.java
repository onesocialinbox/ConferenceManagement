package org.trackmanagement;

import java.util.ArrayList;
import java.util.List;

/**
 * Conference Domain object which holds all tracks
 * @author vijay
 *
 */
public class Conference {
	private List<Track> tracks = new ArrayList<Track>();
	
	public void addTrack(Track track) {
		tracks.add(track);
	}

	public List<Track> getTracks() {
		return tracks;
	}
	
	
}
