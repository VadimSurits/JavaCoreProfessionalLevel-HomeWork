package homeWork7;

public class MyTest {

    @BeforeSuite
    public static void testBS(){
        System.out.println("Test BeforeSuite");
    }

    @Test(priority = 1)
    public static void test1(){
        System.out.println("Test1: priority = 1");
    }

    @Test
    public static void test2(){
        System.out.println("Test2");
    }

    @Test
    public static void test3(){
        System.out.println("Test3");
    }

    @Test(priority = 10)
    public static void test4(){
        System.out.println("Test4: priority = 10");
    }

    @AfterSuite
    public static void testAS(){
        System.out.println("Test AfterSuite");
    }
}
