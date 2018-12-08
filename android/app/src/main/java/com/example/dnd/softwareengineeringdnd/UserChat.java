package com.example.dnd.softwareengineeringdnd;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link UserChat.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link UserChat#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserChat extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String USER_NAME = "param1";

    // TODO: Rename and change types of parameters
    private String userName;

    private TextMessageAdapter adapter;

    private TextMessageViewModel mTextViewModel;

    private OnFragmentInteractionListener mListener;

    public UserChat() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param userName the string name of the user whose chat history you are viewing as stored in database to be used for queries

     * @return A new instance of fragment UserChat.
     */
    // TODO: Rename and change types and number of parameters
    public static UserChat newInstance(String userName) {
        UserChat fragment = new UserChat();
        Bundle args = new Bundle();
        args.putString(USER_NAME, userName);

        fragment.setArguments(args);
        //fragment.mTextViewModel = ViewModelProviders.of(fragment).get(TextMessageViewModel.class);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            userName = getArguments().getString(USER_NAME);
        }
    }

    @Override
    public void onResume(){
        super.onResume();

        //set Title
        ((TextView)getActivity().findViewById(R.id.user_chat_name)).setText(getString(R.string.user_chat_title_prefix) + " " + userName);

        //set Button Listener
        final Button submitButton = getActivity().findViewById(R.id.user_chat_submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText chatInput = ((EditText) getActivity().findViewById(R.id.user_chat_input));
                String text = chatInput.getText().toString();
                if(!(text.equals(""))) {
                    //if the message is not null
                    TextMessage message = new TextMessage(((EditText) getActivity().findViewById(R.id.user_chat_input)).getText().toString(),userName,true);
                    addMessage(message);
                }
                chatInput.setText("");
            }
        });

        //set submit on edit text to click the submit button
        EditText chatInput = ((EditText) getActivity().findViewById(R.id.user_chat_input));
        chatInput.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    submitButton.performClick();
                    return true;
                }
                return false;
            }
        });

/*
        RecyclerView recyclerView = getActivity().findViewById(R.id.recyclerview);
        adapter = new TextMessageAdapter(getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        mTextViewModel.getmLiveData().observe(this, new Observer<List<TextMessage>>() {
            @Override
            public void onChanged(@Nullable final List<TextMessage> message) {
                // Update the cached copy of the words in the adapter.
                adapter.setWords(message);
            }
        });
*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_chat, container, false);
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


    public void addMessage(TextMessage m){
        switch(m.getType()){
            case 0:
                 // text message
                ChatMessage toAdd = new ChatMessage(getContext(), m.getData(), m.getIsMe() );
                ((LinearLayout) getActivity().findViewById(R.id.user_chat_chatlog)).addView(toAdd);
                return;
            case 1:
                //image message
                //TODO impliment image message handling
                return;
            case 2:
                //audio message
                //TODO impliment audio message handling
                return;
        }
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
}
