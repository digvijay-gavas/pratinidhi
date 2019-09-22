package pratinidhi.router;

import java.util.Vector;

public class Pipeline<T> {
	Vector<T> ts=new Vector<T>();
	public T read() {
		T t=ts.firstElement();
		ts.remove(t);
		return t;		
	}
	
	public void write(T t) {
		ts.add(t);	
	}
}
