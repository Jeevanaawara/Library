package library.codex.com.library;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import library.codex.com.library.adapter.BooksListViewAdapter;
import library.codex.com.library.adapter.CategorySpinnerAdapter;
import library.codex.com.library.bean.Category;



public class Home extends Fragment implements NavigationView.OnNavigationItemSelectedListener, AdapterView.OnItemSelectedListener {

    private OnFragmentInteractionListener mListener;
    private Spinner categorySpinner;
    private ArrayAdapter<Category> categorySpinnerAdapter = null;
    List<Category> categoryList = new ArrayList<>();
    private Category selectedCategory = null;
    private ListView booksListView;
    private ListAdapter booksListViewAdapter;
    private static final String TAG = "LIBRARY-APP";


    public Home() {
        // Required empty public constructor
    }

    public static Home newInstance() {
        Home fragment = new Home();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.view = inflater.inflate(R.layout.fragment_home, container, false);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) view.findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                getActivity(), drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) view.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        populateCategory();
        this.categorySpinner = (Spinner) view.findViewById(R.id.category_spr);
        this.categorySpinnerAdapter = new CategorySpinnerAdapter(getContext(), categoryList);
        this.categorySpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.categorySpinner.setAdapter(categorySpinnerAdapter);
        this.categorySpinner.setOnItemSelectedListener(this);

        this.booksListView = (ListView) view.findViewById(R.id.books_lv);

        booksListViewAdapter = new BooksListViewAdapter(getContext(), selectedCategory);
        this.booksListView.setAdapter(booksListViewAdapter);


        return this.view;
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
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }


//    Start Spinner
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Log.i(TAG, "Spinner:onItemSelected: i="+i+", l:"+l);
        populateBooks(i,l);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void populateBooks(int i, long l) {
        Log.i(TAG, "populateBooks, i: "+i+", l: ");
//        bo
    }

    private void populateCategory() {
        Category category = new Category();
        category.setId(1);
        category.setTitle("Science");
        this.categoryList.add(category);
        this.categoryList.add(category);
    }

//    End Spinner

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
}
