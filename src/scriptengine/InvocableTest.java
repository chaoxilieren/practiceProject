package scriptengine;
import javax.script.*;

public class InvocableTest {
    public static void main(String[] args) throws ScriptException,
            NoSuchMethodException {
        String script = " function greeting(message){println (message);}";
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript");
        engine.eval(script);

        if (engine instanceof Invocable) {
            Invocable invocable = (Invocable) engine;
            invocable.invokeFunction("greeting", "hi");

            // It may through NoSuchMethodException 
            try {
                invocable.invokeFunction("nogreeing");
            } catch (NoSuchMethodException e) {
                // expected
            }
        }
    }
}