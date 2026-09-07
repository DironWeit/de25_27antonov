package com.example.de25_27antonov.validate;

import java.util.HashMap;
import java.util.Map;

public class validationResult {
    private final Map<String, String> errors = new HashMap<>();

    public void addErrors(String fileName, String errorsMessage) {
        errors.put(fileName, errorsMessage);
    }

    public boolean isValid() {
        return  errors.isEmpty();
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public String getError(String fielName) {
        return errors.get(fielName);
    }
}
