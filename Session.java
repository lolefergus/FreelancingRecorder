import java.util.Objects;

public class Session {
    private String name;
    private int duration;
    private int pay;
    private String description;

    public Session(String type, int pay) throws SessionException {
        this.name = type;
        this.pay = validatePay(pay);
    }

    public Session(String type, int pay, int duration, String description) throws SessionException {
        this.name = type;
        this.pay = validatePay(pay);
        this.duration = validatePay(duration); //reuses validate pay method as no extra requirements
        this.description = description;
    }

    private int validatePay(int pay) throws SessionException {
        if (pay < 0) {
            throw new SessionException("Pay cannot be less than Zero");
        }
        return pay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Session session = (Session) o;
        return name.equals(session.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
