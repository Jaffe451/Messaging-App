package com.example.dnd.softwareengineeringdnd;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


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
                    TextMessage message = new TextMessage(((EditText) getActivity().findViewById(R.id.user_chat_input)).getText().toString(), new User("me"));
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


    public void addMessage(MessageType m){
        switch(m.getType()){
            case 0:
                 // text message
                ChatMessage toAdd = new ChatMessage(getContext(), m.getData(), (m.getSender().toString() != userName ));
                                                                                //userName is the user you are chatting with the 3rd argumetn being true means you sent the message
                                                                                //if these are not  equal you sent the message and the argument is true
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
