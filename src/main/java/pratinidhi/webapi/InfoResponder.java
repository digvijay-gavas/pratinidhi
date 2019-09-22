package pratinidhi.webapi;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InfoResponder {

    @GetMapping("/webapi/get/pipeline")
    @ResponseBody
    public ResponseEntity<byte[]> getPipeline(@RequestHeader(name="page-size", required=false, defaultValue="10") int page_size) {
    	byte[] bytes= {65,65,68,0,10,45};
    	HttpHeaders headers = new HttpHeaders();
    	headers.add("page-size",""+ (page_size+1));
        return new ResponseEntity<byte[]>(bytes,headers,HttpStatus.OK);
    }

}
