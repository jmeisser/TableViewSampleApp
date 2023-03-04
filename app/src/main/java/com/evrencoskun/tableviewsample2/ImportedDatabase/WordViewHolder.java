package com.evrencoskun.tableviewsample2.ImportedDatabase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

class WordViewHolder extends RecyclerView.ViewHolder {
    /*private final TextView wordItemView;
    private final TextView teamItemView;
    private final TextView dataItemView;
    private final TextView scoreItemView;*/

    private WordViewHolder(View itemView) {
        super(itemView);
        //wordItemView = itemView.findViewById(R.id.textView);
        //teamItemView = itemView.findViewById(R.id.textView2);
        //dataItemView = itemView.findViewById(R.id.textView3);
        //scoreItemView = itemView.findViewById(R.id.textView4);
    }

    /*public void bindWord(String text) {
        wordItemView.setText(text);
    }
    public void bindTeam(String text) {
        teamItemView.setText(text);
    }
    public void bindData(String text) {dataItemView.setText(text);}
    public void bindScore(String text) {
        scoreItemView.setText(text);
    }*/

    /*static WordViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new WordViewHolder(view);
    }*/
}
