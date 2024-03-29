package matrix.example.baratheraja.tabs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class  OneFragment extends Fragment{

    public OneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle args = getArguments();
        RecyclerView recyclerView = new RecyclerView(getActivity());

        if(args.getStringArray("number")!= null)
            recyclerView.setAdapter(new YourRecyclerAdapter(getActivity(),args.getStringArray("value"),args.getStringArray("number")));
        else
             recyclerView.setAdapter(new YourRecyclerAdapter(getActivity(),args.getStringArray("value")));

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return recyclerView;
    }

}

