package com.example.luisito.notasapp.views.fragments;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.luisito.notasapp.R;
import com.example.luisito.notasapp.interfaces.mynotes.MyNotesPresenter;
import com.example.luisito.notasapp.interfaces.mynotes.MyNotesView;
import com.example.luisito.notasapp.models.Nota;
import com.example.luisito.notasapp.presenters.MyNotesPresenterImp;
import com.example.luisito.notasapp.views.adapters.MyNotesAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyNotesFragment extends Fragment implements View.OnClickListener, MyNotesView {

    MyNotesPresenter presenter;
    //View elements
    private FloatingActionButton floatingActionButton;
    private View rootView;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Nota> notas;
    private ProgressBar progress;
    public MyNotesFragment() {}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_my_notes, container, false);
        floatingActionButton = (FloatingActionButton) rootView.findViewById(R.id.myNOtes_floating);
        floatingActionButton.setOnClickListener(this);
        progress = (ProgressBar) rootView.findViewById(R.id.myNotes_progress);
        presenter = new MyNotesPresenterImp(this);
        //Para el recycler
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.myNotes_recycler);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        presenter.loadNotesPresenter();
        return rootView;
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.myNOtes_floating:
                dialog();
                break;
        }
    }

    @Override
    public void showProgress(boolean option) {
        if(option)
            progress.setVisibility(View.VISIBLE);
        else
            progress.setVisibility(View.GONE);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this.getContext(),message,Toast.LENGTH_SHORT).show();
        presenter.loadNotesPresenter();
    }

    @Override
    public void loadMyNotesView(List<Nota> notas) {
        this.notas = notas;
        mAdapter = new MyNotesAdapter(presenter,notas,this.getContext());
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void refreshNotes(List<Nota> notas) {
        this.notas = notas;
    }
    @Override
    public void refresh()
    {
        presenter.loadNotesPresenter();
    }

    private void dialog()
    {
        final EditText title = new EditText(this.getContext());
        title.setHint("Title");
        final EditText content = new EditText(this.getContext());
        content.setHint("content");
        LinearLayout linearLayout = new LinearLayout(this.getContext());
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.addView(title);
        linearLayout.addView(content);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.getContext());
        builder.setTitle("New note");
        builder.setView(linearLayout);
        builder.setPositiveButton("save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                presenter.createNote(title.getText().toString(),content.getText().toString());
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
}
