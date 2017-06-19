package com.mich.fedorapp.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mich.fedorbackend.dto.Books;

public class BookValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Books.class.equals(clazz);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub

	}

}
