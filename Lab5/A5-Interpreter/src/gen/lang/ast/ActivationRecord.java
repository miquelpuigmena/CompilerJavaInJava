package lang.ast;

import java.util.Set;
import java.util.TreeSet;
import java.io.PrintStream;
import java.util.Optional;
import java.util.Iterator;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
/**
 * @ast class
 * @aspect Interpreter
 * @declaredat /home/miquel/Documents/LTH/compilers/Lab5/A5-Interpreter/src/jastadd/Interpreter.jrag:144
 */
public class ActivationRecord extends java.lang.Object {
  
	    HashMap<String, Integer> map;

  

        public ActivationRecord() {
            this.map = new HashMap<>();
        }

  

        public void store(String name, Integer value) {
            System.out.println("Storing name: "+name+", value: "+String.valueOf(value));
            this.map.put(name, value);
        }

  

        public int get(String name) {
            System.out.println("Getting name: "+name);
            return this.map.get(name);
        }


}
