public class VeiculoPassageiro implements Veiculo {
    private String placa;
    private String marca;
    private String modelo;
    private Integer ano;
    private Double valor;
    private Integer nroPass;

    public VeiculoPassageiro(String placa, String marca, String modelo, Integer ano, Double valor, Integer nroPass) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.valor = valor;
        this.nroPass = nroPass;
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
                + " Numero de passageiros " + nroPass;
        return aux;
    }
}
