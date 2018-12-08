package com.example.dnd.softwareengineeringdnd;

import java.util.ArrayList;

public abstract class MessageType {

    /**
     * Returns a string containing either the raw text data of the message or a PATH to the file containing the data
     * The type of data returned from this function can be accessed via the getType() function in this class
     *
     * As defined in messagetypes.xml
     *          0 is for raw text
     *          1 is for image
     *          2 is for audio
     *
     * Params: none
     *
     * @return
     */
    public abstract String getData();

    public abstract int getType();

    public abstract String getOtherUser();

    public abstract boolean getIsMe();

}
