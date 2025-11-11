package ro.ase.pdm.events;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import ro.ase.pdm.events.model.Eveniment;

public class MainActivity extends AppCompatActivity {

    List<Eveniment> evenimente = new ArrayList<>();
    // ArrayAdapter<Eveniment> adaptor;
    AdaptorEvenimente adaptor;
    ListView listViewEvenimente;

    // launcher -> activity result contract + activity result callback
    ActivityResultLauncher<Intent> launcherAddEdit = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult o) {
                    // aici preluam evenimentul din Intent
                    if(o.getResultCode() == RESULT_OK) {
                        Intent intent = o.getData();

                        if (intent != null) {
                            Eveniment eveniment =
                                    (Eveniment)intent.getSerializableExtra("EVENIMENT");

                            if (eveniment != null) {
                                // pozitie == -1 -> eveniment nou
                              /*  evenimente.add(eveniment);
                                adaptor.notifyDataSetChanged(); */
                                adaptor.add(eveniment); // daca folosim arrayadaptor de clasa de baza
                                // pozitie != -1 -> eveniment existent
                                // evenimente.set(pozitie, eveniment);
                            }
                        }
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Log.i("Evenimente", "S-a apelat metoda onCreate()");

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AddActivity.class);
                // startActivity(intent);
                launcherAddEdit.launch(intent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        listViewEvenimente = findViewById(R.id.listViewEvenimente);
        try {
            evenimente.add(new Eveniment("ITFest Hackathon", "Hackathon", "20/11/2025 17:00", "Bucuresti, Romania", "Un hackathon pentru studentii CSIE"));
            evenimente.add(new Eveniment("DevCon", "Conferinta", "25/11/2025 09:45", "Bucuresti, Romania", "O conferinta pentru dezvoltatori si pasionati de IT"));
            evenimente.add(new Eveniment("ASE Job Fair", "Targ de joburi", "30/11/2025 12:30", "Bucuresti, Romania", "Un targ de joburi si internships destinat studentilor ASE"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // adaptor = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, evenimente);
        adaptor = new AdaptorEvenimente(this, evenimente);
        listViewEvenimente.setAdapter(adaptor);

        listViewEvenimente.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*
                - parametri: evenimentul din lista de la pozitia position
                        pozitia position a evenimentului selectat
                - rezultat: obiectul Eveniment modificat
                 */
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.action_despre) {
            Intent intent = new Intent(this,DespreActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}