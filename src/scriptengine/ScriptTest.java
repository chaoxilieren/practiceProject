package scriptengine;

import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ScriptTest {
    public static void main(String[] args) throws NoSuchMethodException,
	    InterruptedException {
	try {
	    ScriptEngineManager sem = new ScriptEngineManager();
	    ScriptEngine engine = sem.getEngineByName("JavaScript");

	    // 1
	    engine.put("msg", "just a test");
	    String str = "msg += '!!!';var user = {name:'tom',age:23,hobbies:['football','basketball']}; var name = user.name; var hb = user.hobbies[1];";
	    engine.eval(str);

	    String msg = (String) engine.get("msg");
	    String name = (String) engine.get("name");
	    String hb = (String) engine.get("hb");
	    System.out.println(msg);
	    System.out.println(name + ":" + hb);

	    // 2
	    engine.eval("function add (a, b) {c = a + b; return c; }");
	    Invocable jsInvoke = (Invocable) engine;

	    Object result1 = jsInvoke.invokeFunction("add", new Object[] { 10,
		    5 });
	    System.out.println(result1);
	    //3
	    Adder adder = jsInvoke.getInterface(Adder.class); 
	    int result2 = adder.add(10, 35); 
	    System.out.println(result2); 
	    // 4
	    engine.eval("function run() {println('www.java2s.com');}");
	    Invocable invokeEngine = (Invocable) engine;
	    Runnable runner = invokeEngine.getInterface(Runnable.class);
	    Thread t = new Thread(runner);
	    t.start();
	    t.join();
	    
	    // 5
	    String jsCode = "importPackage(java.util);var list2 = Arrays.asList(['A', 'B', 'C','d','e','f']); ";
	    engine.eval(jsCode);
	    @SuppressWarnings({"unchecked","fallthrough"})
		List<String> list2 = (List<String>) engine.get("list2");
	    for (String val : list2)
		System.out.println(val);

	} catch (ScriptException e) {
	}
    }
}

interface Adder { 
	int add(int a, int b); 
}
