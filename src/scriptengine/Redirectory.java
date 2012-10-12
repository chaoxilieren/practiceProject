package scriptengine;

import java.io.BufferedReader;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.PrintWriter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Redirectory {
    public static void main(String[] args) throws Exception {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript");

        PipedReader pr = new PipedReader();
        PipedWriter pw = new PipedWriter(pr);
        PrintWriter writer = new PrintWriter(pw);
        engine.getContext().setWriter(writer);

        String script = "println('Hello from JavaScript')";
        engine.eval(script);
        
        BufferedReader br =new BufferedReader(pr);
        System.out.println(br.readLine());
    }
}