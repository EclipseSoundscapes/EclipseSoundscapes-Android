package org.eclipsesoundscapes.eclipsesoundscapes.fragments;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import org.eclipsesoundscapes.eclipsesoundscapes.R;
import org.eclipsesoundscapes.eclipsesoundscapes.adapters.MediaAdapter;

/**
 * Created by horus on 7/27/17.
 */

public class MediaFragment extends Fragment {

    private String[] events = {"Baily's Beads", "Prominence", "Corona", "Helmet Streamers", "Diamond Ring"};
    private Integer[] descriptions = {R.string.bailys_beads_description, R.string.prominence_description,
                                R.string.corona_description, R.string.helmet_streamers_description, R.string.diamond_ring_description};
    private Integer[] eventImgs = {R.drawable.eclipse_bailys_beads, R.drawable.eclipse_prominence,
                                R.drawable.eclipse_corona, R.drawable.helmet_streamers, R.drawable.eclipse_diamond_ring};
    private Integer[] eventAudio = {R.raw.bailys_beads_full, R.raw.prominence_full, R.raw.corona_full,
                                R.raw.helmet_streamers_full, R.raw.diamond_ring_full};

    private Context mContext;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private MediaAdapter mediaAdapter;

    public MediaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_media, container, false);
        Toolbar toolbar = (Toolbar) root.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        // views
        recyclerView = (RecyclerView) root.findViewById(R.id.media_recycler);
        layoutManager = new LinearLayoutManager(mContext);
        mediaAdapter = new MediaAdapter(mContext, events, descriptions, eventImgs, eventAudio);
        dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mediaAdapter);
        recyclerView.addItemDecoration(dividerItemDecoration);

        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getActivity().getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(mContext, R.color.colorAccent));
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}