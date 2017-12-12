package com.example.luisito.notasapp.views.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.luisito.notasapp.R;
import com.example.luisito.notasapp.interfaces.sharednotes.MyNotesSharedPresenter;
import com.example.luisito.notasapp.models.Nota;

import java.util.List;

/**
 * Created by luisito on 12/12/17.
 */

public class MyNotesSharedAdapter extends RecyclerView.Adapter<MyNotesSharedAdapter.ViewHolder>
{
    private MyNotesSharedPresenter presenter;
    private List<Nota> notas;
    public MyNotesSharedAdapter(MyNotesSharedPresenter presenter, List<Nota> notas)
    {
        this.presenter = presenter;
        this.notas = notas;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_notes_shared,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.title.setText(notas.get(position).getTitulo());
        holder.content.setText(notas.get(position).getContenido());
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.deleteNote(notas.get(position).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return notas.size();
    }

    public static  class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView title;
        public TextView content;
        public Button delete;
        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.noteShared_title);
            content = (TextView) itemView.findViewById(R.id.noteShred_content);
            delete = (Button) itemView.findViewById(R.id.myNotesShared_delete);
        }
    }
}
