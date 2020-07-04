package bean;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class OpenWeatherMap {

    private static final Logger LOGGER = LogManager.getLogger(OpenWeatherMap.class);

    private static final String keyApiOpenWeatherMap = "aa2cb318cf74326af9903d7e60a5f9fe";

    private String longitude;
    private String latitude;
    private String descriptionMetoe;

    public OpenWeatherMap() {

    }

    public OpenWeatherMap(String ville, String longitude, String Latitude) {
        this.setLongitude(longitude);
        this.setLatitude(Latitude);

        this.meteoDescritpionResearch(ville);

    }

    public String getLongitude() {

        if (longitude != null) {
            return longitude;
        } else {
            return "";
        }


    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {

        if (latitude != null) {
            return latitude;
        } else {
            return "";
        }

    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getDescriptionMetoe() {
        return descriptionMetoe;
    }

    public void setDescriptionMetoe(String descriptionMetoe) {
        this.descriptionMetoe = descriptionMetoe;
    }

    private void meteoDescritpionResearch(String ville) {

        if (!ville.isEmpty()) {

            String parmaUrlOpenWeather = "?q="+ville+ "&appid="+keyApiOpenWeatherMap;

            System.out.println("param : " + parmaUrlOpenWeather);

            try {
                URL url = new URL("Http://api.openweathermap.org/data/2.5/weather" + parmaUrlOpenWeather);

                // ouverture de la connection
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                // indication de qui je suis
                httpURLConnection.addRequestProperty("User-Agent", "WebAppMeteo/Java 1.0");

                JSONParser jsonParser = new JSONParser();

                // parse du resulat de la connection (objet Json)
                JSONObject jsonObject = (JSONObject) jsonParser.parse(
                        new InputStreamReader(httpURLConnection.getInputStream()));

                // recupération de la value weather
                JSONArray weather = (JSONArray) jsonObject.get("weather");

                // recuperation du contenu de weather
                JSONObject jsonObWeather = (JSONObject) weather.get(0);

                // recupération de la values de description
                this.setDescriptionMetoe((String) jsonObWeather.get("description"));


            } catch (ParseException pex) {

                LOGGER.error(pex);
                this.setDescriptionMetoe("Erreur excution programme 01");

            } catch (MalformedURLException ioex) {

                LOGGER.error(ioex);
                this.setDescriptionMetoe("Erreur excution programme 02");

            } catch (IOException ioex) {

                LOGGER.error(ioex);
                this.setDescriptionMetoe("Erreur excution programme 03");

            }catch(Exception ex){ // erreur d'excution grave

                LOGGER.fatal(ex);
                // fermer l'application
                System.exit(0);
            }

        }

    }

    @Override
    public String toString() {
        return "OpenWeatherMap{" +
                "longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", descriptionMetoe='" + descriptionMetoe + '\'' +
                '}';
    }
}
