package com.example.luisito.notasapp.views.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.luisito.notasapp.R;
import com.example.luisito.notasapp.interfaces.sharednotes.MyNotesSharedPresenter;
import com.example.luisito.notasapp.interfaces.sharednotes.MyNotesSharedView;
import com.example.luisito.notasapp.models.Nota;
import com.example.luisito.notasapp.presenters.MyNotesPresenterImp;
import com.example.luisito.notasapp.presenters.MyNotesSharedPresenterImp;
import com.example.luisito.notasapp.views.adapters.MyNotesAdapter;
import com.example.luisito.notasapp.views.adapters.MyNotesSharedAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyNotesSharedFragment extends Fragment implements MyNotesSharedView {
    private View rootView;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Nota> notas;
    private ProgressBar progress;
    private MyNotesSharedPresenter presenter;

    public MyNotesSharedFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_my_notes_shared, container, false);
        progress = (ProgressBar) rootView.findViewById(R.id.myNotesShared_progress);
        presenter = new MyNotesSharedPresenterImp(this);
        //Para el recycler
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.myNotesShared_recycler);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        presenter.loadNotesPresenter();
        return rootView;
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
        mAdapter = new MyNotesSharedAdapter(presenter,notas);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void refresh() {
        presenter.loadNotesPresenter();
    }
}
