package com.example.wyk5c1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TextFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TextFragment extends Fragment {

    private enum BundleKey {
        FONT_SIZE,
        TEXT
    }

    private TextView _textView;

    public TextFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param fontSize font size parameter
     * @param text text to show in TextLabel
     * @return A new instance of fragment TekstFragment.
     */
    public static TextFragment newInstance(int fontSize, String text) {
        TextFragment fragment = new TextFragment();
        Bundle args = new Bundle();
        args.putInt(BundleKey.FONT_SIZE.toString(), fontSize);
        args.putString(BundleKey.TEXT.toString(), text);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tekst, container, false);
        _textView = (TextView) view.findViewById(R.id.textView);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getArguments() != null) {
            int fontSize = getArguments().getInt(BundleKey.FONT_SIZE.toString());
            String text = getArguments().getString(BundleKey.TEXT.toString());
            changeTextProperties(fontSize, text);
        }
    }

    private void changeTextProperties(int fontSize, String text) {
        _textView.setTextSize(fontSize);
        _textView.setText(text);
    }
}