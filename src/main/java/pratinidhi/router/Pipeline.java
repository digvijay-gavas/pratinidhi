package pratinidhi.router;

import java.lang.reflect.Method;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.function.IntConsumer;

import pratinidhi.runtime.Global;

public class Pipeline<T> {
	Vector<T> ts=new Vector<T>();
	Vector<Callable<Object>> postWriteHook=new Vector<Callable<Object>>();
	public T read() {
		T t=ts.firstElement();
		ts.remove(t);
		return t;		
	}
	
	public void write(T t) {
		ts.add(t);
		//Global.router.wakeup();
		//for (Callable<Object> callable : postWriteHook) {
			//callable.call();
		//}
		
	}
	
	public void setPostWriteHook(Callable<Object> callable) {
		postWriteHook.add(callable);
	}
	

	public void print() {
		System.out.println("size is "+ ts.size()+" "+ts.getClass().getTypeName());
	}

}
