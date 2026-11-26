import com.sun.source.tree.ArrayAccessTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static String D(String d){
        return d;
    }public static int D(int d){

        return d;
    }public static boolean D(boolean d){
        return d;
    }
    public static class MySuperClass<E> extends ArrayList<E>{
    public void MySuperMetod(){

    }
    }
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        Integer objNumber = 150;



        MySuperClass<String> n = new MySuperClass<>();
        var m = D(2);
        //var parsedPrimitive = Integer.parseInt("4096");
        String parsedPrimitive;
        parsedPrimitive = "1";
        //= String.valueOf(7);

        ArrayList<Integer> list = new ArrayList<>();
        Iterator<Integer> g = list.iterator();

        if (list instanceof List<?>){

        }
        list.add(Integer.valueOf(2));
        list.add(2);

        list.remove(Integer.valueOf(3));
        System.out.println(list);
        list.contains(7);
        list.add(99);
        for (int i = 1; i <= 5; i++) {

            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);

        }
    }
}