package pratinidhi.runtime;

import java.util.Vector;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import pratinidhi.router.Pipeline;
import pratinidhi.router.Router;
import pratinidhi.socket.Server;

public class Global {

	public static Pipeline<RequestEntity<byte[]>> requestEntries=new Pipeline<RequestEntity<byte[]>>();
	public static Pipeline<ResponseEntity<byte[]>> responseEntries=new Pipeline<ResponseEntity<byte[]>>();
	
	public static Vector<Server> servers=new Vector<Server>();
	public static Router router=new Router();
}
