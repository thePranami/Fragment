package com.example.thepranami.fragment;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTwo extends Fragment{
   Button send2;
   private EditText fragTwoEditText;
   private SendTextListener sendTextListener;


    public FragmentTwo() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_two, container, false);

     send2=view.findViewById(R.id.send2);
     fragTwoEditText=view.findViewById(R.id.fragTwoEditText);

     send2.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             sendTextListener.sendText(fragTwoEditText.getText().toString());
             sendTextListener.changeButtonColor(R.color.colorDarkRed);
         }
     });
        return view;
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
    public void getFromFirst(String data){
        fragTwoEditText.setText(data);
    }
}
