package pratinidhi.runtime;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import pratinidhi.router.Router;
import pratinidhi.socket.Server;

public class Main {
	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
		//System.out.println(Arrays.toString(Config.ports));
		//int[] numbers = Arrays.stream("[5001, 7885, 6524]".replace('[', ' ').replace(']', ' ').replaceAll(" ", "").split(",")).mapToInt(Integer::parseInt).toArray(); 
		//Global.router=new Router();
		//Global.router.start();
		//Config.save("C:\\Users\\49151\\Desktop\\work\\workspace\\config");
		Runnable runnable
		=new Runnable() {
			
			@Override
			public void run() {
				System.out.println(System.currentTimeMillis()+"waiting... ");
				try {
					Thread.sleep(500);
					System.out.println(System.currentTimeMillis()+"working1 .... ");
					Thread.sleep(500);
					System.out.println(System.currentTimeMillis()+"working2 .... ");
					Thread.sleep(1000);
					synchronized (this) {
						wait();
					}
					
					System.out.println(System.currentTimeMillis()+"notified... ");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			@Override
			public String toString() {
				System.out.println(System.currentTimeMillis()+"test..");
				return super.toString();
			}
		
		};
		new Thread(runnable).start();
		
		Thread.sleep(1000);
		runnable.toString();
		Thread.sleep(1000);
		synchronized (runnable) {
			System.out.println();
			runnable.notify();
		}
		
		
		ExecutorService executorService=Executors.newCachedThreadPool();
		for (int i = 0; i < Config.ports.length; i++) {
			Global.servers.add(new Server(Config.ports[i]));
			executorService.submit(Global.servers.lastElement());
		}
	}
}
