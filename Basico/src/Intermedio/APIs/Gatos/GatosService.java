package Intermedio.APIs.Gatos;

import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.awt.Image;

public class GatosService {

    public static void verGatos() {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.thecatapi.com/v1/images/search")
                .method("GET", null)
                .build();
        try {
            Response response = client.newCall(request).execute();

            String json = response.body().string();

            // Eliminamos los [] del JSON
            json = json.substring(1, json.length());
            json = json.substring(0, json.length() - 1);// ultima posicion

            // crear un objeto de la clase GSon
            Gson gion = new Gson();
            // convertir a tipo GATO
            Gatos cat = gion.fromJson(json, Gatos.class);

            // resimensionar en caso de necesitas
            Image image = null;
            try {
                URL url = new URL(cat.getUrl());
                image = ImageIO.read(url);

                ImageIcon fondo = new ImageIcon(image);

                if (fondo.getIconWidth() > 800) {
                    // redimensionamos
                    Image fon = fondo.getImage();
                    Image modificada = fon.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
                    fondo = new ImageIcon(modificada);
                }

                String menu = "Opciones: \n"
                        + "1. Ver otra imagen\n"
                        + "2. Favoritos\n"
                        + "3. Volver \n";
                String[] bo = { "ver otra imagen", "favorito", "volver" };
                String idGato = cat.getId();
                String opcion = (String) JOptionPane.showInputDialog(null, menu, idGato,
                        JOptionPane.INFORMATION_MESSAGE, fondo, bo, bo[0]);

                int seleccion = -1;
                // Validamos que opcion selecciona el usuario
                for (int i = 0; i < bo.length; i++) {
                    if (opcion.equals(bo[i])) {
                        seleccion = i;
                    }
                }

                switch (seleccion) {
                    case 0:
                        verGatos();
                        break;
                    case 1:
                        favoritoGato(cat);
                        break;
                    default:
                        break;

                }

            } catch (IOException e) {
                System.err.println(e);
            }

        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static void favoritoGato(Gatos gato) {
        try {
            OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\r\n    \"image_id\":\"" + gato.getId() + "\"\r\n}");
            Request request = new Request.Builder()
                    .url("https://api.thecatapi.com/v1/favourites?=&=")
                    .method("POST", body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("x-api-key", gato.getApiKey())
                    .build();
            Response response = client.newCall(request).execute();
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static void verFavoritos(String apiKey) {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://api.thecatapi.com/v1/favourites")
                    .method("GET", null)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("x-api-key", apiKey)
                    .build();
            Response response = client.newCall(request).execute();

            // Guardamos el string con la respuesta
            String elJson = response.body().string();

            // creamos el objeto gson
            Gson gson = new Gson();
            GatosFav[] gatosArray = gson.fromJson(elJson, GatosFav[].class);

            if (gatosArray.length > 0) {
                int min = 1;
                int max = gatosArray.length;
                int aleatorio = (int) (Math.random() * ((max - min) + 1)) + min;

                int indice = aleatorio - 1;
                GatosFav gatofav = gatosArray[indice];

                // redimencionar en caso de necesitas
                Image image = null;
                try {
                    URL url = new URL(gatofav.getImage().getUrl());
                    image = ImageIO.read(url);

                    ImageIcon fondo = new ImageIcon(image);

                    if (fondo.getIconWidth() > 800) {
                        // redimensionamos
                        Image fon = fondo.getImage();
                        Image modificada = fon.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
                        fondo = new ImageIcon(modificada);
                    }

                    String menu = "Opciones: \n"
                            + "1. Ver otra imagen\n"
                            + "2. Eliminar Favorito\n"
                            + "3. Volver \n";
                    String[] bo = { "ver otra imagen", "eliminar favorito", "volver" };

                    String idGato = gatofav.getId();
                    String opcion = (String) JOptionPane.showInputDialog(null, menu, idGato,
                            JOptionPane.INFORMATION_MESSAGE, fondo, bo, bo[0]);

                    int seleccion = -1;
                    // Validamos que opcion selecciona el usuario
                    for (int i = 0; i < bo.length; i++) {
                        if (opcion.equals(bo[i])) {
                            seleccion = i;
                        }
                    }

                    switch (seleccion) {
                        case 0:
                            verFavoritos(apiKey);
                            break;
                        case 1:
                            borrarFavorito(gatofav);
                            break;
                        default:
                            break;

                    }

                } catch (IOException e) {
                    System.err.println(e);
                }

            }

        } catch (Exception e) {
            System.err.println(e);
        }

    }

    public static void borrarFavorito(GatosFav gatofav) {
        try {
            OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "");
            Request request = new Request.Builder()
                    .url("https://api.thecatapi.com/v1/favourites/" + gatofav.getId() + "")
                    .method("DELETE", body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("x-api-key", gatofav.getApikey())
                    .build();
            client.newCall(request).execute();
            System.out.println("se elimino correctamente");
        } catch (IOException e) {
            System.err.println(e);
        }
    }

}
