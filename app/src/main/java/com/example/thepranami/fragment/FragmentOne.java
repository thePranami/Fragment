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
    Button fragTwo, childButton, btnclr;
    private View view;
    private TextView textView;
    private SendTextListener sendTextListener;

    public FragmentOne() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_fragment_one, container, false);
        fragTwo=view.findViewById(R.id.addfrag2);
        childButton=view.findViewById(R.id.addfrag2_child);
        textView = view.findViewById(R.id.frame1textview);
        btnclr = view.findViewById(R.id.btnclr);

        fragTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.test_container, new FragmentTwo()).commit();
            }
        });
        childButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getChildFragmentManager().beginTransaction()
                        .replace(R.id.frag_one_container, new FragmentTwo()).commit();
            }
        });
        btnclr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String string = textView.getText().toString();
                sendTextListener.sendText(string);
            }
        });
        return view;
    }

    public void getData(String result){
        textView.setText(result);
        Log.e("aaaaaa", "getData: "+result );
    }
    public void getColor(int color){
        btnclr.setBackgroundColor(color);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof SendTextListener){
            sendTextListener=(SendTextListener)context;
        }else {
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
