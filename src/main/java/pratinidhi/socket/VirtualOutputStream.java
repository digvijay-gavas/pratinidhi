package pratinidhi.socket;

import java.io.IOException;
import java.io.OutputStream;


public class VirtualOutputStream extends OutputStream {
	int buffer_size=32768;
	byte[] buffer = new byte[buffer_size];
	int buffer_pointer=0;
	String uid;
	
	public VirtualOutputStream(Object cloudDrive,String uid) {
		this.uid=uid;
	}
	
	@Override
	public void write(int b) throws IOException {
		if (buffer_pointer>=buffer_size)
			flush();
		buffer[buffer_pointer]=(byte)b;
		buffer_pointer++;
	}
	
	@Override
	public void write(byte[] b, int off, int len) throws IOException {
		//System.out.write(b, off, len);
		for (int i = off; i < len; i++) {
			write(b[i]);
		}
	}
	
	@Override
	public void flush() throws IOException {
	
		
		//System.out.println("Flushed ");
	}

}
