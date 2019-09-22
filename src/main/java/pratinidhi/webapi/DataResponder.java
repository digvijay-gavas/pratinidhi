package pratinidhi.webapi;

import java.util.Vector;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

import pratinidhi.runtime.Global;

@Controller
public class DataResponder {
	
	/*
	 * read next pipelined request object to serve 
	 * 
	 */
	Vector<ResponseEntity<byte[]>> responseEntities=new Vector<ResponseEntity<byte[]>>();
	Vector<RequestEntity<byte[]>> requestEntities=new Vector<RequestEntity<byte[]>>();

    @GetMapping("/webapi/read")
    @ResponseBody
    public ResponseEntity<byte[]> read() {
        return Global.responseEntries.read();
    }
    
    @GetMapping("/webapi/write")
    @ResponseBody
    public ResponseEntity<byte[]> write(RequestEntity<byte[]> requestEntity) {
    	Global.requestEntries.write(requestEntity);
        return new ResponseEntity<byte[]>(HttpStatus.OK);
    }

}
