package com.ag.timesheet.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ag.timesheet.R;
import com.ag.timesheet.fragments.CostCentreFragment.OnListFragmentInteractionListener;
import com.ag.timesheet.models.CostCentre;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link com.ag.timesheet.models.CostCentre} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyCostCentreRecyclerViewAdapter extends RecyclerView.Adapter<MyCostCentreRecyclerViewAdapter.ViewHolder> {

    private final List<CostCentre> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyCostCentreRecyclerViewAdapter(List<CostCentre> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_costcentre, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.ccIdView.setText(Long.toString(mValues.get(position).getId()));
        holder.ccNameView.setText(mValues.get(position).getName());

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

        return mValues == null? 0 : mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView ccIdView;
        public final TextView ccNameView;
        public CostCentre mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            ccIdView = (TextView) view.findViewById(R.id.cc_id);
            ccNameView = (TextView) view.findViewById(R.id.cc_name);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + ccNameView.getText() + "'";
        }
    }
}