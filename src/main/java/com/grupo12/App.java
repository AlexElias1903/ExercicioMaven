package com.grupo12;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
  
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
    public List<Veiculo> veiculos;

    public static void main(String[] args) throws IOException {
        veiculos = new LinkedList<>();
        try (
            Reader veiculoPasseio = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH+"veiculoPasseio.csv"));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);

            Reader veiculoPassageiro = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH+"veiculoPassageiro.csv"));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);

            Reader veiculoUtilitario = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH+"veiculoUtilitario.csv"));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        ) {
            for (CSVRecord csvRecord : veiculoPasseio) {
                // Accessing Values by Column Index
                String placa = csvRecord.get(0);
                String marca = csvRecord.get(1);
                String modelo = csvRecord.get(2);
                Integer ano = Integer(csvRecord.get(3));
                Double valor = Double(csvRecord.get(4));
                Integer nroPass = Integer(csvRecord.get(4));

                veiculos.add(new VeiculoPasseio(placa, marca, modelo, ano, valor, nroPass));
            }
        }
    }
}