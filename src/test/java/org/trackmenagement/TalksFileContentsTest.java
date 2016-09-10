package org.trackmenagement;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.trackmanagement.Conference;
import org.trackmanagement.ConferenceDisplay;
import org.trackmanagement.Talk;
import org.trackmanagement.TalkFileReader;
import org.trackmanagement.TrackOrganizer;

@RunWith(Parameterized.class)
public class TalksFileContentsTest {

	private static final String TEST_PATH = "src/test/resources/";

	@Parameter
	public String inputFile;

	@Parameter(value = 1)
	public String expectedOutput;

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays
				.asList(new Object[][] { { "sampleInput.txt", "sampleOutput.txt" }, 
					{ "sampleInputReordered1.txt", "sampleOutputReordered1.txt" },
					{ "sampleInputReordered2.txt", "sampleOutputReordered2.txt" },
					{ "sampleInputFewTalks.txt", "sampleOutputFewTalks.txt" }});
	}

	@Test
	public void testTalksOutputContent() throws IOException {
		System.out.println("Testing for " + inputFile);
		List<Talk> talksList = TalkFileReader.readTalksFromFile(TEST_PATH + inputFile);
		Conference organizedConference = TrackOrganizer.organizeTalks(talksList);
		StringBuilder conferenceOutputFormat = ConferenceDisplay.buildConferenceOutputFormat(organizedConference);

		String fileContent = readFileContent();
		assertEquals("Conference Output is not same", fileContent, conferenceOutputFormat.toString());

	}

	private String readFileContent() throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(TEST_PATH + expectedOutput));
		return new String(encoded, Charset.defaultCharset());

	}
}