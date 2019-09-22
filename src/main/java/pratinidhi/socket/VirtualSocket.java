package pratinidhi.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class VirtualSocket extends Socket {
	VirtualInputStream virtualInputStream;
	VirtualOutputStream virtualOutputSteam;
	String uid;
	static String SERVER="SERVER";
	static String CLIENT="CLIENT";
	
	public VirtualSocket(String uid,String type) {
			virtualInputStream=new VirtualInputStream(uid);
			virtualOutputSteam=new VirtualOutputStream("",uid);
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
