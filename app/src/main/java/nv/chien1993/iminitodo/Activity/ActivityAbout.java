package nv.chien1993.iminitodo.Activity;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import nv.chien1993.iminitodo.Fragment.FragmentAbout;
import nv.chien1993.iminitodo.R;

public class ActivityAbout extends Activitydefaut implements FragmentAbout.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public int setContentViewLayout() {
        return R.layout.activity_about;
    }

    @Override
    public Fragment setInitFragment() {
        return FragmentAbout.newInstance(null, null);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        //
    }
}
