package pratinidhi.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class VirtualSocket extends Socket {
	VirtualInputStream virtualInputStream;
	VirtualOutputStream virtualOutputSteam;
	String uid;
	int port;
	static String SERVER="SERVER";
	static String CLIENT="CLIENT";
	
	public VirtualSocket(String uid,int port) {
		virtualInputStream=new VirtualInputStream(uid,port);
		virtualOutputSteam=new VirtualOutputStream(uid,port);
	}

	@Override
	public InputStream getInputStream() throws IOException {
		return virtualInputStream;
	}
	
	@Override
	public OutputStream getOutputStream() throws IOException {
		return virtualOutputSteam;
	}
	
	@Override
	public synchronized void close() throws IOException {
		super.close();
	}
}
