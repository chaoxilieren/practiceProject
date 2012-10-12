package scriptengine;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.SimpleScriptContext;

public class ScopeTest {
    public static void main(String[] args) throws Exception {
        String script=" println(greeting) ";
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript");
        
        //Attribute from ScriptEngineManager
        manager.put("greeting", "Hello from ScriptEngineManager");
        engine.eval(script);

        //Attribute from ScriptEngine
        engine.put("greeting", "Hello from ScriptEngine");
        engine.eval(script);

        //Attribute from eval method
        ScriptContext context = new SimpleScriptContext();
        context.setAttribute("greeting", "Hello from eval method", 
            ScriptContext.ENGINE_SCOPE);
        engine.eval(script,context);
        
    }
}