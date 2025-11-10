package ro.ase.pdm.events;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

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
        // 1. initializare view pe baza machetei

        if (view == null) {
            // prima afisare
            view = LayoutInflater.from(getContext()).inflate(R.layout.element_lista, parent, false);
        }

        // 2. initializare controale din macheta
        TextView textViewDenumire = view.findViewById(R.id.textViewDenumire);
        TextView textViewCategorie = view.findViewById(R.id.textViewCategorie);
        TextView textViewData = view.findViewById(R.id.textViewData);
        TextView textViewLoc = view.findViewById(R.id.textViewLoc);
        TextView textViewDescriere = view.findViewById(R.id.textViewDescriere);

        // 3. identificare obiect curent
        Eveniment eveniment = getItem(position);

        // 4. populare controale macheta
        textViewDenumire.setText(eveniment.getDenumire());
        textViewCategorie.setText(eveniment.getCategorie());
        textViewData.setText(eveniment.getData());
        textViewLoc.setText(eveniment.getLoculDesfasurarii());
        textViewDescriere.setText(eveniment.getDescriere());

        // coloram diferit in functie de pozitie in lista
        if (position % 2 == 0) {
            view.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.pale_turquoise));
        }

        // evidentiem diferit in functie de categorie
        switch (eveniment.getCategorie()) {
            case "Conferinta":
                textViewCategorie.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.pastel_blue));
                break;
            case "Hackathon":
                textViewCategorie.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.pastel_red));
                break;
            case "Targ de joburi":
                textViewCategorie.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.cucumber));
                break;
            case "Workshop":
                textViewCategorie.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.cream_yellow));
                break;
            default:
                textViewCategorie.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.beige));
                break;
        }

        textViewCategorie.setPadding(6, 2, 6, 2);

        return view;
    }
}
