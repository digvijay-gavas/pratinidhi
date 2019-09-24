package pratinidhi.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import pratinidhi.runtime.Global;


public class VirtualOutputStream extends OutputStream {
	int buffer_size=32768;
	byte[] buffer = new byte[buffer_size];
	int buffer_pointer=0;
	String uid;
	int port;
	
	public VirtualOutputStream(String uid,int port) {
		this.uid=uid;
		this.port=port;
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
		HttpHeaders headers = new HttpHeaders();
    	headers.add("port",""+port);
    	headers.add("uid-0",uid);
		ResponseEntity<byte[]> responseEntity=new ResponseEntity<byte[]>(Arrays.copyOfRange(buffer, 0, buffer_pointer), headers, HttpStatus.OK);
		Global.responseEntries.write(responseEntity);

	}

}
