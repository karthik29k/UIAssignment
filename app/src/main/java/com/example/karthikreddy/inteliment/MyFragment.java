package com.example.karthikreddy.inteliment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;

public class MyFragment extends Fragment {
    private static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    private String message;

    public static MyFragment newInstance(@NonNull String message) {
        MyFragment fragment = new MyFragment();
        Bundle bdl = new Bundle();
        bdl.putString(EXTRA_MESSAGE, message);
        fragment.setArguments(bdl);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container,
                             @NonNull Bundle savedInstanceState) {
        message = getArguments().getString(EXTRA_MESSAGE);
        View v = inflater.inflate(R.layout.myfragment_layout, container, false);
        TextView messageTextView = (TextView) v.findViewById(R.id.textView);
        messageTextView.setText(message);
        return v;
    }

    @OnClick(R.id.textView)
    public void onClicked() {
        // Create a Toast notification/message
        Toast toast = Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.show();
    }
}
