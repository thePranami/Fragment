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
   Button btn, result;
   private EditText editText;
   private SendTextListener sendTextListener;


    public FragmentTwo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_two, container, false);

     /*   btn = (Button)view.findViewById(R.id.bt);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.main, new FragmentTwo());
                ft.commit();
            }
        });       */
     result=view.findViewById(R.id.resultButton);
     editText=view.findViewById(R.id.frame2edittext);

     result.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             String string = editText.getText().toString();
             //CharSequence input = editText.getText();
             String msg = "helloooo";
             sendTextListener.sendText(string);
             sendTextListener.changeButtonColor(R.color.colorDarkRed);
         }
     });
        return view;
    }

//    public interface SendTextListener{
//        void sendText(String text);
//        void changeButtonColor(int color);
//    }

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

    public void getDataaa(String data){
        editText.setText(data);
    }
}
