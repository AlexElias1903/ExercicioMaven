package com.grupo12;
public class VeiculoPasseio implements Veiculo {
    private String placa;
    private String marca;
    private String modelo;
    private Integer ano;
    private Double valor;
    private Double consumoKmLt;

    public VeiculoPasseio(String placa, String marca, String modelo, Integer ano, Double valor, Double consumoKmLt) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.valor = valor;
        this.consumoKmLt = consumoKmLt;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public Integer getAno() {
        return ano;
    }

    @Override
    public String toString() {
        String aux = "Placa: " + placa + " Marca: " + marca + " Modelo: " + modelo + " Ano: " + ano + " Valor: " + valor
                + " Consumo Km/litro: " + consumoKmLt;
        return aux;
    }

}
