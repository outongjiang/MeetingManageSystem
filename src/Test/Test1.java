package Test;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.MethodAccessor_Short;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

class User{
    public void getName(){
        System.out.println("getName");
    }
}
public class Test1 {
    public static  void t(String s){
        System.out.println(s);
    }
    public static void main(String[] args) {
//        Class u_C=User.class;
//        Method m[] =u_C.getMethods();
//        for(Method e:m){
//            if(!e.getName().contains("get"))
//                continue;
//            System.out.println(e.getName().split("get")[1]);
//        }

        System.out.println("2021-12-02T21:35:00".replace("T"," "));



    }
}
