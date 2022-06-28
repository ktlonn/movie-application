package com.techelevator.imdbmovie.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Movie already exists in favorites.")
public class MovieAlreadyExistsException extends RuntimeException{

}
