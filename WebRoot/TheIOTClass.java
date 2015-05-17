import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TheIOTClass {
	Set<String> matesname = new HashSet<String>();
	Set<Integer> availableindexs = new HashSet<Integer>();
	ConcurrentMap<String, Integer> map = new ConcurrentHashMap<String, Integer>();
	public void printinfo(){
		System.out.println("available:"+availableindexs);
		System.out.println("map:"+map);
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		final TheIOTClass iot = new TheIOTClass();
		final String name = "¿Óµ£";
		System.out.println(iot.genRandomIndexForName(name));
		iot.printinfo();
		System.out.println(iot.genRandomIndexForName("ÀÔÃ⁄¥Ô"));
		iot.printinfo();
		System.out.println(iot.genRandomIndexForName(name));
		iot.printinfo();
		
//		final TheIOTClass iot = new TheIOTClass();
//		ExecutorService myExecutor = Executors.newFixedThreadPool(8);
//		final String name = "¿Óµ£";
//		Future<Integer> future = myExecutor.submit(new Callable<Integer>() {
//
//			@Override
//			public Integer call() throws Exception {
//				// TODO Auto-generated method stub
//				return iot.genRandomIndexForName(name);
//			}
//		});
//		System.out.println(future.get());
	}
	public TheIOTClass() {
		// TODO Auto-generated constructor stub
		initNames();
		initIndexs();
	}
	

	private void initIndexs() {
		// TODO Auto-generated method stub
		for (int i = 1; i <= matesname.size(); i++) {
			availableindexs.add(i);
		}

	}

	private void initNames() {
		// TODO Auto-generated method stub
		for(int i = 0;i<classmates.length;i++){
			matesname.add(classmates[i]);
		}

	}
	public synchronized int genRandomIndexForName(String name){
		if(matesname.contains(name)){
			int idx = getRandomIndex();
			put(name,idx);
			return idx;
		}
		return -1;
	}
	public synchronized void put(String name,int index){
		if(availableindexs.contains(index) && valid(name)){
			if(map.get(name)!=null){
				availableindexs.add(map.get(name));//ªÿ ’
			}
			map.put(name, index);
			availableindexs.remove(index);
		}
	}
	public synchronized boolean valid(String matenaem){
		return matesname.contains(matenaem);
	}
	public synchronized int getRandomIndex(){
		return getRandomElement(availableindexs);
	}
	public static <T> T getRandomElement(Collection<T> collection) {
		Iterator<T> it = collection.iterator();
		int rand = new Random().nextInt(100);
		if (collection.size() <= 0) {
			return null;
		}
		int size = collection.size();
		int index = rand % size;
		int i = 0;

		while (it.hasNext() && i < index) {
			it.next();
//			System.out.println();
			i++;
		}

		return it.next();
	}
	String[] classmates ={
			"—Ó«±",
			"∫ŒË°",
			"ÕØ√˜ø≠",
			"ÕıÏœ",
			"÷Ï√˜—©",
			"¡ı¿ˆª™",
			"œƒæ¸",
			"≥¬¡Ë¡˙",
			"¿Ó«¨¿§",
			"¿ÓΩ‹",
			"¡ıº™À…",
			"≥¬»Á“‚",
			"¡˙‰Ï",
			"’≈ •ø≠",
			"’‘“Â",
			"∏∂´∑Ω",
			"≥¬À…",
			"’≈«Ô∆Ω",
			"–Ï”˛≥©",
			"¿Ó‘¬∫Ï",
			"’≈∫Ω",
			"ª™√˜Ω‹",
			"¬¨≥Ω",
			"÷‹Œ∞Ω‹",
			"—Ó‘¬",
			"¿ÓË°",
			"≥¬≥ æŸ",
			"∫¬ •¡¢",
			"“¶Õ˚«≈",
			"’≈√˜",
			"¿Óµ£",
			"ÀÔÃ⁄¥Ô",
			"¬ﬁ ÊŒƒ",
			"ËÔΩ¢",
			"Õı∫∆”Ó"

	};

}
