package com.example.dnd.softwareengineeringdnd;

import java.util.ArrayList;
import java.util.List;

public class ListContainer {

    private ArrayList<ListElement> data;
    private ArrayList<User> users;

    public ListContainer(User maker){

        users = new ArrayList<User>();
        users.add(maker);

        data = new ArrayList<ListElement>();

    }

    public void addUser(User person){
        users.add(person);
    }

    public void removeUser(User person){
        users.remove(person);
    }

    public ArrayList<ListElement> getData(){
        return data;
    }

    public void addElement(ListElement e){
        data.add(e);
    }

    public int findElement(ListElement e){
        return data.indexOf(e);
    }

    public void removeElement(ListElement e){
        data.remove(e);
    }

    public void removeElement(int i){
        data.remove(i);
    }

}
