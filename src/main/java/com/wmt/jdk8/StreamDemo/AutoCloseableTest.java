package com.wmt.jdk8.StreamDemo;

public class AutoCloseableTest implements AutoCloseable {
   public void doSomething(){
       System.out.println("doSomething invoked!");
   }

    @Override
    public void close() throws Exception{
       System.out.println("close invoked!");
   }
    //自动关闭流
    public static void main(String[] args) throws Exception{
        try(AutoCloseableTest autoCloseableTest= new AutoCloseableTest()) {
            autoCloseableTest.doSomething();
        }
    }
}
