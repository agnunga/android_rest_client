package com.ag.timesheet.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ag.timesheet.R;
import com.ag.timesheet.api.APIService;
import com.ag.timesheet.api.APIUrl;
import com.ag.timesheet.models.CostCentresDto;
import com.ag.timesheet.models.CostCentre;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class CostCentreFragment extends Fragment {

    String TAG = this.getClass().getSimpleName();
    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    private RecyclerView recyclerView;
    private MyCostCentreRecyclerViewAdapter myCostCentreRecyclerViewAdapter;
    private List<CostCentre> costCentres = new ArrayList<>();

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public CostCentreFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static CostCentreFragment newInstance(int columnCount) {
        CostCentreFragment fragment = new CostCentreFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_costcentre_list, container, false);

        getActivity().setTitle("Cost Centres");
        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            loadDataWithRetrofit();
            /*
            TO load dummy data, comment loadDataWithRetrofit(); and uncomment this block
            costCentres.add(new CostCentre(1, "C Centre 1", "Ideal Sana", "Opposite SouthB", 1, new Date(), new Date()));
            costCentres.add(new CostCentre(2, "C Centre 2", "Ideal Kabisa", "Sides SouthC", 1, new Date(), new Date()));
            costCentres.add(new CostCentre(3, "C Centre 3", "Kiasi tu", "Fronts Lesho", 1, new Date(), new Date()));
            myCostCentreRecyclerViewAdapter = new MyCostCentreRecyclerViewAdapter(costCentres, mListener);
            recyclerView.setAdapter(myCostCentreRecyclerViewAdapter);*/
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            /*throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");*/
            mListener = new OnListFragmentInteractionListener() {
                @Override
                public void onListFragmentInteraction(CostCentre item) {

                }
            };
            Log.d(TAG, "onAttach: Consider Implementing OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(CostCentre item);
    }


    private void loadDataWithRetrofit() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);

        Call<CostCentresDto> call = service.getCostCentres();

        call.enqueue(new Callback<CostCentresDto>() {
            @Override
            public void onResponse(Call<CostCentresDto> call, Response<CostCentresDto> response) {
                myCostCentreRecyclerViewAdapter = new MyCostCentreRecyclerViewAdapter(response.body().getCost_centres(), mListener);
                recyclerView.setAdapter(myCostCentreRecyclerViewAdapter);
                Log.d(TAG, "onResponse: " + response.body().getCost_centres() );

            }

            @Override
            public void onFailure(Call<CostCentresDto> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage() + "\n");
                t.printStackTrace();
            }
        });
    }

}
