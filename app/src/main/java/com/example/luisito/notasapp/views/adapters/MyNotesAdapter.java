package com.example.luisito.notasapp.views.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.luisito.notasapp.R;
import com.example.luisito.notasapp.interfaces.mynotes.MyNotesPresenter;
import com.example.luisito.notasapp.models.Nota;

import java.util.List;

/**
 * Created by luisito on 10/12/17.
 */

public class MyNotesAdapter extends  RecyclerView.Adapter<MyNotesAdapter.ViewHolder> {

    private List<Nota> notas;
    MyNotesPresenter presenter;
    Context context;
    public  static  boolean shared;
    public MyNotesAdapter (List<Nota> notas)
    {
        this.notas = notas;
    }
    public MyNotesAdapter (MyNotesPresenter presenter, List<Nota> notas, Context context)
    {
        shared = false;
        this.context = context;
        this.presenter = presenter;
        this.notas = notas;
    }

    public void setData(List<Nota> notas)
    {
        notas.clear();
        this.notas = notas;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_notes,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.title.setText(notas.get(position).getTitulo());
        holder.content.setText(notas.get(position).getContenido());
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.delete(notas.get(position).getId());
            }
        });
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            dialogEditNote(notas.get(position).getId(),notas.get(position).getTitulo(),notas.get(position).getContenido());
               }
        });
        holder.shared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            dialogSharedNote(notas.get(position).getId());
            }
        });
    }

    private  void dialogSharedNote(final  int id)
    {
        final EditText email = new EditText(context);
        email.setHint("email");
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.addView(email);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Shared");
        builder.setView(linearLayout);
        builder.setPositiveButton("shared", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                presenter.shared(id,email.getText().toString());
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }
    private void dialogEditNote(final int id, String ptitle, String pcontent)
    {
        final EditText title = new EditText(context);
        title.setText(ptitle);
        title.setHint("Title");
        final EditText content = new EditText(context);
        content.setText(pcontent);
        content.setHint("content");
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.addView(title);
        linearLayout.addView(content);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("New note");
        builder.setView(linearLayout);
        builder.setPositiveButton("update", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                presenter.update(id,title.getText().toString(),content.getText().toString());
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }
    @Override
    public int getItemCount() {
        return notas.size();
    }

    public static  class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView title;
        public TextView content;
        public Button edit;
        public Button delete;
        public Button shared;
        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.note_title);
            content = (TextView) itemView.findViewById(R.id.note_content);
            edit = (Button) itemView.findViewById(R.id.myNotes_edit);
            delete = (Button) itemView.findViewById(R.id.myNotes_delete);
            shared = (Button) itemView.findViewById(R.id.myNotes_shared);
        }

        private void myNotesShared(View itemView)
        {
            title = (TextView) itemView.findViewById(R.id.noteShared_title);
            content = (TextView) itemView.findViewById(R.id.noteShred_content);
            delete = (Button) itemView.findViewById(R.id.myNotesShared_delete);
        }
    }
}
