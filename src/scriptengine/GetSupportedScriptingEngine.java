package scriptengine;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class GetSupportedScriptingEngine {
    public static void main(String[] args) {

        //创建一个ScriptEngineManager
        ScriptEngineManager manager = new ScriptEngineManager();
        //取得所有ScriptEngineFactory
        List<ScriptEngineFactory> factories = manager.getEngineFactories();
        //遍历输出
        for (ScriptEngineFactory factory : factories) {
            System.out.println("EngineName      = " + factory.getEngineName());
            System.out.println("EngineVersion   = " + factory.getEngineVersion());
            System.out.println("LanguageName    = " + factory.getLanguageName());
            System.out.println("LanguageVersion = " + factory.getLanguageVersion());
            System.out.println("Extensions      = " + factory.getExtensions());

            List<String> names = factory.getNames();
            for (String name : names) {
                System.out.println("Engine Alias = " + name);
            }
            
            //通过factory获取ScriptEngine
            ScriptEngine scriptEngine = factory.getScriptEngine() ;
            //ScriptEngine scriptEngine1 = manager.getEngineByExtension("js") ;其他方式获取
            //ScriptEngine scriptEngine2 = manager.getEngineByName("JavaScript") ;其他方式获取
            try {
            	//脚本引擎执行JavaScript语句
				scriptEngine.eval("var arr = new Array() ; arr.push(1); print(arr.pop())") ;
			} catch (ScriptException e) {
				e.printStackTrace();
			}
        }
    }
}