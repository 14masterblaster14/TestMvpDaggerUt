package com.example.a22di;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import javax.inject.Inject;


/**
 * A simple {@link Fragment} subclass.
 */
public class AFragment extends Fragment implements View.OnClickListener {


    //Dagger Use
    @Inject
    SharedPreferences mPreferences;

    /*
     private SharedPreferences mPreferences; */
    private EditText mInputText;
    private Button mBtnStore;

    public AFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Dagger Use

        ((MyApplication) getActivity().getApplication()).getStorageComponent().inject(this);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

//coding starts..

    /*    @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            mPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        }
    */
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        mInputText = (EditText) view.findViewById(R.id.input_text);
        mBtnStore = (Button) view.findViewById(R.id.btn_store);
        mBtnStore.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        storeTextToPreferences();
    }

    private void storeTextToPreferences() {
        String text = mInputText.getText().toString().trim();
        if (text != null && !text.isEmpty()) {
            mPreferences.edit().putString(Constant.PREF_INPUT, text).apply();
        }
    }
}
