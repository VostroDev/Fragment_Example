package com.vostro.fragment_example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class DialogX extends DialogFragment{

    private View.OnClickListener mBtnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dismiss();
            ((MainActivity)getActivity()).swopFragment(v);  // this is how to call method in main activity from fragment.
        }
    };

    public DialogX() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.dialog_fragment_x, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button mBtnOk = (Button) view.findViewById(R.id.btn_dialogfragment_ok);
        mBtnOk.setOnClickListener(mBtnClickListener);

    }
}

