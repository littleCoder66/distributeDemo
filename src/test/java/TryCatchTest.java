public class TryCatchTest {
    public static void  main(String[]args){
        tryTest();
    }

    public static void tryTest(){
        try{
            System.out.println("try 代碼塊");
            int i =1/0;
            return;
        }catch (Exception e){
            System.out.println("發生異常---"+e);
            return;
        }finally {
            System.out.println("finally代碼快");
            return;
        }
    }
}
