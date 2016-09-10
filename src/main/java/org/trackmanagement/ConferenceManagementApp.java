package org.trackmanagement;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Conference Track Management main application.
 * @author vijay
 *
 */
public class ConferenceManagementApp {

	public static void main(String[] args) {
		
		String inputFile = getInputFileToSchedule(args);
		
		List<Talk> talkList = TalkFileReader.readTalksFromFile(inputFile);
		
		Conference conference = TrackOrganizer.organizeTalks(talkList);
		ConferenceDisplay.printConferenceDetails(conference);
	}

	private static String getInputFileToSchedule(String[] args) {
		String inputFile = TrackConfiguration.INPUTFILE;
		
		String externalInputFile = checkIfAnyArguments(args);
		if(externalInputFile != null) {
			inputFile = externalInputFile;
		} else {
			System.out.println("No external input or Invalid input/file not exists. Proceeding with bundled input..");
		}
		return inputFile;
	}

	private static String checkIfAnyArguments(String[] args) {
		if(args !=null && args.length == 1){
			String fileName = args[0];
			return new File(fileName).exists() ? fileName : null;
		}
		return null;
	}
}
