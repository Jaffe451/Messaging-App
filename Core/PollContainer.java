package com.example.dnd.softwareengineeringdnd;

import java.util.ArrayList;

public class PollContainer {

    private ArrayList<PollOption> options;
    private int totalVotes;

    public PollContainer(){

        options = new ArrayList<PollOption>();

    }

    public void addOption(PollOption p){
        options.add(p);
    }

    /**
     *
     * @param p --> the poll option to find in the poll
     * @return --> the index of the poll option 0 based
     */
    public int findOption(PollOption p){
        return options.indexOf(p);
    }

    public void removeOption(PollOption p){
        options.remove(p);
    }

    public void removeOption(int i){
        options.remove(i);
    }

    public void vote(PollOption p){
        p.addVote();
        totalVotes++;
    }

    public void unVote(PollOption p){
        p.removeVote();
        totalVotes--;
    }

    public int getTotalVotes(){
        return totalVotes;
    }

}
