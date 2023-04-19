package com.webtoeic.validator;

import com.webtoeic.entities.NguoiDung;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class NguoiDungValidator implements Validator {



    @Override
    public boolean supports(Class<?> clazz) {
        return NguoiDung.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        NguoiDung user = (NguoiDung) target;

        ValidationUtils.rejectIfEmpty(errors, "email", "error.hoTen",  "Họ tên không được bỏ trống");
        ValidationUtils.rejectIfEmpty(errors,"soDienThoai", "error.soDienThoai","Số điện thoại không được bỏ trốn");
    }
}
