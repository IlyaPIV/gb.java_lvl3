package hw7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Main {
    public static void main(String[] args) {

       // TestsList myClass = new TestsList();


        List<Method> methodsBefore = new ArrayList<>();
        Map<Integer,List<Method>> methodsTests = new TreeMap<>();
        List<Method> methodsAfter = new ArrayList<>();

        System.out.printf("========= %s =========\n",TestsList.class.getName());
        TestsList obj1 = new TestsList();
        Method[] methods = TestsList.class.getDeclaredMethods();
        sortMethods(methods, methodsBefore, methodsTests, methodsAfter);
        try {
            completeMethods(obj1, methodsBefore, methodsTests, methodsAfter);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        System.out.printf("========= %s =========\n",TestListAdvanced.class.getName());
        TestListAdvanced obj2 = new TestListAdvanced();
        methods = TestListAdvanced.class.getDeclaredMethods();
        sortMethods(methods, methodsBefore, methodsTests, methodsAfter);
        try {
            completeMethods(obj2, methodsBefore, methodsTests, methodsAfter);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void sortMethods(Method[] methods, List<Method> mBefore, Map<Integer,List<Method>> mTests, List<Method> mAfter){
        mBefore.clear();
        mTests.clear();
        mAfter.clear();

        for (Method m:
             methods) {
            if (m.getAnnotation(BeforeSuite.class) != null) {
                mBefore.add(m);
                continue;
            }
            if (m.getAnnotation(AfterSuite.class)!=null) {
                mAfter.add(m);
                continue;
            }
            if (m.getAnnotation(Test.class)!=null) {
                int prio = m.getAnnotation(Test.class).prio();

                List<Method> currentMethods = mTests.get(prio);
                if (currentMethods==null) {
                    currentMethods = new ArrayList<>();
                }
                currentMethods.add(m);
                mTests.put(prio,currentMethods);
            }
        }
        System.out.println("---------> СОРТИРОВКА МЕТОДОВ ПО АННОТАЦИЯМ:");
        System.out.println("Кол-во методов Before = "+mBefore.size());
        System.out.println("Кол-во методов Tests = "+mTests.size());
        System.out.println("Кол-во методов After = "+mAfter.size());
    }

    private static void completeMethods(Object obj, List<Method> mBefore, Map<Integer,List<Method>> mTests, List<Method> mAfter) throws RuntimeException {
        System.out.println("---------> ПОДГОТОВКА К ВЫПОЛНЕНИЮ МЕТОДОВ:");

        if (mBefore.size()!=1 || mAfter.size()!=1) throw new RuntimeException("Ошибка выполнения - методы Before или After присутствуют в нескольких экземплярах");

        System.out.println("---------> ВЫПОЛНЕНИЕ МЕТОДОВ:");
        try {
            mBefore.get(0).invoke(obj);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        for (Map.Entry<Integer,List<Method>> methodsByPrio : mTests.entrySet()) {
            List<Method> methodList = methodsByPrio.getValue();
            for (Method method:
                 methodList) {

                try {
                    method.invoke(obj);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        try {
            mAfter.get(0).invoke(obj);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
