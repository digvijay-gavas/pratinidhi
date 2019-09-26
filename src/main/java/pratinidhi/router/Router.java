package pratinidhi.router;

import java.util.concurrent.Callable;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import pratinidhi.runtime.Global;

public class Router {
	
	public void setResponsePipeline(Pipeline<ResponseEntity<byte[]>> pipeline) {
		
		pipeline.setPostWriteHook(new Callable<Object>() {
			
			@Override
			public Object call() throws Exception {
				
				return null;
			}
		});
		
	}
	
	public void setRequestPipeline(Pipeline<RequestEntity<byte[]>> pipeline) {
		
		pipeline.setPostWriteHook(new Callable<Object>() {
			
			@Override
			public Object call() throws Exception {
				RequestEntity<byte[]> requestEntity=pipeline.read();
				Global.virtualSockets.get(requestEntity.getHeaders().get("uid").get(0)).getInputStream().write(requestEntity.getBody());
				return null;
			}
		});
	}
	
}
