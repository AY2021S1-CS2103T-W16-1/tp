package seedu.address.logic.scheduler;

import java.time.LocalDateTime;
import java.util.TimerTask;

import seedu.address.logic.Logic;
import seedu.address.model.meeting.Meeting;

public abstract class ScheduledTask extends TimerTask {

    protected final Meeting meeting;
    protected final Scheduler scheduler;
    protected final Logic logic;
    protected final String name;

    /**
     * Constructor of {@code ScheduledTask}.
     */
    public ScheduledTask(Scheduler scheduler, Logic logic, String name) {
        super();
        this.scheduler = scheduler;
        this.logic = logic;
        this.meeting = this.logic.getFirstFutureMeeting();
        this.name = name;
    }

    abstract Meeting getMeeting();

    abstract LocalDateTime getTaskTime();
}