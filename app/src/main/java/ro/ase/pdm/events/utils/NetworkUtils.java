package ro.ase.pdm.events.utils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class NetworkUtils {
    public static String preiaContinut(String adresaServiciu) throws Exception {
        String continut = null;

        try {
            URL url = new URL(adresaServiciu);
            Scanner scanner = new Scanner(url.openStream());
            scanner.useDelimiter("\\A");
            continut = scanner.hasNext() ? scanner.next() : null;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return continut;
    }
}
