import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Event extends Task {
    private LocalDateTime from;
    private LocalDateTime to;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MMM d yyyy, HH:mm");
    private static final DateTimeFormatter PARSER = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");

    public Event(String desc, String from, String to) {
        super(desc);
        this.from =  LocalDateTime.parse(from.trim(), PARSER);
        this.to = LocalDateTime.parse(to.trim(), PARSER);
    }

    public LocalDateTime getFrom() {
        return this.from;
    }

    public LocalDateTime getTo() {
        return this.to;
    }

    public String getFromString() {
        return this.from.format(PARSER);
    }

    public String getToString() {
        return this.to.format(PARSER);
    }

    @Override
    public String toString() {
        String status = this.isDone ? "[E][X] " : "[E][ ] ";
        return status + this.description.trim() + " (from: " + from.format(FORMATTER) + " to: " + to.format(FORMATTER) + ")";
    }
}
