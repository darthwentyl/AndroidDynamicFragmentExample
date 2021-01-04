package com.example.wyk5c1;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import com.example.wyk5c1.callback.ToolbarCallback;
import com.example.wyk5c1.listeners.CustomButtonListener;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ToolbarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ToolbarFragment extends Fragment {

    private ToolbarCallback _toolbarCallback;
    private EditText _editText;
    private SeekBar _seekBar;

    public ToolbarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ToolbarFragment.
     */
    public static ToolbarFragment newInstance() {
        ToolbarFragment fragment = new ToolbarFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            _toolbarCallback = (ToolbarCallback)context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implements ToolbarCallbac");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_toolbar, container, false);

        _editText = (EditText) view.findViewById(R.id.editTextPersonName);
        _seekBar = (SeekBar) view.findViewById(R.id.seekBar);

        Button changeButton = (Button) view.findViewById(R.id.changeButton);
        changeButton.setOnClickListener(new CustomButtonListener(_toolbarCallback, _editText, _seekBar));

        return view;
    }

}