import java.util.List;

/**
 * Represents a company
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
     * @throws CompanyException if there's an invalid parameter
     * @todo create proper name validation
     */
    public Company(String name) throws CompanyException{
        if(name.isEmpty()){
            throw new CompanyException("Invalid Name");
        }
        this.name = name;
    }

    /**
     * Creates full company - required for invoices
     * @param name Company name
     * @param email Company email
     * @param address Address of company headquarters
     * @throws CompanyException if there's an invalid parameter
     * @todo create proper name, email and address validation
     */
    public Company(String name, String email, String address) throws CompanyException{
        if(name.isEmpty() || email.isEmpty() || address.isEmpty()){
            throw new CompanyException("Invalid Details");
        }
        this.name = name;
        this.email = email;
        this.address = address;
    }

    /**
     * Getter method for company name
     * @return Company name
     * @throws CompanyException if there's an invalid parameter
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for company sessions
     * @return Array of sessions
     */
    public List<Session> getSessions() {
        return sessions;
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

    /**
     * Prints company info to console
     */
    public void display() {
        System.out.println(Driver.div+"\nCompany - "+name+"\n"+Driver.div);
        if (email == null){
            System.out.println("Invoicing not available");
        }
        else{
            System.out.println("Invoicing available");
            System.out.println("Email: " + email);
            System.out.println("Address: "+ address);
        }
        if (sessionTypes == null){
            System.out.println("0 registered session types");
        }
        else{
            System.out.println(sessionTypes.size() + " registered session types");
        }
        if (sessions == null){
            System.out.println("0 recorded sessions");
        }
        else{
            System.out.println(sessions.size() + " recorded sessions");
        }
    }
}
