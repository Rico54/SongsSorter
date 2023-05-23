package tests;

import org.junit.Test;
import ratings.ProblemSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.assertTrue;
import static ratings.ProblemSet.*;

public class TestProblemSet {
    private final double EPSILON = 0.001;
    public void compareDoubles( double d1, double d2){
        assertTrue(Math.abs(d1 - d2) < EPSILON);
    }

    @Test
    public void Testdoubles(){
        ArrayList<Double> numbers0 = new ArrayList<>(Arrays.asList(3.0,-10.0,2.2,3.1,-11.2));
        double arr = ProblemSet.average(numbers0);
        compareDoubles(-2.58, arr);
        ArrayList<Double> numbers1 = new ArrayList<>(Arrays.asList(-3.0,-10.0,-1.2,-45.1,-11.3, -21.6));
        arr = ProblemSet.average(numbers1);
        compareDoubles(-15.36667, arr);
        ArrayList<Double> numbers2 = new ArrayList<>(Arrays.asList());
        arr = ProblemSet.average(numbers2);
        compareDoubles(0.0, arr);
        ArrayList<Double> numbers3 = new ArrayList<>(Arrays.asList(5.0));
        arr = ProblemSet.average(numbers3);
        compareDoubles(5.0,arr);
        ArrayList<Double> numbers4 = new ArrayList<>(Arrays.asList(1.0,2.0,3.0,4.0));
        arr = ProblemSet.average(numbers4);
        compareDoubles(2.5,arr);

    }
    @Test
    public void TestSum(){
        int num = ProblemSet.sumOfDigits(123);
        assertTrue("The sum should be 6, got: " + num, num == 6);
        num = ProblemSet.sumOfDigits(0);
        assertTrue("The sum should be 0, got: " + num, num == 0);
        num = ProblemSet.sumOfDigits(-44);
        assertTrue("The sum should be 8, got: " + num, num == 8);
        num = ProblemSet.sumOfDigits(1111);
        assertTrue("The sum should be 4, got: " + num, num == 4);
        num = ProblemSet.sumOfDigits(1000);
        assertTrue("The sum should be 1, got: " + num, num == 1);
        num = ProblemSet.sumOfDigits(808);
        assertTrue("The sum should be 16, got: " + num, num == 16);
        num = ProblemSet.sumOfDigits(7);
        assertTrue("The sum should be 7, got: " + num, num == 7);
        num = ProblemSet.sumOfDigits(-3321);
        assertTrue("The sum should be 7, got: " + num, num == 9);




    }
    @Test
    public void TestKey(){
        HashMap <String, Integer> hash = new HashMap <String, Integer>() {{ put("a", 1); put("e", 3);put("saa",44);put("hi",4);}};
        String bigg = ProblemSet.bestKey(hash);
        assertTrue("The biggest values in the key is saa, got: " + bigg, bigg.equals("saa"));
        HashMap <String, Integer> hash1 = new HashMap <String, Integer>() {{ put("cse", 21); put("c", 113);put("aa",44);put("hello",4);}};
        String bigg1 = ProblemSet.bestKey(hash1);
        assertTrue("The biggest values in the key is c, got: " + bigg1, bigg1.equals("c"));
        HashMap <String, Integer> hash2 = new HashMap <String, Integer>();
        String bigg2 = ProblemSet.bestKey(hash2);
        assertTrue("The biggest values in the key is blank, got: " + bigg2, bigg2.equals(""));
        HashMap <String, Integer> hash3 = new HashMap <String, Integer>() {{ put("a", 22); put("c", 3);put("saa",22);put("hello",4);}};
        String bigg3 = ProblemSet.bestKey(hash3);
        assertTrue("The biggest values in the key is saa, got: " + bigg3,(bigg3.equals("saa") || bigg3.equals("a")));
        HashMap <String, Integer> hash4 = new HashMap <String, Integer>() {{ put("f", -1); put("ax",21); put("food", -100);put("bv",24);}};
        String bigg4 = ProblemSet.bestKey(hash4);
        assertTrue("The biggest values in the key is 24, got: " + bigg4, bigg4.equals("bv"));
        HashMap <String, Integer> hash5 = new HashMap <String, Integer>() {{ put("f", -12); put("ax",-1); put("food", -87);put("bv",-24);}};
        String bigg5 = ProblemSet.bestKey(hash5);
        assertTrue("The biggest values in the key is -1, got: " + bigg5, bigg5.equals("ax"));
        HashMap <String, Integer> hash6 = new HashMap <String, Integer>() {{ put("cse", 21);}};
        String bigg6 = ProblemSet.bestKey(hash6);
        assertTrue("The biggest values in the key is cse, got: " + bigg6, bigg6.equals("cse"));
        HashMap <String, Integer> hash7 = new HashMap <String, Integer>() {{ put("cse", -21);}};
        String bigg7 = ProblemSet.bestKey(hash7);
        assertTrue("The biggest values in the key is cse, got: " + bigg7, bigg7.equals("cse"));
        HashMap <String, Integer> hash8 = new HashMap <String, Integer>() {{ put("cse", 0);}};
        String bigg8 = ProblemSet.bestKey(hash8);
        assertTrue("The biggest values in the key is cse, got: " + bigg8, bigg8.equals("cse"));
        HashMap <String, Integer> hash9 = new HashMap <String, Integer>() {{ put("f", -12); put("ax",-1); put("food", -87);put("bv",-24);put("vc", 0);}};
        String bigg9 = ProblemSet.bestKey(hash9);
        assertTrue("The biggest values in the key is vc, got: " + bigg9, bigg9.equals("vc"));
        HashMap <String, Integer> hash10 = new HashMap <String, Integer>() {{ put("a", -1); put("c", -3);put("saa",-1);put("hello",-4);}};
        String bigg10 = ProblemSet.bestKey(hash10);
        assertTrue("The biggest values in the key is saa or a, got: " + bigg10,(bigg10.equals("saa") || bigg10.equals("a")));
        HashMap <String, Integer> hash11 = new HashMap <String, Integer>() {{ put("a", 1); put("c", -3);put("saa",-3);put("hello",4);put("aa",4);}};
        String bigg11 = ProblemSet.bestKey(hash11);
        assertTrue("The biggest values in the key is aa or hello, got: " + bigg11,(bigg11.equals("hello") || bigg11.equals("aa")));
        HashMap <String, Integer> hash12 = new HashMap <String, Integer>() {{ put("a", 20); put("c", -3);put("saa",-3);put("hello",4);put("aa",4);}};
        String bigg12 = ProblemSet.bestKey(hash12);
        assertTrue("The biggest values in the key is a , got: " + bigg12,(bigg12.equals("a")));
        HashMap <String, Integer> hash13 = new HashMap <String, Integer>() {{ put("a", -20); put("c", -3);put("saa",-3);put("hello",-2);put("aa",-1);}};
        String bigg13 = ProblemSet.bestKey(hash13);
        assertTrue("The biggest values in the key is aa , got: " + bigg13,(bigg13.equals("aa")));




    }
    }

    // TODO: Write testing for all 3 methods of the ratings.ProblemSet class


