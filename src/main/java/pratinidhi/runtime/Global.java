package pratinidhi.runtime;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import pratinidhi.router.Pipeline;

public class Global {

	public static Pipeline<RequestEntity<byte[]>> requestEntries=new Pipeline<RequestEntity<byte[]>>();
	public static Pipeline<ResponseEntity<byte[]>> responseEntries=new Pipeline<ResponseEntity<byte[]>>();
}
