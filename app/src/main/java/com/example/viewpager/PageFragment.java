package com.example.viewpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class PageFragment extends Fragment {

    private int pageNumber;

    public static PageFragment newInstance(int page){
        PageFragment fragment=new PageFragment();
        Bundle args=new Bundle();
        args.putInt("num", page);
        fragment.setArguments(args);
        return fragment;
    }
    public PageFragment(){

    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        pageNumber=getArguments()!=null ? getArguments().getInt("num"):1;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View result=inflater.inflate(R.layout.fragment_page, container, false);
        TextView pageHeader=result.findViewById(R.id.displayText);
        switch (pageNumber){
            case 0:
                pageHeader.setText("Раз");
                break;
            case 1:
                result=inflater.inflate(R.layout.fragment_two, container, false);
                Button myBtn=result.findViewById(R.id.displayButton);
               final TextView myTxt=result.findViewById(R.id.displayText2);
                myBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String myStr="Кря";
                        myTxt.setText(myStr);
                        Toast.makeText(getActivity().getApplicationContext(), "бла бла", Toast.LENGTH_LONG).show();
                    }
                });


                break;
            case 2:
                pageHeader.setText("Три");
                break;
            case 3:
                pageHeader.setText("Четыре");
                break;
            case 4:
                pageHeader.setText("Пять");
                break;
            case 5:
                pageHeader.setText("Шесть");
                break;
            case 6:
                pageHeader.setText("Семь");
                break;
            case 7:
                pageHeader.setText("Восемь");
                break;
            case 8:
                pageHeader.setText("Девять");
                break;
            case 9:
                pageHeader.setText("Десять");
                break;
        }
        String header=String.format("Фрагмент %d", pageNumber+1);
        pageHeader.setText(pageHeader.getText().toString()+" "+header);
        return result;
    }
}
