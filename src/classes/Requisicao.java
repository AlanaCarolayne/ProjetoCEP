package classes;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Requisicao {
    Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .create();
    public Cep consultacep (String cep)  {
        String url = "https://viacep.com.br/ws/" + cep.replace("-", "") + "/json/";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        //-----exceçoes------//
        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Cep.class);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException ("Não consegui obter o endereço a partir desse CEP.");
        }


    }
}
