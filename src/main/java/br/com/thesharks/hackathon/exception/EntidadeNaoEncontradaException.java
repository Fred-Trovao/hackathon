package br.com.thesharks.hackathon.exception;

public class EntidadeNaoEncontradaException extends RuntimeException{

	public EntidadeNaoEncontradaException(String format) {
		super(format);
	}

	private static final long serialVersionUID = 3536684653346261025L;
	
}
