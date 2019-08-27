package hridoy.aiz.fragmentswithrecyclerview;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFrag extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.Adapter rvAdapter;
    RecyclerView.LayoutManager rvLayoutManager;
    View view;
    public ListFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_list, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView =  view.findViewById(R.id.list);
        rvLayoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(rvLayoutManager);
        rvAdapter = new PersonAdapter(this.getActivity(),ApplicationClass.personArrayList);
        recyclerView.setAdapter(rvAdapter);

        //Toast.makeText(this.getActivity(),ApplicationClass.personArrayList.toString(),Toast.LENGTH_LONG).show();
        //Log.d("Person ArrayList",ApplicationClass.personArrayList.toString() );

    }

    public void notifyDataChanged(){
        rvAdapter.notifyDataSetChanged();
    }



}
