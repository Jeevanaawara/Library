package library.codex.com.library;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SignIn.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SignIn#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SignIn extends Fragment {

    private OnFragmentInteractionListener mListener;
    private View view;

    public SignIn() {
        // Required empty public constructor
    }

    public static SignIn newInstance(String param1, String param2) {
        SignIn fragment = new SignIn();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.view = inflater.inflate(R.layout.fragment_sign_in, container, false);
        ((Button) this.view.findViewById(R.id.si_signIn_btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.signIn();
            }
        });
        ((Button) this.view.findViewById(R.id.si_toSignUp_btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.toSignUp();
            }
        });
        ((Button) this.view.findViewById(R.id.si_toForgetPassword_btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.toForgetPassword();
            }
        });
        return this.view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
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
        void toSignUp();
        void toForgetPassword();
        void signIn();
    }
}
