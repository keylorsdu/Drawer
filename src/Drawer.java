

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.weld.manager.api.ExecutorServices;

/**
 * Servlet implementation class Drawer
 */
class MyTask implements Callable<Integer> {
	TheIOTClass iot ;
	String name ;
	public MyTask(TheIOTClass iotclass,String name) {
		// TODO Auto-generated constructor stub
		iot = iotclass;
		name = name;
	}
	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		return iot.genRandomIndexForName(name);
	}
	
}
@WebServlet("/Drawer")
public class Drawer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	TheIOTClass iot = TheIOTClass.newInstance();
	ExecutorService myExecutor = Executors.newFixedThreadPool(8);
    public Drawer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		final String param=request.getParameter("name");
		final String name = new String(param.getBytes("ISO-8859-1"), "gb2312"); 
		System.out.println(name);
		//Future<Integer> Fidx = myExecutor.submit(new MyTask(iot, name));
		Future<Integer> Fidx = myExecutor.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				// TODO Auto-generated method stub
				return iot.genRandomIndexForName(name);
			}
		});
		response.setContentType( "text/html;charset=gb2312 ");
		PrintWriter pw = response.getWriter();
		try {
			int index = Fidx.get();
			System.out.println(index);
			pw.write(index+"<br>");
			pw.write("可用序号："+iot.availableindexs.toString()+"<br>");
			pw.write("已经生成："+iot.map.toString());
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(request.getParameter("name"));
	}

}
