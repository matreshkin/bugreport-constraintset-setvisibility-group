package com.matreshkin.bugreport.constraintsetgroupbug;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Group;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // This fixes the behaviour
        // setContentView(R.layout.activity_main_workaround);

        ConstraintLayout parent = findViewById(R.id.parent);
        parent.setOnClickListener(v -> toggleVisibility(parent));
    }

    private void toggleVisibility(ConstraintLayout parent) {
        ConstraintSet constraintSet = new ConstraintSet();
        View child = parent.findViewById(R.id.child);
        int newVisibility = child.getVisibility() == View.GONE ? View.VISIBLE : View.GONE;
        constraintSet.clone(parent);
        constraintSet.setVisibility(R.id.group, newVisibility);
        constraintSet.applyTo(parent);
    }
}