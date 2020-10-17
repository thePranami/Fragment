package com.example.thepranami.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentOne extends Fragment {
    Button send1;
    private View view;
    private TextView fragOneTextView;
    private SendTextListener sendTextListener;

    public FragmentOne() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_fragment_one, container, false);
        fragOneTextView=view.findViewById(R.id.fragOneTextView);
        send1 = view.findViewById(R.id.send1);

        send1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String string = fragOneTextView.getText().toString();
                sendTextListener.sendText(string);
            }
        });
        return view;
    }

    public void getFromSecond(String result){
        fragOneTextView.setText(result);
    }
    public void getColor(int color){
        send1.setBackgroundColor(color);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof SendTextListener){
            sendTextListener=(SendTextListener)context;
        }
        else {
            throw new RuntimeException(context.toString()
                    + " must implement SendTextListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        sendTextListener =null;
    }
}
