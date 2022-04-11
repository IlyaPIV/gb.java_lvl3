package hw7;

public class TestListAdvanced{

    @BeforeSuite
    public void beforeTest1(){
        System.out.println("метод Before test #1");
    }

    @BeforeSuite
    public void beforeTest2(){
        System.out.println("метод Before test #2");
    }

    @Test(prio = 3)
    public void test1(){
        System.out.println("Тест - 1 (приоритет = 3)");
    }

    @Test(prio = 7)
    public void test2(){
        System.out.println("Тест - 2 (приоритет = 7)");
    }

    @Test(prio = 2)
    public void test3(){
        System.out.println("Тест - 3 (приоритет = 2)");
    }

    @Test (prio = 1)
    public void test4(){
        System.out.println("Тест - 4 (приоритет = 1)");
    }


    @AfterSuite
    public void afterTest(){
        System.out.println("Метод после тестов");
    }
}
