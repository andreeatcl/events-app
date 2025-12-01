package ro.ase.pdm.events;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.Arrays;
import java.util.List;

import ro.ase.pdm.events.model.Eveniment;

public class AddActivity extends AppCompatActivity {

    EditText editTextDenumire, editTextData, editTextOra, editTextLocul, editTextDescriere;
    Spinner spinnerCategorie;
    Eveniment eveniment = null;
    int pozitie = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add);

        initControale();
        Intent intent = getIntent();

        eveniment = (Eveniment) intent.getSerializableExtra(MainActivity.CHEIE_EVENIMENT);
        if (eveniment != null) {
            pozitie = intent.getIntExtra(MainActivity.CHEIE_POZITIE, -1);
            populeazaControale();
        }

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button btnSalveaza = findViewById(R.id.buttonSalveaza);
        btnSalveaza.setOnClickListener(view -> {

            String denumire = editTextDenumire.getText().toString();
            String categorie = spinnerCategorie.getSelectedItem().toString();
            String data = editTextData.getText().toString();
            String ora = editTextOra.getText().toString();
            String locul = editTextLocul.getText().toString();
            String descriere = editTextDescriere.getText().toString();

            try {
                Eveniment eveniment = new Eveniment(denumire, categorie, data, ora, locul, descriere);
                Toast.makeText(this, "S-a salvat evenimentul" + eveniment, Toast.LENGTH_LONG).show();
                setResult(RESULT_OK, new Intent()
                        .putExtra(MainActivity.CHEIE_EVENIMENT, eveniment)
                        .putExtra(MainActivity.CHEIE_POZITIE, pozitie));
                finish();
            }
            catch (Exception e) {
                Log.e("Evenimente", "Eroare la adaugarea evenimentului");
                Toast.makeText(this, "Date invalide. Incercati din nou.", Toast.LENGTH_LONG).show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    void initControale() {
        editTextDenumire = findViewById(R.id.editTextDenumire);
        spinnerCategorie = findViewById(R.id.spinnerTip);
        editTextData = findViewById(R.id.editTextData);
        editTextOra = findViewById(R.id.editTextOra);
        editTextLocul = findViewById(R.id.editTextLocul);
        editTextDescriere = findViewById(R.id.editTextDescriere);
    }

    void populeazaControale() {
        editTextDenumire.setText(eveniment.getDenumire());
        editTextData.setText(eveniment.getData());
        editTextOra.setText(eveniment.getOra());
        editTextLocul.setText(eveniment.getLoculDesfasurarii());
        editTextDescriere.setText(eveniment.getDescriere());

        // spinner categorie
        String categorie = eveniment.getCategorie();
        String[] categorii = this.getResources().getStringArray(R.array.categorii);

        List<String> listaCategorii = Arrays.asList(categorii);
        int position = listaCategorii.indexOf(categorie);

        if (position >= 0) {
            spinnerCategorie.setSelection(position);
        } else {
            spinnerCategorie.setSelection(0);
        }

    }
}