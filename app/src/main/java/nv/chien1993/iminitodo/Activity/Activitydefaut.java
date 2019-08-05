package nv.chien1993.iminitodo.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import nv.chien1993.iminitodo.R;

public abstract class Activitydefaut extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1. set Layout
        //2. set Fragment 1
        setContentView(setContentViewLayout());
        setupInitFragment(savedInstanceState);

    }

    public void setupInitFragment(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, setInitFragment())
                    .commit();
        }
    }

    public abstract int setContentViewLayout();

    public abstract Fragment setInitFragment();
}
