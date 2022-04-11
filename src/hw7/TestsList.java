package hw7;

public class TestsList {


    @BeforeSuite
    public void beforeTest(){
        System.out.println("метод Before test");
    }

    @Test(prio = 5)
    public void test1(){
        System.out.println("Тест - 1 (приоритет = 5)");
    }

    @Test(prio = 3)
    public void test2(){
        System.out.println("Тест - 2 (приоритет = 3)");
    }

    @Test(prio = 1)
    public void test3(){
        System.out.println("Тест - 3 (приоритет = 1)");
    }

    @Test (prio = 9)
    public void test4(){
        System.out.println("Тест - 4 (приоритет = 9)");
    }

    @Test (prio = 1)
    public void test5(){
        System.out.println("Тест - 5 (приоритет = 1)");
    }

    @AfterSuite
    public void afterTest(){
        System.out.println("Метод после тестов");
    }
}
