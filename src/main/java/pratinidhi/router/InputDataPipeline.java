package pratinidhi.router;

import java.io.PipedReader;
import java.util.Vector;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class InputDataPipeline {
	Vector<ResponseEntity<byte[]>> responseEntities=new Vector<ResponseEntity<byte[]>>();
	public ResponseEntity<byte[]> read() {
		ResponseEntity<byte[]> responseEntity=responseEntities.firstElement();
		responseEntities.remove(responseEntity);
		return responseEntity;		
	}
	
	public ResponseEntity<byte[]> write(ResponseEntity<byte[]> responseEntity) {
		responseEntities.add(responseEntity);
		return responseEntity;		
	}
	
	public static void main(String[] args) {
		InputDataPipeline dataPipeline=new InputDataPipeline();
		{
			byte[] bytes= {65,65,65};
	    	HttpHeaders headers = new HttpHeaders();
	    	headers.add("page-size",""+ 12);        
			dataPipeline.write(new ResponseEntity<byte[]>(bytes,headers,HttpStatus.OK));
		}
		{
			byte[] bytes= {66,66,66};
	    	HttpHeaders headers = new HttpHeaders();
	    	headers.add("page-size",""+ 13);        
			dataPipeline.write(new ResponseEntity<byte[]>(bytes,headers,HttpStatus.OK));
		}
		{
			byte[] bytes= {67,67,67};
	    	HttpHeaders headers = new HttpHeaders();
	    	headers.add("page-size",""+ 14);        
			dataPipeline.write(new ResponseEntity<byte[]>(bytes,headers,HttpStatus.OK));
		}
		{
			byte[] bytes= {68,68,68};
	    	HttpHeaders headers = new HttpHeaders();
	    	headers.add("page-size",""+ 15);        
			dataPipeline.write(new ResponseEntity<byte[]>(bytes,headers,HttpStatus.OK));
		}
		
		System.out.println(new String(dataPipeline.read().getBody()));
		System.out.println(new String(dataPipeline.read().getBody()));
		System.out.println(new String(dataPipeline.read().getBody()));
		System.out.println(new String(dataPipeline.read().getBody()));
		System.out.println(new String(dataPipeline.read().getBody()));
		
		
	}
}
