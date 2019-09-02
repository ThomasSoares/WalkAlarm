package com.example.walkalarm.Fragments;

import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.walkalarm.Adapters.AlarmAdapter;
import com.example.walkalarm.Classes.Alarm;
import com.example.walkalarm.Listeners.RecyclerTouchListener;
import com.example.walkalarm.R;
import com.ramotion.cardslider.CardSliderLayoutManager;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AlarmFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AlarmFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AlarmFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private List<Alarm> alarmList=new ArrayList<>();
    private RecyclerView alarmRecyclerView;
    private AlarmAdapter alarmAdapter;
    private ImageButton addButton;

    public AlarmFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AlarmFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AlarmFragment newInstance(String param1, String param2) {
        AlarmFragment fragment = new AlarmFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View parentView= inflater.inflate(R.layout.fragment_alarm, container, false);

        alarmRecyclerView=parentView.findViewById(R.id.alarmRecyclerView);

        alarmAdapter=new AlarmAdapter(alarmList);

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int height = displaymetrics.heightPixels;
        int width = displaymetrics.widthPixels;

        if(width==1440)
        {
            width=1000;
        }
        else if(width==1080)
        {
            width=760;
        }

        RecyclerView.LayoutManager mLayoutManager=new CardSliderLayoutManager(50,width,12);
        alarmRecyclerView.setLayoutManager(mLayoutManager);
        alarmRecyclerView.setAdapter(alarmAdapter);


        prepareAlarmData();

        alarmRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(), alarmRecyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void OnClick(View view, int position) {

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        addButton=parentView.findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getContext(), "Test",Toast.LENGTH_SHORT).show();
            }
        });

        return parentView;
    }

    private void prepareAlarmData()
    {

        Alarm alarm=new Alarm("On","Weekends","05:00 AM","Carbon","30");
        alarmList.add(alarm);

        alarm=new Alarm("On","Weekends","05:00 AM","Carbon","30");
        alarmList.add(alarm);

        alarm=new Alarm("On","Weekends","05:00 AM","Carbon","30");
        alarmList.add(alarm);

        alarmAdapter.notifyDataSetChanged();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
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
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
