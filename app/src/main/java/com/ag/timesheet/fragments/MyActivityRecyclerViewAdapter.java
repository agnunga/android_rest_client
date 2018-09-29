package com.ag.timesheet.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ag.timesheet.R;
import com.ag.timesheet.fragments.ActivityFragment.OnListFragmentInteractionListener;
import com.ag.timesheet.helper.Timings;
import com.ag.timesheet.models.Activity;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Activity} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyActivityRecyclerViewAdapter extends RecyclerView.Adapter<MyActivityRecyclerViewAdapter.ViewHolder> {

    private final List<Activity> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyActivityRecyclerViewAdapter(List<Activity> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_activity, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).getCode());
        holder.otherDetailsView.setText(mValues.get(position).getOther_details());
        holder.startDateDiew.setText(Timings.getDate(mValues.get(position).getStart_date()));
        holder.endDateDiew.setText(Timings.getDate(mValues.get(position).getEnd_date()));

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView otherDetailsView;
        public final TextView startDateDiew;
        public final TextView endDateDiew;
        public Activity mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.item_number);
            otherDetailsView = (TextView) view.findViewById(R.id.other_details);
            startDateDiew = (TextView) view.findViewById(R.id.start_date);
            endDateDiew = (TextView) view.findViewById(R.id.end_date);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + otherDetailsView.getText() + "'";
        }
    }
}
