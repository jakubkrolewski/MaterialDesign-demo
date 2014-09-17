package com.allegrogroup.demo.material.transitions;

import android.app.Activity;
import android.os.Bundle;
import android.transition.Explode;
import com.allegrogroup.demo.material.R;

public class TransitionsBigGalleryActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setEnterTransition(new Explode());
        getWindow().setAllowEnterTransitionOverlap(true);

        setContentView(R.layout.activity_transitions_b);
    }
}
