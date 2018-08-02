import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java1234.service.DemoProviderService;

public class ConsumerTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"dubbo-demo-consumer.xml"});
        context.start();
        DemoProviderService demoProviderService=(DemoProviderService) context.getBean("demoProviderService");
        String result=demoProviderService.sayHello("你好");
        System.out.println("远程调用的结果："+result);
        try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        context.close();
	}
}
