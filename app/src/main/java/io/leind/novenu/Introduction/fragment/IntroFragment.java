package io.leind.novenu.Introduction.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.leind.novenu.R;

/**
 * Created by leind on 1/26/16.
 */
public class IntroFragment extends Fragment {
    @Bind(R.id.fragment_intro_textview) TextView introText;

    public static IntroFragment newInstance(int index) {
        IntroFragment fragment = new IntroFragment();
        Bundle args = new Bundle();
        args.putInt("index", index);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_intro_text, container, false);
        ButterKnife.bind(this, view);

        int index = getArguments().getInt("index", 0);
        setIntroText(index);

        return view;
    }

    public void setIntroText(int index) {
        switch (index) {
            case 0:
                introText.setText(getResources().getText(R.string.lorem_ipsum));
                break;
            case 1:
                introText.setText(getResources().getText(R.string.lorem_ipsum2));
                break;
            case 2:
                introText.setText(getResources().getText(R.string.lorem_ipsum3));
                break;
        }
    }
}
