package Enos.projectsApi.Fipe.service;

import Enos.projectsApi.Fipe.exceptions.CantGetDataException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumeAPI {

    public String getData(String address){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(address)).build();
        HttpResponse<String> response;
        try {
            response = client.send(request,HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e){
            throw new CantGetDataException("Data cannot be recovered");
        }
    }
}
