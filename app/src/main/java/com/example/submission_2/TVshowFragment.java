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
public class TVshowFragment extends Fragment {

    private String[] data_nama;
    private String[] data_desc;
    private TypedArray data_photo;
    private ArrayList<Tv> tvs;
    private RecyclerView rvTv;

    public TVshowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tvshow, container, false);

        rvTv = view.findViewById(R.id.rvTv);
        show();
        rvTv.setHasFixedSize(true);

        return view;
    }

    private void show() {
        prepare();
        rvTv.setLayoutManager(new LinearLayoutManager(getActivity()));
        TvAdapter tvAdapter = new TvAdapter(tvs);
        rvTv.setAdapter(tvAdapter);
    }

    private void prepare() {
        data_nama = getResources().getStringArray(R.array.data_name_tv);
        data_desc = getResources().getStringArray(R.array.data_description_tv);
        data_photo = getResources().obtainTypedArray(R.array.data_photo_tv);

        tvs = new ArrayList<>();

        for (int i = 0 ; i<data_nama.length; i++){
            Tv tv = new Tv();

            tv.setName(data_nama[i]);
            tv.setDesc(data_desc[i]);
            tv.setPhoto(data_photo.getResourceId(i, -1));
            tvs.add(tv);
        }
    }

}
