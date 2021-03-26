package server.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class Demo {

	public static void main(String[] args) {
//		Singleton singleton1 = new Singleton();
//		Singleton singleton2 = new Singleton();
//		Singleton singleton3 = new Singleton();
//		Singleton singleton4 = new Singleton();

		Singleton singleton1 = Singleton.getInstance();
		Singleton singleton2 = Singleton.getInstance();
		System.out.println(singleton1 == singleton2);

		Singleton1 s1 = Singleton1.getInstance();
		Singleton1 s2 = Singleton1.getInstance();
		System.out.println(s1 == s2);
	}

	@Test
	public void test3() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(78);
		list.add(34);
		Integer max = Collections.max(list);
		System.out.println(max);
		double i = Math.floor(3.14);
		// Arrays.binarySearch(a, key)

		Collection<Integer> list2 = new ArrayList<Integer>();

	}

	@Test
	public void test33() {
		Collection<String> collection = new ArrayList<>();
		collection.add("张三");
		collection.add("李四");
		collection.add("王五");
		collection.add("张三");
		System.out.println(collection);
		collection.remove("张三");
		System.out.println(collection);
		// Object[] array = collection.toArray();

		for (String string : collection) {
			System.out.println(string);
		}

	}

	@Test
	public void test334() {
		Collection<String> collection = new ArrayList<>();
		collection.add("张三");
		collection.add("李四");
		collection.add("王五");
		collection.add("张三");

		Iterator<String> iterator = collection.iterator();
		while (iterator.hasNext()) {
			String data = iterator.next();
			System.out.println(data);
		}
	}

	@Test
	public void test44() {
		List<String> list = new ArrayList<String>();
		list.add("abc1");
		list.add("abc2");
		list.add("abc3");
		list.add("abc4");

		list.add(2, "Java");// List接口所特有方法
		// 在迭代时，不要使用集合的方法操作元素。
		for (String string : list) {
			System.out.println(string);
//			if (string.equals("Java")) {// 并发（concurrent）
//				list.add("php");// java.util.ConcurrentModificationException
//			}
		}

		System.out.println("-------------------");
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String data = iterator.next();
			System.out.println(data);
//			if (data.equals("Java")) { // 使用ListIterator
//				list.add("php");
//			}
		}
		System.out.println("-------------------");
	}

	@Test
	public void test45() {
		List<String> list = new ArrayList<String>();
		list.add("abc1");
		list.add("abc2");
		list.add("abc3");
		list.add("abc4");

		list.add(2, "Java");// List接口所特有方法
		for (String string : list) {
			System.out.println(string);
//			if (string.equals("Java")) {// 并发（concurrent）
//				list.remove(string);// java.util.ConcurrentModificationException
//			}
		}

		System.out.println("-------------------");
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String data = iterator.next();
			System.out.println(data);
			if (data.equals("Java")) { // 使用ListIterator
				// list.remove(data);
				iterator.remove();// 不是使用集合的方法移除，使用的是迭代器的方法移除
			}
		}
		System.out.println("-------------------");
	}

	@Test
	public void test55() {
		LinkedList<String> link = new LinkedList<String>();
		// 添加元素
		link.addFirst("abc1");
		link.addFirst("abc2");
		link.addFirst("abc3");
		// 获取元素
		System.out.println(link.getFirst());
		System.out.println(link.getLast());
		// 删除元素
		System.out.println(link.removeFirst());
		System.out.println(link.removeLast());

//	   while(!link.isEmpty()){ //判断集合是否为空
		while (link.isEmpty() == false) { // 判断集合是否为空
			System.out.println(link.pop()); // 弹出集合中的栈顶元素
		}
	}

	@Test
	public void test49() {
		// 创建Map对象
		Map<String, String> map = new HashMap<String, String>();
		// 给map中添加元素
		map.put("邓超", "孙俪");
		map.put("李晨", "范冰冰");
		map.put("刘德华", "柳岩");
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			String value = map.get(key);
			System.out.println(value);
		}
	}
	
	@Test
	public void test50() {
		// 创建Map对象
		Map<String, String> map = new HashMap<String, String>();
		// 给map中添加元素
		map.put("邓超", "孙俪");
		map.put("李晨", "范冰冰");
		map.put("1刘德华", "柳岩");
		Set<Entry<String, String>> entrySet = map.entrySet();
		for (Entry<String, String> entry : entrySet) {
			System.out.println(entry.getKey() + "," + entry.getValue());
		}
		System.out.println("---------");
		Iterator<Entry<String, String>> iterator = entrySet.iterator();
		while (iterator.hasNext()) {
			Entry<String, String> entry = iterator.next();
			System.out.println(entry.getKey() + "," + entry.getValue());
		}
	}
	
	@Test
	public void test414() {
		Map<String, String> mp = new HashMap<String, String>();
		for (int i=0; i<10; i++) {
			mp.put("key" + i, "value" + i);
		}
		for (Map.Entry<String, String> entry : mp.entrySet()) {
			System.out.println(entry.getKey() + "-" + entry.getValue());
		}
		
	}
	
	@Test
	public void test344() {
		Map<String, String> mp = new LinkedHashMap<String, String>();
		for (int i=0; i<10; i++) {
			mp.put("key" + i, "value" + i);
		}
		for (Map.Entry<String, String> entry : mp.entrySet()) {
			System.out.println(entry.getKey() + "-" + entry.getValue());
		}
	}
	
	@Test
	public void test551() {
	  // 创建HashSet对象
	   Set<String> set = new HashSet<String>();
	   // 给集合中添加自定义对象
	   set.add("zhangsan");
	   set.add("lisi");
	   set.add("wangwu");
	   set.add("zhangsan");
	   set.add(new String("lisi"));
	   for (String string : set) {
		   System.out.println(string);
	   }
	}
	
	@Test
	public void test552() {
	   Set<Student> set = new HashSet<Student>();
	   Student student1 = new Student(1, "zhangsan", 20);
	   Student student2 = new Student(1, "zhangsan", 20);
	   set.add(student1);
	   set.add(student2);
	   for (Student student : set) {
		  System.out.println(student);
	   }
	}
	
	@Test
	public void test5522() {
	   Set<String> set = new LinkedHashSet<String>();
	   set.add("zhangsan");
	   set.add("lisi");
	   set.add("wangwu");
	   set.add("zhangsan");
	   for (String string : set) {
		   System.out.println(string);
	   }
	}
	
	@Test
	public void test5() {
	    TreeSet<Student> treeSet = new TreeSet<>();
	    treeSet.add(new Student(1, "张三", 23));
	    treeSet.add(new Student(2, "aaa", 13));
	    treeSet.add(new Student(3, "abb", 13));
	    treeSet.add(new Student(3, "aab", 13));
	    treeSet.add(new Student(4, "王五", 43));
	    treeSet.add(new Student(5, "赵六", 33));
	   
	    System.out.println(treeSet);
	}
}
