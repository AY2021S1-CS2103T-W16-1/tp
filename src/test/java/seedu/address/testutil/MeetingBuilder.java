package seedu.address.testutil;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import seedu.address.model.meeting.DateTime;
import seedu.address.model.meeting.Duration;
import seedu.address.model.meeting.Location;
import seedu.address.model.meeting.Meeting;
import seedu.address.model.meeting.Recurrence;
import seedu.address.model.meeting.Title;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Meeting objects.
 */
public class MeetingBuilder {

    public static final String DEFAULT_TITLE = "Alice Pauline";
    public static final long DEFAULT_HOURS = 1;
    public static final long DEFAULT_MINUTES = 30;
    public static final String DEFAULT_LOCATION = "123, Jurong West Ave 6, #08-111";
    public static final String DEFAULT_DATETIME = "12/2/12 1201";
    public static final String DEFAULT_RECURRENCE = "";

    private Title title;
    private DateTime dateTime;
    private Duration duration;
    private Location location;
    private Set<UUID> participants = new HashSet<>();
    private Recurrence recurrence;

    /**
     * Creates a {@code MeetingBuilder} with the default details.
     */
    public MeetingBuilder() {
        title = new Title(DEFAULT_TITLE);
        duration = new Duration(DEFAULT_HOURS, DEFAULT_MINUTES);
        dateTime = new DateTime(DEFAULT_DATETIME);
        location = new Location(DEFAULT_LOCATION);
        recurrence = Recurrence.ofNullable(DEFAULT_RECURRENCE);
        participants = new HashSet<>();
    }

    /**
     * Initializes the MeetingBuilder with the data of {@code meetingToCopy}.
     */
    public MeetingBuilder(Meeting meetingToCopy) {
        title = meetingToCopy.getTitle();
        duration = meetingToCopy.getDuration();
        dateTime = meetingToCopy.getDateTime();
        location = meetingToCopy.getLocation();
        recurrence = meetingToCopy.getRecurrence();
        participants = new HashSet<>(meetingToCopy.getParticipants());
    }

    /**
     * Sets the {@code Title} of the {@code Meeting} that we are building.
     */
    public MeetingBuilder withTitle(String title) {
        this.title = new Title(title);
        return this;
    }

    /**
     * Parses the {@code participants} into a {@code Set<Tag>} and set it to the {@code Meeting} that we are building.
     */
    public MeetingBuilder withParticipants(UUID ... participants) {
        this.participants = SampleDataUtil.getParticipantSet(participants);
        return this;
    }

    /**
     * Sets the {@code Location} of the {@code Meeting} that we are building.
     */
    public MeetingBuilder withLocation(String address) {
        this.location = new Location(address);
        return this;
    }

    /**
     * Sets the {@code Duration} of the {@code Meeting} that we are building.
     */
    public MeetingBuilder withDuration(Duration duration) {
        this.duration = duration;
        return this;
    }

    /**
     * Sets the {@code DateTime} of the {@code Meeting} that we are building.
     */
    public MeetingBuilder withDateTime(String dateTime) {
        this.dateTime = new DateTime(dateTime);
        return this;
    }

    /**
     * Sets the {@code DateTime} of the {@code Meeting} that we are building.
     */
    public MeetingBuilder withRecurrence(String recurrence) {
        this.recurrence = Recurrence.ofNullable(recurrence);
        return this;
    }

    public Meeting build() {
        return new Meeting(title, duration, dateTime, location, recurrence, participants);
    }

}
