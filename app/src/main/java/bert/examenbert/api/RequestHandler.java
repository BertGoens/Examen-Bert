package bert.examenbert.api;

/* Created by Bert Goens */

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;


public class RequestHandler {

    //methode voor het versturen van een httpPostRequest (POST)
    //methode heeft twee parameters
    //eerste parameter : naam van het script waar we de request naar toesturen
    //tweede parameter is een HashMap met waarden die we bij de request gaan meesturen
    public String sendPostRequest(String requestURL,
                                  HashMap<String, String> postDataParams) {
        //Aanmaken van de URL
        URL url;

        //StringBuilder object om de request te bewaren die we van de server krijgen
        StringBuilder sb = new StringBuilder();
        try {
            //initialiseren van de URL
            url = new URL(requestURL);

            //Aanmaak van een HttpURLConnection object
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            //instellen van enkele eigenschappen van de connectie
            conn.setReadTimeout(15000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);

            //Aanmaken van een OutputsStream object
            OutputStream os = conn.getOutputStream();

            //schrijven van de parameters naar de request
            //we gebruiken hiervoor een eigen geschreven methode getPostDataString
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            writer.write(getPostDataString(postDataParams));

            writer.flush();
            writer.close();
            os.close();
            int responseCode = conn.getResponseCode();

            if (responseCode == HttpsURLConnection.HTTP_OK) {

                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                sb = new StringBuilder();
                String response;
                //Lezen van de response van de server
                while ((response = br.readLine()) != null) {
                    sb.append(response);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }


    //methode voor het versturen van een httpPostRequest (GET)
    //eerste parameter : naam van het script waar we de request naar toesturen
    public String sendGetRequest(String requestURL) {
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL(requestURL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(con.getInputStream()));

            String s;
            while ((s = bufferedReader.readLine()) != null) {
                sb.append(s).append("\n");
            }
        } catch (Exception e) {
        }
        return sb.toString();
    }


    //methode voor het versturen van een httpPostRequest (GET)
    //waarbij we een parameter kunnen meegeven
    //eerste parameter : naam van het script waar we de request naar toesturen
    //tweede parameter : de paramter
    public String sendGetRequestParam(String requestURL, String id) {
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL(requestURL + id);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(con.getInputStream()));

            String s;
            while ((s = bufferedReader.readLine()) != null) {
                sb.append(s).append("\n");
            }
        } catch (Exception e) {
        }
        return sb.toString();
    }


    private String getPostDataString(HashMap<String, String> params)
            throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }

        return result.toString();
    }
}
