
import java.util.*;
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

public class JabberSmackAPI implements ConnectionListener, MessageListener, ChatMessageListener {
	
	private static XMPPTCPConnection connection;
	XMPPTCPConnectionConfiguration config;
		
	private static final String dHost = "54.158.25.184";
	 
    public void login(String userName, String password) throws XMPPException, SmackException, IOException, InterruptedException
    {
    	DomainBareJid serviceName = JidCreate.domainBareFrom("example.org");
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
 
    private void sendMessage(String body, String toJid) {
        try {
            Jid jid = JidCreate.from(toJid);
            Chat chat = ChatManager.getInstanceFor(connection).chatWith((EntityBareJid) jid);
            chat.send(body);
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
    		System.out.println(r.getUser());
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
    		c.sendMessage(msg, talkTo);
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
