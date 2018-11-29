package com.example.dnd.softwareengineeringdnd;

public class PollOption {

    private MessageType data;
    private int votes;

    public PollOption(MessageType m){
        data = m;
    }

    public void addVote(){
        votes++;
    }

    public void removeVote(){
        votes--;
    }

    public int getVotes(){
        return votes;
    }

}
