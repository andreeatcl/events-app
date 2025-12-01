package ro.ase.pdm.events.data;

import android.content.Context;

import androidx.annotation.NonNull;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import ro.ase.pdm.events.R;
import ro.ase.pdm.events.model.Eveniment;

public class LocalData {
    public static List<Eveniment> incarcaEvenimente(Context context) throws Exception {
        List<Eveniment> evenimente = new ArrayList<>();

        JSONArray array = getJsonArray(context, R.raw.evenimente);

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

    @NonNull
    private static JSONArray getJsonArray(Context context, int resourceId) throws IOException, JSONException {

        InputStream is = context.getResources().openRawResource(resourceId);
        BufferedReader bf = new BufferedReader(new InputStreamReader(is));

        StringBuilder stringBuilder = new StringBuilder();
        String line = bf.readLine();
        while (line != null) {
            stringBuilder.append(line).append("\n");
            line = bf.readLine();
        }
        bf.close();
        String res = stringBuilder.toString();

        return new JSONArray(res);
    }
}
