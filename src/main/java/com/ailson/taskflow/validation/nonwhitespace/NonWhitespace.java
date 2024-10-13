package com.ailson.taskflow.validation.nonwhitespace;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = NonWhitespaceValidator.class) // Classe que valida a anotação
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface NonWhitespace {
    String message() default "Não pode conter somente espaços vazios"; // default error message

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
