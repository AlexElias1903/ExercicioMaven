package com.grupo12;
public class VeiculoUtilitario implements Veiculo{
    private String placa;
    private String marca;
    private String modelo;
    private Integer ano;
    private Double valor;
    private Integer capCargaTon;
    private Integer numEixos;

    public VeiculoUtilitario(String placa, String marca, String modelo, Integer ano, Double valor, Integer capCargaTon,
            Integer numEixos) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.valor = valor;
        this.capCargaTon = capCargaTon;
        this.numEixos = numEixos;
    }

    @Override
    public String toString() {
        String aux = "Placa: " + placa + " Marca: " + marca + " Modelo: " + modelo + " Ano: " + ano + " Valor: " + valor
                + " Capacidade de carga: " + capCargaTon + " Num Eixos: " + numEixos;
        return aux;
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
}
