package com.consultasestudiantes.validator;

public interface Validator<T> {
    void validate(T object);
}
