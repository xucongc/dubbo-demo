import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ProviderTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"dubbo-demo-provider.xml"});
        context.start();
        System.out.println("服务提供者向zookeeper注册中心注册服务成功");
        try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // press any key to exit
        context.close();
	}
}
