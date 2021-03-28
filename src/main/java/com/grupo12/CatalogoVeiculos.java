import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CatalogoVeiculos{
    public List<Veiculo> veiculos;

    
    CatalogoVeiculos(){
        veiculos = new LinkedList<>();
        veiculos.add(new VeiculoPassageiro("ABC-1510", "Toyota", "Gol",2020, 20000.000, 5));
        veiculos.add(new VeiculoPassageiro("AGE-0051", "Volkswagen ", "Fox",2011, 45000.000, 6));
        veiculos.add(new VeiculoPassageiro("AKC-1512", "Ford", "Uno",2015, 15000.000, 7));
        veiculos.add(new VeiculoPassageiro("ICJ-1350", "Honda ", "Palio",2021, 25000.000, 5));

        veiculos.add(new VeiculoPasseio("LSO-4890", "Nissan", "Gol",2020, 200000.000, 10.0));
        veiculos.add(new VeiculoPasseio("VPQ-4156", "Hyundai", "Voyage",2011, 45000.000, 25.0));
        veiculos.add(new VeiculoPasseio("BDS-4841", "Chevrolet", "HB20",2020, 13000.000, 30.0));
        veiculos.add(new VeiculoPasseio("QPS-4800", "Kia", "Palio",2016, 35000.000, 15.0));

        veiculos.add(new VeiculoUtilitario("KDD-1200", "Mercedes", "Palio",2012, 30000.000, 20,4));
        veiculos.add(new VeiculoUtilitario("CKI-5619", "Bmw", "Celta",2009, 15000.000, 10,2));
        veiculos.add(new VeiculoUtilitario("BUQ-4105", "Ford", "Siena",2018, 25000.000, 15,3));
        veiculos.add(new VeiculoUtilitario("KBP-0458", "Honda", "Voyage",2020, 100000.000, 11,5));
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