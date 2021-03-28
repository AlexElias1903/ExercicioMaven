package com.grupo12;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/*
Exemplo simples de uso da API Apache Commons CVS
Extrair o arquivo commons-csv-1.7.jar para o diretorio do projeto
Para compilar no Windows: javac -cp .;.\commons-csv-1.7.jar App.java
Para compilar no Linux: javac -cp commons-csv-1.7.jar App.java
Para executar no windows: java -cp .;.\commons-csv-1.7.jar App
Para executar no Linux: java -cp .:commons-csv-1.7.jar App
Para executar: java -cp .;.\commons-csv-1.7.jar App.java
*/
public class App {
    private static final String SAMPLE_CSV_FILE_PATH = "../src/main/java/com/grupo12/";
    public static List<Veiculo> veiculos;

    public static void main(String[] args) throws IOException {
        veiculos = new LinkedList<>();
        try (Reader veiculoPasseio = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH + "veiculoPasseio.csv"));
                CSVParser veiculoPasseioCSV = new CSVParser(veiculoPasseio, CSVFormat.DEFAULT);

                Reader veiculoPassageiro = Files
                        .newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH + "veiculoPassageiro.csv"));
                CSVParser veiculoPassageiroCSV = new CSVParser(veiculoPassageiro, CSVFormat.DEFAULT);

                Reader veiculoUtilitario = Files
                        .newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH + "veiculoUtilitario.csv"));
                CSVParser veiculoUtilitarioCSV = new CSVParser(veiculoUtilitario, CSVFormat.DEFAULT);) {
            for (CSVRecord csvRecord : veiculoPassageiroCSV) {
                if (csvRecord.getRecordNumber() >= 2) {
                    // Accessing Values by Column Index
                    String placa = csvRecord.get(0);
                    String marca = csvRecord.get(1);
                    String modelo = csvRecord.get(2);
                    Integer ano = new Integer(csvRecord.get(3));
                    Double valor = new Double(csvRecord.get(4));
                    Integer nroPass = new Integer(csvRecord.get(5));

                    veiculos.add(new VeiculoPassageiro(placa, marca, modelo, ano, valor, nroPass));
                }
            }

            for (CSVRecord csvRecord : veiculoPasseioCSV) {
                if (csvRecord.getRecordNumber() >= 2) {
                    // Accessing Values by Column Index
                    String placa = csvRecord.get(0);
                    String marca = csvRecord.get(1);
                    String modelo = csvRecord.get(2);
                    Integer ano = new Integer(csvRecord.get(3));
                    Double valor = new Double(csvRecord.get(4));
                    Double consumoKmLt = new Double(csvRecord.get(5));

                    veiculos.add(new VeiculoPasseio(placa, marca, modelo, ano, valor, consumoKmLt));
                }
            }

            for (CSVRecord csvRecord : veiculoUtilitarioCSV) {
                if (csvRecord.getRecordNumber() >= 2) {
                    // Accessing Values by Column Index
                    String placa = csvRecord.get(0);
                    String marca = csvRecord.get(1);
                    String modelo = csvRecord.get(2);
                    Integer ano = new Integer(csvRecord.get(3));
                    Double valor = new Double(csvRecord.get(4));
                    Integer capCargaTon = new Integer(csvRecord.get(5));
                    Integer numEixos = new Integer(csvRecord.get(6));

                    veiculos.add(new VeiculoUtilitario(placa, marca, modelo, ano, valor, capCargaTon, numEixos));
                }
            }
        }
        CatalogoVeiculos c = new CatalogoVeiculos(veiculos);
        Scanner menu = new Scanner(System.in);

        while (true) {
            System.out.println("\n\n### Sistema de busca de veiculos ###");
            System.out.println("\n                  ==============================");
            System.out.println("                  |     1 - Busca por placa       |");
            System.out.println("                  |     2 - Busca por Marca       |");
            System.out.println("                  |     3 - Busca por Ano         |");
            System.out.println("                  |     4 - Busca por Tipo        |");
            System.out.println("                  |     0 - Sair                  |");
            System.out.println("                  ================================\n");

            int opcao = Integer.parseInt(menu.nextLine());

            if (opcao == 0) {
                return;
            }

            switch (opcao) {
            case 1:
                System.out.println("Informe a placa");
                String placa = menu.nextLine();
                c.consultaPorPlaca(placa);
                break;
            case 2:
                System.out.println("Informe a marca");
                String marca = menu.nextLine();
                c.consultaPorMarca(marca);
                break;
            case 3:
                System.out.println("Informe a Ano");
                String Ano = menu.nextLine();
                c.consultaPorAno(Integer.parseInt(Ano));
                break;
            case 4:
                System.out.println("\n\n### Informe o tipo ###");
                System.out.println("\n                  ====================================");
                System.out.println("                  |     1 - Veiculo de Passageiro       |");
                System.out.println("                  |     2 - Veiculo de Passeio          |");
                System.out.println("                  |     3 - Veiculo Utilitario          |");
                System.out.println("                  =======================================\n");
                String tipo = menu.nextLine();
                if (tipo.equals("1")) {
                    c.consultaPorTipo("VeiculoPassageiro");
                } else if (tipo.equals("2")) {
                    c.consultaPorTipo("VeiculoPasseio");
                } else if (tipo.equals("3")) {
                    c.consultaPorTipo("VeiculoUtilitario");
                }
                break;
            default:
                System.out.println("Opcao invalida!");
                break;
            }
            System.out.println("Insira uma digito para continuar as buscas");
            String continuar = menu.nextLine();
        }
    }
}