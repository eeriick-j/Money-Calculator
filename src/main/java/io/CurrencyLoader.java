package io;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import model.Currency;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class CurrencyLoader {
    private static final String API_KEY = "78f2ad1a2e76eb7ca408357a";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/";

    private URLConnection openConnection() throws IOException {
        return new URL(API_URL + "codes").openConnection();
    }

    private InputStream openInputStream(URLConnection connection) throws IOException {
        return connection.getInputStream();
    }

    private JsonObject getJson(InputStream inputStream) throws IOException {
        return new Gson().fromJson(new String(inputStream.readAllBytes()), JsonObject.class);
    }

    private List<Currency> jsonArrayToList(JsonArray jsonArray) {
        List<Currency> list = new ArrayList<>();
        for (JsonElement element : jsonArray) {
            JsonArray tuple = element.getAsJsonArray();
            list.add(new Currency(tuple.get(0).getAsString(), tuple.get(1).getAsString()));
        }
        return list;
    }

    public List<Currency> loadAll() throws IOException {
        try (InputStream inputStream = openInputStream(openConnection())) {
            return jsonArrayToList(getJson(inputStream).getAsJsonArray("supported_codes"));
        }
    }
}
