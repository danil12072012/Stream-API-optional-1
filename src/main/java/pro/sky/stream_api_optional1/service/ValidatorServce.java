package pro.sky.stream_api_optional1.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.stream_api_optional1.exeption.IncorrectNameExeption;
import pro.sky.stream_api_optional1.exeption.IncorrectPatronymicExeption;
import pro.sky.stream_api_optional1.exeption.IncorrectSurnameExeption;

@Service
public class ValidatorServce {
    public String ValidateName (String nameEmployee) {
        if (StringUtils.isAlpha(nameEmployee)) {
            throw new IncorrectNameExeption();
        }
        return StringUtils.capitalize(nameEmployee.toLowerCase());

    }
    public String ValidateSurname (String surnameEmployee) {
        if (StringUtils.isAlpha(surnameEmployee)) {
            throw new IncorrectSurnameExeption();
        }
        return StringUtils.capitalize(surnameEmployee.toLowerCase());

    }
    public String ValidatePatronymic (String patronymicEmployee) {
        if (StringUtils.isAlpha(patronymicEmployee)) {
            throw new IncorrectPatronymicExeption();
        }
        return StringUtils.capitalize(patronymicEmployee.toLowerCase());

    }
}
