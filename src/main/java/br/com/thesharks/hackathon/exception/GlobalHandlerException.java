package br.com.thesharks.hackathon.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandlerException {

	private static final Logger logger = LoggerFactory.getLogger(GlobalHandlerException.class);

	@ExceptionHandler(Exception.class)
	public void exception(Exception e) {
		logger.debug("Ocorreu um erro inesperado.");

	}

}
