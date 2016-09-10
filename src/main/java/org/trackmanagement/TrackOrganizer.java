package org.trackmanagement;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;

public class TrackOrganizer {

	public static Conference organizeTalks(List<Talk> talkList) {
		Conference conference = new Conference();
		List<Session> allSessions = TrackConfiguration.getAllSessions();
		ListIterator<Talk> listIterator = talkList.listIterator();
		int day = 1;
		while(listIterator.hasNext()) {
			Track track = new Track("Track "+ day);
			List<Talk> scheduledEvents = findScheduledEventsForTrack(talkList, allSessions);
			track.setTalks(scheduledEvents);
			day++;
			conference.addTrack(track);
		}
		return conference;
	}

	private static List<Talk> findScheduledEventsForTrack(List<Talk> talkList, List<Session> allSessions) {
		List<Talk> scheduledEvents = new ArrayList<Talk>();
		for (Session currentSession : allSessions) {
			talkList.forEach(allotTalksForSession(scheduledEvents, currentSession));
			talkList.removeIf(event -> event.isScheduled());
			scheduledEvents.add(currentSession.getBreakEvent());
		}
		return scheduledEvents;
	}

	public static Consumer<Talk> allotTalksForSession(List<Talk> scheduledEvents, Session currentSession) {
		return new Consumer<Talk>() {
			private LocalTime currentTrackTime = currentSession.getStartTime();
			@Override
			public void accept(Talk talk) {
				if(!talk.isScheduled()) {
					LocalTime tentativeEndTime = currentTrackTime.plusMinutes(talk.getDuration());
					if(currentSession.canScheduleTalk(talk, tentativeEndTime)) {
						talk.setStartTime(currentTrackTime);
						scheduledEvents.add(talk);
						talk.setScheduled(true);
						currentTrackTime = tentativeEndTime;
					}	
				}
			}
		};
	}

}
