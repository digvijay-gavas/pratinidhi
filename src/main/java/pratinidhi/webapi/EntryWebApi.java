package pratinidhi.webapi;

import java.io.PipedInputStream;
import java.nio.channels.Pipe;
import java.nio.channels.Pipe.SinkChannel;
import java.nio.channels.Pipe.SourceChannel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pratinidhi.runtime.Global;


@SpringBootApplication
public class EntryWebApi {
	public static void main(String[] args) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true)
				{
					Global.requestEntries.print();
					Global.responseEntries.print();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		}).start();
		Global.responseEntries.addPostWriteHook(Global.router);
		SpringApplication.run(EntryWebApi.class, args);
	}
}
