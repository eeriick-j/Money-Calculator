package io;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import models.Currency;
import models.ExchangeRate;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class ExchangeRateLoader {
    private static final String API_KEY = "78f2ad1a2e76eb7ca408357a";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/";

    public ExchangeRate load(Currency from, Currency to) {
        try {
            return new ExchangeRate(
                    from,
                    to,
                    readConversionRate(new URL(API_URL + "pair/" + from.code() + "/" + to.code()))
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Double readConversionRate(URL url) throws IOException {
        return readConversionRate(url.openConnection());
    }

    private Double readConversionRate(URLConnection connection) throws IOException {
        return readConversionRate(connection.getInputStream());
    }

    private Double readConversionRate(InputStream inputStream) throws IOException {
        String text = new String(inputStream.readAllBytes());
        return readConversionRate(new Gson().fromJson(text, JsonObject.class));
    }

    private Double readConversionRate(JsonObject jsonObject) {
        return jsonObject.get("conversion_rate").getAsDouble();
    }
}