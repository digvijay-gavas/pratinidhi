package pratinidhi.router;

import java.util.concurrent.Callable;

import pratinidhi.runtime.Global;

public class Router implements Callable<Object> {



	@Override
	public Object call() throws Exception {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				Global.requestEntries.read();
				
			}
		}).start();

		return null;
	}

	public void start() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {


				
			}
		}).start();
	}

	
}
