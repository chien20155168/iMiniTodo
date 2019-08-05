package nv.chien1993.iminitodo.Activity;

import android.app.FragmentManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import nv.chien1993.iminitodo.Fragment.FragmentSetting;
import nv.chien1993.iminitodo.R;

public class ActivitySetting extends AppCompatActivity implements FragmentSetting.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

//        1
        Toolbar toolbar = findViewById(R.id.setiing_toolbar);
        setSupportActionBar(toolbar);

//        2
        openSettingFragmet();

    }

    private void openSettingFragmet() {
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.setting_containter, new FragmentSetting()).commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

}
