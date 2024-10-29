package Enos.projectsApi.Fipe.main;

import Enos.projectsApi.Fipe.models.BrandsData;
import Enos.projectsApi.Fipe.models.FipeData;
import Enos.projectsApi.Fipe.models.ModelsData;
import Enos.projectsApi.Fipe.models.YearsData;
import Enos.projectsApi.Fipe.service.ConsumeAPI;
import Enos.projectsApi.Fipe.service.ConvertData;

import java.util.Comparator;
import java.util.Scanner;

public class Main {

    private final ConsumeAPI consumeAPI = new ConsumeAPI();
    private final ConvertData convertData = new ConvertData();

    public void showMenu(){
        int left = 0, vehicleType;
        String address;
        while (true){
            Scanner scan = new Scanner(System.in);
            System.out.println("1 - carro\n2 - moto\n3 - caminhão\n4 - sair\n");
            System.out.println("Escolha um tipo de veiculo para busca: ");
            vehicleType = scan.nextInt();
            address = "https://fipe.parallelum.com.br/api/v2/";
            switch (vehicleType) {
                case 1:
                    address += "cars/brands";
                    break;
                case 2:
                    address += "motorcycles/brands";
                    break;
                case 3:
                    address += "trucks/brands";
                    break;
                case 4:
                    left = 1;
                    break;
                default:
                    System.out.println("Opção Invalida");
                    break;
            }
            if (left == 1){
                break;
            }
            String json = consumeAPI.getData(address);
            var list = convertData.getDataList(json, BrandsData.class);
            list = list.stream().sorted(Comparator.comparingInt(BrandsData::code)).toList();
            list.forEach(value -> System.out.println("Code: " + value.code() +"--> Name: " + value.name() + ";"));
            System.out.println("Selecione um codigo: ");
            int code = scan.nextInt();
            address += "/" + code + "/models";
            json = consumeAPI.getData(address);
            var list2 = convertData.getDataList(json, ModelsData.class);
            list2 = list2.stream().sorted(Comparator.comparingInt(ModelsData::code)).toList();
            list2.forEach(value -> System.out.println("Code: " + value.code() +"--> Name: " + value.name() + ";"));
            System.out.println("Selecione um codigo: ");
            code = scan.nextInt();
            address += "/" + code + "/years";
            json = consumeAPI.getData(address);
            var list3 = convertData.getDataList(json, YearsData.class);
            list3.forEach(value -> System.out.println("Code: " + value.code() +"--> Name: " + value.name() + ";"));
            System.out.println("Selecione um ano(Digite nesse modelo: 2023-1): ");
            String year = scan.next();
            address += "/" + year;
            json = consumeAPI.getData(address);
            var fipeData = convertData.getData(json, FipeData.class);
            System.out.println(fipeData);
        }
    }

}
