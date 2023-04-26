import java.util.Objects;

/**
 * Represents types of session that a company runs
 */
public class SessionType {
    private String name;
    private int duration;
    private int pay;
    private String description;

    /**
     * Creates a basic session type instance
     * @param type Name of the session
     * @param pay Payment for session
     * @throws SessionException
     */
    public SessionType(String type, int pay) throws SessionException {
        this.name = type;
        this.pay = validatePay(pay);
    }

    /**
     * Creates a full session type
     * @param type Name of session
     * @param pay Payment for session
     * @param duration Duration of session
     * @param description Description of what session entails
     * @throws SessionException
     */
    public SessionType(String type, int pay, int duration, String description) throws SessionException {
        this.name = type;
        this.pay = validatePay(pay);
        this.duration = validatePay(duration); //reuses validate pay method as no extra requirements
        this.description = description;
    }

    /**
     * Validates pay
     * @param pay
     * @return valid pay amount
     * @throws SessionException
     * @todo remove, unesacery
     */
    private int validatePay(int pay) throws SessionException {
        if (pay < 0) {
            throw new SessionException("Pay or Duration cannot be less than Zero");
        }
        return pay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SessionType session = (SessionType) o;
        return name.equals(session.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
