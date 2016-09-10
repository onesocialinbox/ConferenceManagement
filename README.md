# ConferenceManagement

Conference Talk event planner system. 

As per the problem definition, 
- The `Conference` has multiple `Track`(s).
- Each `Track` has title and multiple `Talk`(s). 
- Each `Session` has two types  `MorningSession` and `EveningSession` which defines session start time and end time (9-12 morning and 1-5 evening)

 
- `ConferenceManagementApp.java` is the main start application. 
- `AllTests.java` is Junit suite class to run all tests.

#Prerequisites
- Java 8
- Maven (optional)


#To Run 
### Bundled sample input
- From command line : mvn clean package exec:java
- From Eclipse IDE: `ConferenceManagementApp.java`. Run As -> Java application

### External sample input with Command line argument
- From command line : mvn clean package exec:java exec.args="`<<AbsoulteFileName>>`"
- From Eclipse IDE: `ConferenceManagementApp.java`. Run As -> Java application pass in `<<AbsoluteFileName>>` as program argument.

Eg. `<<AbsoluteFileName>>` 
 - /tmp/testInput.txt
 - c:/testInput.txt


# Assumptions/Improvements:
- This program doesn't find optimized talk schedules (i.e without too much spare time). As it is not specified in spec. :). Sometimes, the same talks can span over different tracks. 
- As per my understanding the networking event should start at 5pm or earlier regardless of the last event endtime. Because in spec output its mentioned 5pm as networking event even though the program ends earlier. 
- If there are fewer talks in a track and ends earlier in the morning session, it is still assumes Lunch and networking event is at fixed time.
- Assumes the input format is fixed as per the sample input. (ie. last word always has talk duration)
- No input validity checks or many error handling are done for the current scope. 