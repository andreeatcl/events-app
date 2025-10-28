package ro.ase.pdm.events;

import android.os.Bundle;
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

import ro.ase.pdm.events.model.Eveniment;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button btnSalveaza = findViewById(R.id.buttonSalveaza);
        btnSalveaza.setOnClickListener(view -> {

            EditText editTextDenumire = findViewById(R.id.editTextDenumire);
            Spinner spinnerCategorie = findViewById(R.id.spinnerTip);
            EditText editTextData = findViewById(R.id.editTextData);
            EditText editTextOra = findViewById(R.id.editTextOra);
            EditText editTextLocul = findViewById(R.id.editTextLocul);
            EditText editTextDescriere = findViewById(R.id.editTextDescriere);

            String denumire = editTextDenumire.getText().toString();
            String categorie = spinnerCategorie.getSelectedItem().toString();
            String data = editTextData.getText().toString() + " " + editTextOra.getText().toString();
            String locul = editTextLocul.getText().toString();
            String descriere = editTextDescriere.getText().toString();

            Eveniment eveniment = new Eveniment(denumire, categorie, data, locul, descriere);
            Toast.makeText(this, "S-a salvat evenimentul" + eveniment, Toast.LENGTH_SHORT).show();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}