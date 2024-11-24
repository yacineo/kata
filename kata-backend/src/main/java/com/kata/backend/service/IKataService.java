package com.kata.backend.service;

import com.kata.backend.exception.CustomIllegalArgumentException;

public interface IKataService {

    String transformNumber(int number) throws CustomIllegalArgumentException;

}
