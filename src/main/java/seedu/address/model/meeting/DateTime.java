package seedu.address.model.meeting;

import static java.util.Objects.requireNonNull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a Meeting's date and time.
 * Guarantee: immutable
 */
public class DateTime {

    public static final String MESSAGE_CONSTRAINTS = "The date and time should be of the format dd/mm/yy hhmm. "
            + "For example, 12/3/20 1545";

    private static DateTimeFormatter dateInputFormat = DateTimeFormatter.ofPattern("d/M/yy HHmm");
    private static DateTimeFormatter dateOutputFormat = DateTimeFormatter.ofPattern("dd MMM yyyy h.mma");

    public final LocalDateTime value;

    /**
     * Constructs an {@code DateTime}.
     *
     * @param dateTime A valid date and time.
     */
    public DateTime(LocalDateTime dateTime) {
        requireNonNull(dateTime);
        value = dateTime;
    }

    /**
     * Constructs an {@code DateTime}.
     *
     * @param dateTime A valid date and time.
     */
    public DateTime(String dateTime) {
        requireNonNull(dateTime);
        value = LocalDateTime.parse(dateTime, dateInputFormat);
    }

    /**
     * Return true if string can be formatted to a LocalDateTime object
     */
    public static boolean isValidDateTime(String dateTime) {
        LocalDateTime toCheck = LocalDateTime.parse(dateTime, dateInputFormat);
        return toCheck instanceof LocalDateTime;
    }

    public static DateTimeFormatter getDateInputFormat() {
        return dateInputFormat;
    }

    public static DateTimeFormatter getDateOutputFormat() {
        return dateOutputFormat;
    }

    @Override
    public String toString() {
        return value.format(dateOutputFormat);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DateTime // instanceof handles nulls
                && value.equals(((DateTime) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
