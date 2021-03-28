package com.grupo12;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CatalogoVeiculos{
    public List<Veiculo> veiculos;

    
    CatalogoVeiculos(List<Veiculo> veiculos){
        this.veiculos = veiculos;
    }
    public void consultaPorPlaca(String placa){
        List<Veiculo> veiculosPlaca=new LinkedList<>();
        veiculosPlaca= veiculos.stream().filter(c ->c.getPlaca().equals(placa)).collect(Collectors.toList());
        for (Veiculo veiculo : veiculosPlaca) {
            System.out.println(veiculo);
        }
    }

    public void consultaPorMarca(String marca){
        List<Veiculo> veiculosMarca=new LinkedList<>();
        veiculosMarca= veiculos.stream().filter(c ->c.getMarca().equals(marca)).collect(Collectors.toList());
        for (Veiculo veiculo : veiculosMarca) {
            System.out.println(veiculo);
        }
    }

    public void consultaPorAno(int ano){
        List<Veiculo> veiculosAno=new LinkedList<>();
        veiculosAno= veiculos.stream().filter(c ->c.getAno().equals(ano)).collect(Collectors.toList());
        for (Veiculo veiculo : veiculosAno) {
            System.out.println(veiculo);
        }
    }
    
    public void consultaPorTipo(String tipo){
        List<Veiculo> veiculosTipo=new LinkedList<>();
        if(tipo.equals("VeiculoPassageiro")){
            veiculosTipo=veiculos.stream().filter(c-> c instanceof VeiculoPassageiro).collect(Collectors.toList());
        }
        else if(tipo.equals("VeiculoPasseio")){
            veiculosTipo=veiculos.stream().filter(c-> c instanceof VeiculoPasseio).collect(Collectors.toList());
        }
        else if(tipo.equals("VeiculoUtilitario")){
            veiculosTipo=veiculos.stream().filter(c-> c instanceof VeiculoUtilitario).collect(Collectors.toList());
        }
        for (Veiculo veiculo : veiculosTipo) {
            System.out.println(veiculo);
        }
    }
    
}