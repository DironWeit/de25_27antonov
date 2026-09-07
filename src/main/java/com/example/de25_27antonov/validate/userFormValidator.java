package com.example.de25_27antonov.validate;

import com.example.de25_27antonov.model.UserForm;

import java.util.regex.Pattern;

public class userFormValidator {

    private static final Pattern  NAME_PATTERN = Pattern.compile("^[А-Яф-яA-Za-z\\s]{1,40}$");


    public validationResult validate(UserForm form){

        validationResult result = new validationResult();

        if(form == null){
            result.addErrors("form", "Форма не должна быть null");
            return result;
        }

        if (form.getName().length() <= 10 || !NAME_PATTERN.matcher(form.getName()).matches()) {
            result.addErrors("name", "Строка, не боле 40 симв, без спец символов");
            return result;
        }

        if (form.getbusday().length()<=7) {
            result.addErrors("busday", "busday не должно быть пустым");
            return result;
        }

        if (form.getphone().length()<=10) {
            result.addErrors("phone", "phone не должно быть пустым");
            return result;
        }

        if (form.getInn().length()<=10) {
            result.addErrors("inn", "inn не должно быть пустым");
            return result;
        }

        if (form.getPasport().length()<=8) {
            result.addErrors("pasport", "pasport не должно быть пустым");
            return result;
        }

        if (form.getEmail().length()<=7) {
            result.addErrors("email", "email не должно быть пустым");
            return result;
        }

        return result;
    }
}
