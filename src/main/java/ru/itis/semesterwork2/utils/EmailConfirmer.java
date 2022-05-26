package ru.itis.semesterwork2.utils;


import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.itis.semesterwork2.services.impl.ProfileServiceImpl;

import javax.xml.bind.SchemaOutputResolver;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Collections;

@Component
public class EmailConfirmer {
    private static final Logger log = LoggerFactory.getLogger(EmailConfirmer.class);

    private final String KEY ="e859279cfe0a4545b647ede8f379d76f";
    private final String IP = "";
    private final String VALID_STATUS = "valid";

    public boolean confirm(String email) {
        String targetURL = "https://api.zerobounce.net/v2/validate?api_key=" + KEY + "&email=" + email + "&ip_address=" + IP;

        HttpURLConnection connection = null;
        final String USER_AGENT = "Mozilla/5.0";

        boolean flag = false;

        try {
            URL url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.addRequestProperty("User-Agent", USER_AGENT);
            connection.setUseCaches(false);
            connection.setDoOutput(true);

            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader(connection.getInputStream()));
            JsonObject rootobj = root.getAsJsonObject();
            String status = rootobj.get("status").getAsString();
            if(status.equals(VALID_STATUS)){
                flag = true;
            }
        } catch (IOException e) {
            log.error("Connection error");
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            return flag;
        }
    }
}
