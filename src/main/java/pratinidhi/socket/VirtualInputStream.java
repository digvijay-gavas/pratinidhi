package pratinidhi.socket;

import java.io.IOException;
import java.io.InputStream;


public class VirtualInputStream extends InputStream {
	
	int buffer_size=0;
	byte[] buffer = new byte[buffer_size];
	int buffer_pointer=buffer_size-1;
	
	int available=0;
	int port;
	String uid;
	
	public VirtualInputStream(String uid, int port) {
		this.uid=uid;
		this.port=port;
	}
	
	private void load() throws Exception {
		
		//boolean isFileExistInDrive=false;
		if(buffer_pointer>=(buffer_size-1)) 
			synchronized (this) {
				wait();
			}
			/*while(true)
				if(cloudDrive.isFileExist(uid))
				{
						buffer=cloudDrive.downloadFile(uid);
						cloudDrive.deleteFile(uid);
						//isFileExistInDrive=true;
						//System.out.println(buffer);
						buffer_size=buffer.length;
						buffer_pointer=0;
						available=buffer_size-buffer_pointer;
						break;
				} 
				else 
				{
					Thread.sleep(1000);
				}
				*/
	}
	
	@Override
	public int read() throws IOException {
		try {
			load();
		} catch (Exception e1) {
			throw new IOException("Unable to read data");
		}
		while(available<=0)
			try {
				load();
			} catch (Exception e1) {
				throw new IOException("Unable to read data");
			}
			
		buffer_pointer++;
		available--;
		return buffer[buffer_pointer-1];
	}
	
	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		// this need to be improved as if available is some N value and N<(len-off) 
		//if(available<(len-off))
		//	return -1;
		int readlen=0;
		for (int i = off; i < len; i++) {
			if(available<=0)
				return -1;
			readlen++;
			b[i]=buffer[buffer_pointer];
			buffer_pointer++;
			available--;
		}
		return readlen;
	}
	@Override
	public int available() throws IOException {
		return available;
	}

}
