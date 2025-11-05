package ro.ase.pdm.events;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.EventListener;
import java.util.List;

import ro.ase.pdm.events.model.Eveniment;

public class AdaptorEvenimente extends ArrayAdapter<Eveniment> {

    public AdaptorEvenimente(@NonNull Context context, @NonNull List<Eveniment> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        // 1 initializare view pe baza machetei

        if (view == null) {
            // prima afisare
            view = LayoutInflater.from(getContext()).inflate(R.layout.element_lista, parent, false);
        }

        // 2 initializare controale din macheta
        TextView textViewDenumire = view.findViewById(R.id.textViewDenumire);
        TextView textViewCategorie = view.findViewById(R.id.textViewCategorie);
        // etc.

        // 3 identificare obiect curent
        Eveniment eveniment = getItem(position);
        // 4 populare controale macheta
        textViewDenumire.setText(eveniment.getDenumire()); // verificari

        if (position % 2 == 0) {
            // coloram diferit
        }

        // this is bugged, fix later
        /*if (eveniment.getCategorie().equals("Conferinta")) {
            // evidentiem diferit
        }*/

        return view;
    }
}
