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
	public static TheIOTClass instance;
	public static TheIOTClass newInstance(){
		return instance ==null?new TheIOTClass():instance; 
	}
	
	private TheIOTClass() {
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
				availableindexs.add(map.get(name));//»ØÊÕ
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
			"ÑîÇ±",
			"ºÎè¡",
			"Í¯Ã÷¿­",
			"ÍõìÏ",
			"ÖìÃ÷Ñ©",
			"ÁõÀö»ª",
			"ÏÄ¾ü",
			"³ÂÁèÁú",
			"ÀîÇ¬À¤",
			"Àî½Ü",
			"Áõ¼ªËÉ",
			"³ÂÈçÒâ",
			"Áúäì",
			"ÕÅÊ¥¿­",
			"ÕÔÒå",
			"¸ð¶«·½",
			"³ÂËÉ",
			"ÕÅÇïÆ½",
			"ÐìÓþ³©",
			"ÀîÔÂºì",
			"ÕÅº½",
			"»ªÃ÷½Ü",
			"Â¬³½",
			"ÖÜÎ°½Ü",
			"ÑîÔÂ",
			"Àîè¡",
			"³Â³Ê¾Ù",
			"ºÂÊ¥Á¢",
			"Ò¦ÍûÇÅ",
			"ÕÅÃ÷",
			"Àîµ£",
			"ËïÌÚ´ï",
			"ÂÞÊæÎÄ",
			"èï½¢",
			"ÍõºÆÓî"

	};

	public static void main(String[] args) throws InterruptedException, ExecutionException {
//		final TheIOTClass iot = newInstance();
//		
//		final String name = "Àîµ£";
//		System.out.println(iot.genRandomIndexForName(name));
//		iot.printinfo();
//		System.out.println(iot.genRandomIndexForName("ËïÌÚ´ï"));
//		iot.printinfo();
//		System.out.println(iot.genRandomIndexForName(name));
//		iot.printinfo();
//		final TheIOTClass iot2 = newInstance();
//		System.out.println(iot ==iot2);
//		iot2.printinfo();
//		
//		final TheIOTClass iot = new TheIOTClass();
//		ExecutorService myExecutor = Executors.newFixedThreadPool(8);
//		final String name = "Àîµ£";
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

}
