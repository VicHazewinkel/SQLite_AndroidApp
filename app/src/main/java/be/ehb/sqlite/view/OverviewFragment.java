package be.ehb.sqlite.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import be.ehb.sqlite.R;
import be.ehb.sqlite.model.DatabaseTable;
import be.ehb.sqlite.view.utils.Adapter;
import be.ehb.sqlite.viewmodel.DataViewModel;

public class OverviewFragment extends Fragment{

    //1
    public OverviewFragment() {
        // Required empty public constructor
    }

    //2
    public static OverviewFragment newInstance() {
        OverviewFragment fragment = new OverviewFragment();
        return fragment;
    }

    //3
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_overview, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView rvData = view.findViewById(R.id.rv_data);

        Adapter adapter = new Adapter();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);

        rvData.setAdapter(adapter);
        rvData.setLayoutManager(layoutManager);

        DataViewModel viewModel = new ViewModelProvider(getActivity()).get(DataViewModel.class);

        viewModel.getAllData().observe(getViewLifecycleOwner(), (List<DatabaseTable> items) -> {
            adapter.addItems(items);
            // adapter.notifyDataSetChanged();
        });

        // FloatingActionButton fab = view.findViewById(R.id.btn_new_data);
        // fab.setOnClickListener( (View v) -> {
        //    Navigation.findNavController(view).navigate(R.id.action_overviewFragment_to_newDataFragment);
        // });
    }
}
