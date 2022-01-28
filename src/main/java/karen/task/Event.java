package karen.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Stores the (/at) date in which the Event occurs at
 */
public class Event extends Task{
    protected LocalDate at;

    public Event(String description, String at) {
        super(description);
        this.at = this.parseDate(at);
    }

    @Override
    public String toSaveData() {
        return String.format("E|%s|%s|%s", this.isDone, this.description, this.at);
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + this.at.format(DateTimeFormatter.ofPattern("d MMM yyyy")) + ")";
    }
}
