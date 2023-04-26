import java.time.LocalDate;

/**
 * Represents a shift I've worked
 * @todo add getter classes
 */
public class Session {
    private SessionType type;
    private LocalDate date;
    private String notes;

    /**
     * Creates a new session
     * @param type Type of session to create
     * @param date Date the session was worked
     * @param notes Anything that should be rememberd about the session, e.g. river levels
     * @todo add input validation
     */
    public Session(SessionType type, LocalDate date, String notes){
        this.type = type;
        this.date = date;
        this.notes = notes;
    }

    /**
     * Creates a new session
     * @param type Type of session to create
     * @param date Date the session was worked
     * @param notes Anything that should be rememberd about the session, e.g. river levels
     * @todo add input validation
     */
    public Session(SessionType type, String date, String notes){
        this.type = type;
        this.date = LocalDate.parse(date);
        this.notes = notes;
    }

    /**
     * Getter method for session type
     * @return Session type
     */
    public SessionType getType(){
        return type;
    }
}
