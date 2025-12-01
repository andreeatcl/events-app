package ro.ase.pdm.events.data;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import ro.ase.pdm.events.model.Eveniment;
import ro.ase.pdm.events.utils.NetworkUtils;

public class RemoteData {
    public static List<Eveniment> incarcaEvenimente(String adresaServiciu) throws Exception {
        List<Eveniment> evenimente = new ArrayList<>();

        String json = NetworkUtils.preiaContinut(adresaServiciu);
        JSONArray array = new JSONArray(json);

        for (int i = 0; i < array.length(); i++) {
            JSONObject object = array.getJSONObject(i);

            Eveniment eveniment = new Eveniment();
            eveniment.setDenumire(object.getString("denumire"));
            eveniment.setCategorie(object.getString("categorie"));
            eveniment.setData(object.getString("data"));
            eveniment.setOra(object.getString("ora"));
            eveniment.setLoculDesfasurarii(object.getString("locatia"));
            eveniment.setDescriere(object.getString("descriere"));

            evenimente.add(eveniment);
        }

        return evenimente;
    }
}
