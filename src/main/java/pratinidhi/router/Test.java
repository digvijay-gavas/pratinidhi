package pratinidhi.router;

import java.io.PipedInputStream;
import java.nio.channels.Pipe;
import java.nio.channels.Pipe.SinkChannel;
import java.nio.channels.Pipe.SourceChannel;

public class Test {
	public static void main(String[] args) {
		Pipe pipe=new Pipe() {
			
			@Override
			public SourceChannel source() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public SinkChannel sink() {
				// TODO Auto-generated method stub
				return null;
			}
		};
	
	}
}
