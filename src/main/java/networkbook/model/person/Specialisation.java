package networkbook.model.person;

import static java.util.Objects.requireNonNull;
import static networkbook.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's specialisation in the network book.
 * Guarantees: immutable; is valid as declared in {@link #isValidSpecialisation(String)}
 */
public class Specialisation {

    public static final String MESSAGE_CONSTRAINTS = "Specialisations can take any values, and it should not be blank.";

    /*
     * The first character of the specialisation must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[^\\s].*";

    public final String value;

    /**
     * Constructs an {@code Course}.
     *
     * @param specialisation A valid specialisation.
     */
    public Specialisation(String specialisation) {
        requireNonNull(specialisation);
        checkArgument(isValidSpecialisation(specialisation), MESSAGE_CONSTRAINTS);
        value = specialisation;
    }

    /**
     * Returns true if a given string is a valid course.
     */
    public static boolean isValidSpecialisation(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Specialisation)) {
            return false;
        }

        Specialisation otherSpecialisation = (Specialisation) other;
        return value.equals(otherSpecialisation.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
