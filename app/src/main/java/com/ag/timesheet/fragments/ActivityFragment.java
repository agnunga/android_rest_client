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
import com.ag.timesheet.models.ActivitiesDto;
import com.ag.timesheet.models.Activity;

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
public class ActivityFragment extends Fragment {

    String TAG = this.getClass().getSimpleName();
    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    private RecyclerView recyclerView;
    private MyActivityRecyclerViewAdapter myActivityRecyclerViewAdapter;

    /*Used to load dummy data*/
    private List<Activity> activities = new ArrayList<>();

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ActivityFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ActivityFragment newInstance(int columnCount) {
        ActivityFragment fragment = new ActivityFragment();
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
        View view = inflater.inflate(R.layout.fragment_activity_list, container, false);
        getActivity().setTitle("Activities");

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
            Comment loadDataWithRetrofit(); and load dummy data with this block
            activities.add(new Activity(1, "011", 1, new Date(), new Date(), "Other Details"));
            activities.add(new Activity(2, "121", 1, new Date(), new Date(), "Other Details 2"));
            activities.add(new Activity(3, "139", 2, new Date(), new Date(), "More Details none"));
            myActivityRecyclerViewAdapter = new MyActivityRecyclerViewAdapter(activities, mListener);
            recyclerView.setAdapter(myActivityRecyclerViewAdapter);*/

        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            mListener = new OnListFragmentInteractionListener() {
                @Override
                public void onListFragmentInteraction(Activity item) {

                }
            };
            /*throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");*/
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
        void onListFragmentInteraction(Activity item);
    }


    private void loadDataWithRetrofit() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);

        Call<ActivitiesDto> call = service.getActivities();

        call.enqueue(new Callback<ActivitiesDto>() {
            @Override
            public void onResponse(Call<ActivitiesDto> call, Response<ActivitiesDto> response) {
                myActivityRecyclerViewAdapter = new MyActivityRecyclerViewAdapter(response.body().getActivities(), mListener);
                recyclerView.setAdapter(myActivityRecyclerViewAdapter);
            }

            @Override
            public void onFailure(Call<ActivitiesDto> call, Throwable t) {

                Log.d(TAG, "onFailure: " + t.getMessage() + "\n");
                t.printStackTrace();
            }
        });
    }

}
