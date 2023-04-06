import java.util.List;

public class Company {
    private String name;
    private String email;
    private String address;
    private List<Shift> shifts;
    private List<Session> sessions;

    public Company(String name){
        this.name = name;
    }

    public Company(String name, String email, String address){
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Shift[] getShifts() {
        return (Shift[]) shifts.toArray();
    }

    @Override
    public String toString() {
        return name;
    }

    public void addSession(Session session) throws SessionException {
        if (!sessions.contains(session)){
            sessions.add(session);
        }
        else{
            throw new SessionException("Session already exists");
        }
    }
}
