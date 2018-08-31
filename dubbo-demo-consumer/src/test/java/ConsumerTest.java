import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.service.DemoProviderService;

public class ConsumerTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"dubbo-demo-consumer.xml"});
        context.start();
        DemoProviderService demoProviderService = (DemoProviderService) context.getBean("demoProviderService");
        //循环调用远程接口(provider起多个校验负载均衡)
        for (int i = 0; i < 1000; i++ ){
            String result=demoProviderService.sayHello("dubbo");
            System.out.println("远程调用的结果："+result);
            //线程暂停一秒
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        context.close();
    }
}
