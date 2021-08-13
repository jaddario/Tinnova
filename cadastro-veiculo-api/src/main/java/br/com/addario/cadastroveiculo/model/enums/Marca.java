package br.com.addario.cadastroveiculo.model.enums;

import br.com.addario.cadastroveiculo.model.exceptions.MarcaNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum Marca {
    ABARTH("abarth"),
    ALFA_ROMEO("alfa romeo"),
    ALPINE("alpine"),
    ASTON_MARTIN("aston martin"),
    AUDI("audi"),
    BENTLEY("bentley"),
    BMW("bmw"),
    CITROEN("citroen"),
    CHEVROLET("chevrolet"),
    CUPRA("cupra"),
    DACIA("dacia"),
    DS("ds"),
    FERRARI("ferrari"),
    FIAT("fiat"),
    FORD("ford"),
    HONDA("honda"),
    HYUNDAI("hyunday"),
    JAGUAR("jaguar"),
    JEEP("jeep"),
    KIA("kia"),
    LAMBORGHINI("lamborghini"),
    LAND_ROVER("land rover"),
    LEXUS("lexus"),
    MASERATI("maserati"),
    MAZDA("mazda"),
    MERCEDES_BENZ("mercedes benz"),
    MG("mg"),
    MINI("mini"),
    MITSUBISHI("mitsubish"),
    NISSAN("nissan"),
    OPEL("opel"),
    PEUGEOT("pegout"),
    PORSCHE("porshe"),
    RENAULT("renault"),
    SEAT("seat"),
    SKODA("skoda"),
    SMART("smart"),
    SUZUKI("suzuki"),
    TESLA("tesla"),
    TOYOTA("toyota"),
    VOLKSWAGEN("wolkswagen"),
    VOLVO("volvo");

    private String marca;

    public static Marca fromName(String marcaString) {
        return Arrays.stream(Marca.values())
                .filter(marca -> marcaString.equals(marca.name()))
                .findFirst()
                .orElseThrow(() -> new MarcaNotFoundException(marcaString));
    }
}
