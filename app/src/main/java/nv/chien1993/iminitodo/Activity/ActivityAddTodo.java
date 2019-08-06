package nv.chien1993.iminitodo.Activity;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import nv.chien1993.iminitodo.Fragment.FragmentAddtodo;
import nv.chien1993.iminitodo.R;

public class ActivityAddTodo extends Activitydefaut implements FragmentAddtodo.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public int setContentViewLayout() {
        return R.layout.activity_fragment_add_todo;
    }

    @Override
    public Fragment setInitFragment() {
        return FragmentAddtodo.newInstance(null, null);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
