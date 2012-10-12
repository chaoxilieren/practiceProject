package scriptengine;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.SimpleBindings;

import org.apache.commons.io.IOUtils;

public class ScriptEngineForJavaScriptTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Config config = buildConfig() ;
		System.out.println(config.toString());
	}

	public static Config buildConfig(){
		ClassLoader _classLoad = Thread.currentThread().getContextClassLoader() ;
		URL url = _classLoad.getResource("config.js") ;
		Map<String, Object> _bindings = new HashMap<String, Object>() ;
		Config config = new Config() ;
		
		_bindings.put("config", config) ;
		String _scriptContext = null ;
		Reader _reader = null ;
		
		try{
			_reader = new InputStreamReader(url.openStream(), "UTF-8") ;
			_scriptContext = IOUtils.toString(_reader) ;
		}catch(IOException e){
			throw new IllegalStateException("can't load config from url["+url+"]") ;
		}
		ScriptEngineManager factory = new ScriptEngineManager() ;
		ScriptEngine engine = factory.getEngineByName("JavaScript") ;
		Bindings buindings = new SimpleBindings(_bindings) ;
		try{
			engine.eval(_scriptContext, buindings) ;
		}catch(Exception e){
			
		}
		return config ; 
	}
}
