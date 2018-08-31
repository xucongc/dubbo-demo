package com.java.service.impl;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.utils.NetUtils;
import com.alibaba.dubbo.remoting.exchange.ExchangeServer;
import com.alibaba.dubbo.rpc.protocol.dubbo.DubboProtocol;
import com.alibaba.dubbo.rpc.support.ProtocolUtils;
import com.java.service.DemoProviderService;
import java.util.Collection;

/**
 * 服务提供者接口实现类
 *
 * @author Administrator
 */
public class DemoProviderServiceImpl implements DemoProviderService {

    public String sayHello(String name) {
        DubboProtocol dubboProtocol = DubboProtocol.getDubboProtocol();
        Collection<ExchangeServer> servers = dubboProtocol.getServers();
        int port = 0;
        if (null != servers) {
            for (ExchangeServer server : servers) {
                URL url = server.getUrl();
                port = url.getPort();
            }
        }
        return "Hello" + name + "服务端口号:"+port;
    }

}
