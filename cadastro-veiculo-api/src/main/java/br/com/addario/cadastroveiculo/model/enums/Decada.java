package br.com.addario.cadastroveiculo.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum Decada {
    D10(1910),
    D20(1920),
    D30(1930),
    D40(1940),
    D50(1950),
    D60(1960),
    D70(1970),
    D80(1980),
    D90(1990),
    D2000(2000),
    D2010(2010),
    D2020(2020);

    private int ano;

    public static Decada fromAno(int ano) {
        return Arrays
                .stream(Decada.values())
                .filter(decada -> ano == decada.getAno()).findFirst().orElse(null);
    }
}
