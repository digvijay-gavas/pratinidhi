package pratinidhi.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class VirtualSocket extends Socket {
	VirtualInputStream virtualInputStream;
	VirtualOutputStream virtualOutputStream;
	String uid;
	int port;
	static String SERVER="SERVER";
	static String CLIENT="CLIENT";
	
	public VirtualSocket(String uid,int port) {
		virtualInputStream=new VirtualInputStream(uid,port);
		virtualOutputStream=new VirtualOutputStream(uid,port);
	}

	@Override
	public VirtualInputStream getInputStream() throws IOException {
		return virtualInputStream;
	}
	
	@Override
	public VirtualOutputStream getOutputStream() throws IOException {
		return virtualOutputStream;
	}
	
	@Override
	public synchronized void close() throws IOException {
		super.close();
	}
}
