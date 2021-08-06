package br.com.addario.cadastroveiculo.model.exceptions;

public class MarcaNotFoundException extends RuntimeException {
    public MarcaNotFoundException(String marcaString) {
        super(String.format("Marca %s não encontrada. Verifique se o nome da marca foi digitada direito.", marcaString));
    }
}
