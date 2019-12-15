package com.example.submission_2;


import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment {

    private String[] data_nama;
    private String[] data_desc;
    private TypedArray data_photo;
    private ArrayList<Film> films;
    private RecyclerView rvFilm;

    public MoviesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movies, container, false);

        rvFilm = view.findViewById(R.id.rvFilm);

        show();
        rvFilm.setHasFixedSize(true);


        return view;
    }

    private void show(){
        prepare();
        rvFilm.setLayoutManager(new LinearLayoutManager(getActivity()));
        FilmAdapter filmAdapter = new FilmAdapter(films);
        rvFilm.setAdapter(filmAdapter);

    }

    private void prepare() {
        data_nama = getResources().getStringArray(R.array.data_name_movies);
        data_desc = getResources().getStringArray(R.array.data_description_movies);
        data_photo = getResources().obtainTypedArray(R.array.data_photo_movies);

        films = new ArrayList<>();

        for (int i = 0 ; i<data_nama.length; i++){
            Film film = new Film();

            film.setName(data_nama[i]);
            film.setDesc(data_desc[i]);
            film.setPhoto(data_photo.getResourceId(i, -1));
            films.add(film);
        }
    }

}
