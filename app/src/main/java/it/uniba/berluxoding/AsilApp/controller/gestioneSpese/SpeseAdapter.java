package it.uniba.berluxoding.AsilApp.controller.gestioneSpese;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import it.uniba.berluxoding.AsilApp.R;

public class SpeseAdapter extends ArrayAdapter<String> {

    private List<String> speseList;
    private Fragment fragment;

    public SpeseAdapter(Context context, List<String> speseList, Fragment fragment) {
        super(context, 0, speseList);
        this.speseList = speseList;
        this.fragment = fragment;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_spesa, parent, false);
        }

        TextView tvSpesa = convertView.findViewById(R.id.tvSpesaItem);
        Button btnRimuoviSpesa = convertView.findViewById(R.id.btnRimuoviSpesa);

        tvSpesa.setText(speseList.get(position));

        btnRimuoviSpesa.setOnClickListener(v -> {
            speseList.remove(position);
            notifyDataSetChanged();
            if (fragment instanceof AggiungiSpeseFragment) {
                ((AggiungiSpeseFragment) fragment).calcolaTotaleSpese();
            }
        });

        return convertView;
    }
}
