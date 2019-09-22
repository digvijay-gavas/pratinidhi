package pratinidhi.webapi;

import java.io.PipedInputStream;
import java.nio.channels.Pipe;
import java.nio.channels.Pipe.SinkChannel;
import java.nio.channels.Pipe.SourceChannel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class EntryWebApi {
	public static void main(String[] args) {
		SpringApplication.run(EntryWebApi.class, args);
	
	}
}
