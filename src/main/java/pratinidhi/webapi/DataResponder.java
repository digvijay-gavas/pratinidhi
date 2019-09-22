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
    public ResponseEntity<byte[]> read(@RequestHeader(name="page-size", required=false, defaultValue="10") int page_size) {
    	byte[] bytes= {65,65,68,0,10,45};
    	HttpHeaders headers = new HttpHeaders();
    	headers.add("page-size",""+ (page_size+1));
        return new ResponseEntity<byte[]>(bytes,headers,HttpStatus.OK);
    }
    
    @GetMapping("/webapi/write")
    @ResponseBody
    public ResponseEntity<byte[]> write(RequestEntity<byte[]> requestEntity) {
    	requestEntities.add(requestEntity);
        return new ResponseEntity<byte[]>(HttpStatus.OK);
    }

}
