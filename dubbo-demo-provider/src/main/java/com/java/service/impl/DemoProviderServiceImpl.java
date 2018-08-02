package com.java.service.impl;

import com.alibaba.dubbo.common.utils.NetUtils;
import com.alibaba.dubbo.registry.dubbo.DubboRegistryFactory;
import com.alibaba.dubbo.remoting.transport.netty4.logging.NettyHelper;
import com.alibaba.dubbo.rpc.protocol.dubbo.DubboProtocol;
import com.alibaba.dubbo.rpc.protocol.rest.DubboHttpServer;
import com.java.service.DemoProviderService;

/**
 * 服务提供者接口实现类
 * @author Administrator
 *
 */
public class DemoProviderServiceImpl implements DemoProviderService{

	public String sayHello(String name) {
		String port ="";
		return "Hello"+name+"服务端口号："+port;
	}

}
