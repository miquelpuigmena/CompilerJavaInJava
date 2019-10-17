package lang.ast;

import java.util.Set;
import java.util.TreeSet;
import java.io.PrintStream;
import java.util.Optional;
import java.util.Iterator;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
/**
 * @ast class
 * @aspect Interpreter
 * @declaredat /home/miquel/Documents/LTH/compilers/Lab5/A5-Interpreter/src/jastadd/Interpreter.jrag:139
 */
public class ActivationRecord extends java.lang.Object {
  
	    HashMap<String, Integer> map;

  

        public ActivationRecord() {
            this.map = new HashMap<>();
        }

  

        public void store(String name, Integer value) {
            this.map.put(name, value);
        }

  

        public int get(String name) {
            return this.map.get(name);
        }


}
