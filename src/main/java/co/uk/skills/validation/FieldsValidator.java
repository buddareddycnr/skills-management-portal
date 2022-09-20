package co.uk.skills.validation;

@FunctionalInterface
public interface FieldsValidator<T> {
    boolean isValidLength(T field);
}
