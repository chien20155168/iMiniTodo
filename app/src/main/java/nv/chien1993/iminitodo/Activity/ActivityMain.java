package nv.chien1993.iminitodo.Activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import nv.chien1993.iminitodo.Activity.ActivityAbout;
import nv.chien1993.iminitodo.Fragment.FragmentMain;
import nv.chien1993.iminitodo.R;

public class ActivityMain extends Activitydefaut implements FragmentMain.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toolbar toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);

    }

    @Override
    public int setContentViewLayout() {
        return R.layout.activity_main;
    }

    @Override
    public Fragment setInitFragment() {
        return FragmentMain.newInstance(null,null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                Intent intent = new Intent(this, ActivityAbout.class);
                startActivity(intent);
                return true;
            case R.id.setting:
                openSettingAct();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void openSettingAct() {
        Intent intent = new Intent(this, ActivitySetting.class);
        startActivity(intent);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

}
