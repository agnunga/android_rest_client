package com.ag.timesheet.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ag.timesheet.R;
import com.ag.timesheet.fragments.ProjectFragment.OnListFragmentInteractionListener;
import com.ag.timesheet.models.Project;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Project} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyProjectRecyclerViewAdapter extends RecyclerView.Adapter<MyProjectRecyclerViewAdapter.ViewHolder> {

    private final List<Project> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyProjectRecyclerViewAdapter(List<Project> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_project, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.projectItem = mValues.get(position);
        holder.projIdView.setText(Long.toString(mValues.get(position).getId()));
        holder.projNameView.setText(mValues.get(position).getName());
        holder.projLocationView.setText(mValues.get(position).getLocation());
        holder.projCodeView.setText(mValues.get(position).getProject_code());
        holder.otherDetailsView.setText(mValues.get(position).getOther_details());
        holder.startDateView.setText(mValues.get(position).getStart_date());
        holder.endDateView.setText(mValues.get(position).getEnd_date());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.projectItem);
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
        public final TextView projIdView;
        public final TextView projNameView;
        public final TextView projLocationView;
        public final TextView projCodeView;
        public final TextView descriptionView;
        public final TextView otherDetailsView;
        public final TextView startDateView;
        public final TextView endDateView;
        public Project projectItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            projIdView      = (TextView) view.findViewById(R.id.proj_id);
            projNameView    = (TextView) view.findViewById(R.id.proj_name);
            projLocationView= (TextView) view.findViewById(R.id.proj_location);
            projCodeView    = (TextView) view.findViewById(R.id.proj_code);
            descriptionView = (TextView) view.findViewById(R.id.description);
            otherDetailsView= (TextView) view.findViewById(R.id.other_details);
            startDateView   = (TextView) view.findViewById(R.id.start_date);
            endDateView   = (TextView) view.findViewById(R.id.end_date);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + projLocationView.getText() + "'";
        }
    }
}
