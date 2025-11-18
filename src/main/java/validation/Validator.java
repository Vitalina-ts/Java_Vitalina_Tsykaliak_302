public class Validator {
public static void validateNotEmpty(String value, String field, StringBuilder errors) {
if (value == null || value.isBlank()) {
errors.append(field).append(": cannot be empty; ");
}
}


public static void validatePositive(int value, String field, StringBuilder errors) {
if (value <= 0) {
errors.append(field).append(": must be > 0; ");
}
}


public static void validateRange(int value, int min, int max, String field, StringBuilder errors) {
if (value < min || value > max) {
errors.append(field).append(": must be between " + min + " and " + max + "; ");
}
}
}
