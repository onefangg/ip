package karen.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Abstract class to store description and status of Task
 */
public abstract class Task {
    protected boolean isDone;
    private String description;

    /**
     * Constructor for Task object
     *
     * @param inputDescription Description of what Task is for
     */
    public Task(String inputDescription) {
        setDescription(inputDescription);
        isDone = false;
    }

    /**
     * Sets done status of Task to true
     */
    public void markDone() {
        isDone = true;
    }

    /**
     * Sets done status of Task to false
     */
    public void markUndone() {
        isDone = false;
    }

    /**
     * Parses isDone attribute of Task object into a String representation.
     *
     * @return String representation of done attribute of Task
     */
    public String getDoneIcon () {
        return (isDone) ? "X" : " ";
    }

    /**
     * Sets description of Task.
     *
     * @param inputDescription New description of Task
     */
    public void setDescription(String inputDescription) {
        description = inputDescription;
    }

    /**
     * Gets description variable in Task
     *
     * @return Description of Task object
     */
    public String getDescription() {
        return description;
    }

    /**
     * Parses Task objects into a String object representation for writing to file.
     *
     * @return String representation of attributes or data related to Task for storage
     */
    public abstract String toSaveData();

    /**
     * Formats LocalDateTime object into string representation `yyyy-MM-dd HHmm`
     *
     * @param date input LocalDateTime object
     * @return Formatted LocalDateTime in string representation `yyyy-MM-dd HHmm`
     */
    public String formatDate(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
        return date.format(formatter);
    }

    /**
     * Returns String representation of Task object.
     *
     * For example: [X] example-task
     * @return String representation of Task object
     */
    @Override
    public String toString() {
        String status = this.getDoneIcon();
        return String.format("[%s] %s", status, this.getDescription());
    }
}
