package org.trackmenagement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.trackmanagement.Conference;
import org.trackmanagement.Talk;
import org.trackmanagement.Track;
import org.trackmanagement.TrackConfiguration;
import org.trackmanagement.TrackOrganizer;

public class EventsTimeTest {

	private Conference scheduledConference;
	@Before
	public void setup() {
		List<Talk> sampleTalks = loadSampleTalks();
		scheduledConference = TrackOrganizer.organizeTalks(sampleTalks);
	}

	@Test
	public void testTracksCount() {
		List<Track> allTracks = scheduledConference.getTracks();
		assertEquals("Track count doesn't match", 2, allTracks.size());
	}

	@Test
	public void testTalksCount() {
		List<Track> allTracks = scheduledConference.getTracks();
		int totalTalksCount = 0;
		for (Track track : allTracks) {
			totalTalksCount += track.getTalks().size();
		}
		int totalEventsCount = 19 + 2 + 2; // talks, lunch, networking
		assertEquals("Talks count doesn't match", totalEventsCount, totalTalksCount);
	}

	@Test
	public void testLunchNetworkingEventOnTime() {
		List<Track> allTracks = scheduledConference.getTracks();
		for (Track track : allTracks) {
			checkTrackStartTime(track);
			checkBreakEventsPresent(track);
			checkBreakEventsOnTime(track);

		}

	}

	private void checkTrackStartTime(Track track) {
		LocalTime firstTalkStartTime = track.getTalks().get(0).getStartTime();
		assertTrue("Track Start time not at 9", firstTalkStartTime.compareTo(TrackConfiguration.trackStartTime) ==0);
	}

	private void checkBreakEventsPresent(Track track) {
		List<Talk> talks = track.getTalks();
		final String networkingTitle = "Networking Event";
		final String lunchTitle = "Lunch Event";
		
		Optional<Talk> networkingEvent = talks.stream().filter(talk -> {
			return talk.getTitle().equals(networkingTitle);
		}).findAny();
		Optional<Talk> lunchEvent = talks.stream().filter(talk -> {
			return talk.getTitle().equals(lunchTitle);
		}).findAny();
		assertTrue(networkingTitle + " is not present", networkingEvent.isPresent());
		assertTrue(lunchTitle + " is not present", lunchEvent.isPresent());
		

	}
	private void checkBreakEventsOnTime(Track track) {
		List<Talk> talks = track.getTalks();
		final String networkingTitle = "Networking Event";
		checkNetworkingTime(talks, networkingTitle, TrackConfiguration.trackCutOffTime, TrackConfiguration.networkingMaxCutOffTime);

		final String lunchTitle = "Lunch Event";
		checkLunchTime(talks, lunchTitle, TrackConfiguration.lunchTime);
		
	}

	private void checkNetworkingTime(List<Talk> talks, final String networkingTitle, LocalTime four, LocalTime five) {
		Optional<Talk> networkingEvent = talks.stream().filter(talk -> {
			return talk.getTitle().equals(networkingTitle);
		}).findAny();
		LocalTime eventStartTime = networkingEvent.get().getStartTime();
		assertTrue(networkingTitle +" time is before four", eventStartTime.isAfter(four ));
		assertTrue(networkingTitle +" time is after five", eventStartTime.compareTo(five) <=0);
	}

	private void checkLunchTime(List<Talk> talks, final String title, LocalTime noon) {
		Optional<Talk> lunchEvent = talks.stream().filter(talk -> {
			return talk.getTitle().equals(title);
		}).findAny();
		LocalTime eventStartTime = lunchEvent.get().getStartTime();
		assertTrue(title +" time incorrect", eventStartTime.compareTo(noon) ==0);
	}

	private List<Talk> loadSampleTalks() {
		List<Talk> talks = new ArrayList<Talk>();
		talks.add(new Talk("A World Without HackerNews", 30));
		talks.add(new Talk("Ruby Errors from Mismatched Gem Versions", 45));
		talks.add(new Talk("Common Ruby Errors", 45));
		talks.add(new Talk("Accounting-Driven Development", 45));
		talks.add(new Talk("Ruby vs. Clojure for Back-End Development", 30));
		talks.add(new Talk("Rails Magic", 60));
		talks.add(new Talk("Lua for the Masses", 30));
		talks.add(new Talk("Clojure Ate Scala (on my project)", 45));
		talks.add(new Talk("Communicating Over Distance", 60));
		talks.add(new Talk("Woah", 30));
		talks.add(new Talk("Sit Down and Write", 30));
		talks.add(new Talk("Writing Fast Tests Against Enterprise Rails", 60));
		talks.add(new Talk("Overdoing it in Python", 45));
		talks.add(new Talk("Pair Programg vs Noise", 45));
		talks.add(new Talk("Ruby on Rails: Why We Should Move On", 60));
		talks.add(new Talk("Programg in the Boondocks of Seattle", 30));
		talks.add(new Talk("Rails for Python Developers", 5));
		talks.add(new Talk("Ruby on Rails Legacy App Maintenance", 60));
		talks.add(new Talk("User Interface CSS in Rails Apps", 30));
		return talks;
	}

}
