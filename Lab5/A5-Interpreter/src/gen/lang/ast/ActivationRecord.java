package lang.ast;

import java.util.Set;
import java.util.TreeSet;
import java.io.PrintStream;
import java.util.Optional;
import java.util.Iterator;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;
/**
 * @ast class
 * @aspect Interpreter
 * @declaredat /home/miquel/Documents/LTH/compilers/Lab5/A5-Interpreter/src/jastadd/Interpreter.jrag:169
 */
public class ActivationRecord extends java.lang.Object {
  
	    HashMap<String, Integer> map;

  

        public ActivationRecord(HashMap map) {
            this.map = new HashMap<>(map);
        }

  

        public void store(String name, Integer value) {
            this.map.put(name, value);
        }

  

        public int get(String name) {
            return this.map.get(name);
        }

  
        public HashMap getMap(){
            return (HashMap<String, Integer>) this.map.clone();
        }


}
