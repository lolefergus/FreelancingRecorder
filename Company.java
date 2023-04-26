import java.util.List;

/**
 * Represnts a company
 */
public class Company {
    private String name;
    private String email;
    private String address;
    private List<Session> sessions;
    private List<SessionType> sessionTypes;

    /**
     * Creates basic company
     * @param name Company name
     */
    public Company(String name){
        this.name = name;
    }

    /**
     * Creates full company - required for invoices
     * @param name Company name
     * @param email Company email
     * @param address Address of company headquarters 
     */
    public Company(String name, String email, String address){
        this.name = name;
        this.email = email;
        this.address = address;
    }

    /**
     * Getter method for company name
     * @return Company name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for company sessions
     * @return Array of sessions
     */
    public Session[] getSessions() {
        return (Session[]) sessions.toArray();
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * Adds a session type for the company
     * @param sessionType Session type to add
     * @throws SessionException
     */
    public void addSessionType(SessionType sessionType) throws SessionException {
        if (!sessionTypes.contains(sessionType)){
            sessionTypes.add(sessionType);
        }
        else{
            throw new SessionException("This session type already exists");
        }
    }

    /**
     * Adds session to session list
     * 
     */
    public void addSession(SessionType type, String date, String description){
        sessions.add(new Session(type, date, description));
    }
}
