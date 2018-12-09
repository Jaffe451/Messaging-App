
import java.util.*;

import javax.swing.JTextPane;

import java.awt.TextArea;
import java.io.*;
 

import org.jivesoftware.smack.ConnectionConfiguration.*;
import org.jivesoftware.smack.ConnectionConfiguration.Builder;
import org.jivesoftware.smack.*;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.roster.Roster;
import org.jivesoftware.smack.roster.RosterEntry;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.jivesoftware.smackx.jiveproperties.packet.JivePropertiesExtension;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.chat2.ChatManager;
import org.jivesoftware.smack.chat2.Chat;
import org.jivesoftware.smack.chat.ChatMessageListener;
import org.jxmpp.*;
import org.jxmpp.jid.*;
import org.jxmpp.jid.impl.JidCreate;
import org.xml.*;
import org.minidns.*;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.filter.StanzaTypeFilter;
import org.jivesoftware.smack.packet.Stanza;

public class JabberSmackAPI implements ConnectionListener, MessageListener, ChatMessageListener {
	
	private static XMPPTCPConnection connection;
	private XMPPTCPConnectionConfiguration config;
	private StanzaListener packetListener;

		
	private static final String dHost = "54.158.25.184";
	 
    public void login(String userName, String password) throws XMPPException, SmackException, IOException, InterruptedException
    {
    	DomainBareJid serviceName = JidCreate.domainBareFrom("54.158.25.184");
    	XMPPTCPConnectionConfiguration config = XMPPTCPConnectionConfiguration.builder()
    			.setUsernameAndPassword(userName, password)
    			.setHost(dHost)
    			.setPort(5222)
    			.setXmppDomain(serviceName)
    			.setSecurityMode(ConnectionConfiguration.SecurityMode.disabled)
    			.build();
    	
    	connection = new XMPPTCPConnection(config);
    	connection.addConnectionListener(this);
    	connection.connect();
    	connection.login(userName, password);
    	
    }
    
    public void initializeStanzaListenerForChat(JTextPane ta) {
        packetListener = new StanzaListener() {
            public void processStanza(Stanza stanza) {
                if (stanza instanceof Message) {
                    Message message = (Message) stanza;
                    if (stanza instanceof Message) {
                    	if (message.getType() == Message.Type.chat && message.getBody() != null) {
                    		ta.setText(ta.getText() + "\n" + message.getFrom() + ": " + message.getBody());
                    	}
                    }
                    //the 1st character is the type of messsage 
                    /*
                     * 0 is for announcment
                     * 1 is for private message
                     * 2 is for poll
                     * 3 is for list update
                     */
                    /*
                    if(message.getError() != null) {
                    	System.out.println("Message Recieved in stanzalistner error: " + message.getError().toString());
                    }
                    
                    
                    System.out.println("message Recieved in stanazalistener body: " + message.getBody());
                    if(((message != null) && message.getBody()!=null)) {                    	                    
	                    newMessage.add(message.getBody().substring(0,1));
	                    newMessage.add(message.getFrom().toString());
	                    newMessage.add(message.getBody().substring(1, message.getBody().length()));                
                    }
                       */           
                }
            }
        };
       
       // The code below isn't necessarily wrong but we should properly filter it.
       // StanzaTypeFilter packetFilter = new StanzaTypeFilter(Message.class);
        StanzaTypeFilter packetFilter = null;
        // Create a stanza filter to listen for new messages from a particular
        // user. We use an AndFilter to combine two other filters._
        connection.addAsyncStanzaListener(packetListener, packetFilter);      
    }
 
    public void sendPrivateMessage(String body, String toJid) {
        try {
            EntityBareJid jid = JidCreate.entityBareFrom(toJid + "@" + dHost);
            Chat chat = ChatManager.getInstanceFor(connection).chatWith(jid);
            chat.send("1" + body);
        } catch (Exception e) {
        } 
   }
 
    public void displayBuddyList()
    {
    	Roster roster = Roster.getInstanceFor(connection);
    	Collection<RosterEntry> entries = roster.getEntries();
 
    	System.out.println("\n\n" + entries.size() + " buddy(ies):");
    	for(RosterEntry r:entries)
    	{
    		System.out.println(r.getName());
    	}
    }
 
    public void disconnect()
    {
    	connection.disconnect();
    }
 
    public void processMessage(Chat chat, Message message)
    {
    	if(message.getType() == Message.Type.chat) {
    		System.out.println(" says: " + message.getBody());
    	}
    }
 
    public static void main(String args[]) throws XMPPException, IOException, SmackException, InterruptedException
    {
    	// declare variables
    	JabberSmackAPI c = new JabberSmackAPI();
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String msg;
 
    	// Enter your login information here
    	c.login("andrew", "pass");
 
    	c.displayBuddyList();
 
    	System.out.println("-----");
 
    	System.out.println("Who do you want to talk to? - Type contacts full email address:");
    	String talkTo = br.readLine();
 
    	System.out.println("-----");
    	System.out.println("All messages will be sent to " + talkTo);
    	System.out.println("Enter your message in the console:");
    	System.out.println("-----\n");
 
    	while( !(msg=br.readLine()).equals("bye"))
    	{
    		c.sendPrivateMessage(msg, talkTo);
    	}
 
    	c.disconnect();
    	System.exit(0);

    }

	@Override
	public void processMessage(Message arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void authenticated(XMPPConnection arg0, boolean arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void connected(XMPPConnection arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void connectionClosed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void connectionClosedOnError(Exception arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processMessage(org.jivesoftware.smack.chat.Chat arg0, Message arg1) {
		// TODO Auto-generated method stub
		
	}
}
