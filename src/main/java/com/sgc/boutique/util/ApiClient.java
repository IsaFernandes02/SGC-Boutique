package com.sgc.boutique.util;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ApiClient {

    public static String login(String usuario, String senha) {

        try {

            URL url = new URL("http://localhost:8080/auth/login");

            HttpURLConnection conn =
                    (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty(
                    "Content-Type",
                    "application/json");

            conn.setDoOutput(true);

            String json =
                    """
                    {
                        "username":"%s",
                        "senha":"%s"
                    }
                    """.formatted(usuario, senha);

            OutputStream os = conn.getOutputStream();
            os.write(json.getBytes());
            os.flush();

            Scanner sc =
                    new Scanner(conn.getInputStream());

            StringBuilder resposta =
                    new StringBuilder();

            while(sc.hasNext()) {

                resposta.append(sc.nextLine());
            }

            return resposta.toString();

        } catch(Exception e) {

            return null;
        }
    }
}