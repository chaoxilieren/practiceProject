package scriptengine;

                
import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class CompilableTest {
    public static void main(String[] args) throws ScriptException {
        String script = " println (greeting); greeting= 'Good Afternoon!' ";
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript");
        engine.put("greeting", "Good Morning!");
        
        if (engine instanceof Compilable) {
            Compilable compilable = (Compilable) engine;
            CompiledScript compiledScript = compilable.compile(script);
            compiledScript.eval();
            compiledScript.eval();
        }
    }
}