package nv.chien1993.iminitodo.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nv.chien1993.iminitodo.Activity.ActivityAddTodo;
import nv.chien1993.iminitodo.Activity.ActivityMain;
import nv.chien1993.iminitodo.Adapter.AdapterTodo;
import nv.chien1993.iminitodo.Model.ToDoItem;
import nv.chien1993.iminitodo.R;

import static nv.chien1993.iminitodo.Fragment.ConSt.DATA_TODOITEM;
import static nv.chien1993.iminitodo.Fragment.ConSt.SEND_REMIND_CODE;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentMain.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentMain#newInstance} factory method to
 * create an instance of this fragment.
 */

public class FragmentMain extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView toDoRcv;

    private OnFragmentInteractionListener mListener;
    private List<ToDoItem> listapp;
    private AdapterTodo toDoAdapter;

    public FragmentMain() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentMain.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentMain newInstance(String param1, String param2) {
        FragmentMain fragment = new FragmentMain();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //0
        toDoRcv = view.findViewById(R.id.todoRcview);

        //1
        listapp = ((ActivityMain)getActivity()).getToDoItems();
        toDoAdapter = new AdapterTodo(getActivity(), new AdapterTodo.ClickItemRcv() {
            @Override
            public void onClickItemRcv(int posItem) {
                //

            }
        }, listapp);
        toDoRcv.setAdapter(toDoAdapter);

        //2
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        toDoRcv.setLayoutManager(linearLayoutManager);

        //3
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        toDoRcv.addItemDecoration(dividerItemDecoration);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_fragment_main, container, false);

        FloatingActionButton add = v.findViewById(R.id.addNotice);
        add.setOnClickListener(this);


        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addNotice:
                openEdit();
                return ;
        }


    }

    private void openEdit() {
        Intent intent = new Intent(getActivity(), ActivityAddTodo.class);
        startActivityForResult(intent,SEND_REMIND_CODE);

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SEND_REMIND_CODE) {

            ToDoItem toDoItem = (ToDoItem) data.getSerializableExtra(DATA_TODOITEM);
            addDataAndUpdateListView(toDoItem);

            //co thong tin
            List<ToDoItem> toDoItems = ((ActivityMain)getActivity()).getToDoItems();
            toDoItems.add(toDoItem);
            toDoAdapter.notifyDataSetChanged();
        }
    }

    private void addDataAndUpdateListView(ToDoItem toDoItem) {

    }
}
