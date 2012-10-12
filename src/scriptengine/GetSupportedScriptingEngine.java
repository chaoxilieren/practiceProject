package scriptengine;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class GetSupportedScriptingEngine {
    public static void main(String[] args) {

        //����һ��ScriptEngineManager
        ScriptEngineManager manager = new ScriptEngineManager();
        //ȡ������ScriptEngineFactory
        List<ScriptEngineFactory> factories = manager.getEngineFactories();
        //�������
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
            
            //ͨ��factory��ȡScriptEngine
            ScriptEngine scriptEngine = factory.getScriptEngine() ;
            //ScriptEngine scriptEngine1 = manager.getEngineByExtension("js") ;������ʽ��ȡ
            //ScriptEngine scriptEngine2 = manager.getEngineByName("JavaScript") ;������ʽ��ȡ
            try {
            	//�ű�����ִ��JavaScript���
				scriptEngine.eval("var arr = new Array() ; arr.push(1); print(arr.pop())") ;
			} catch (ScriptException e) {
				e.printStackTrace();
			}
        }
    }
}