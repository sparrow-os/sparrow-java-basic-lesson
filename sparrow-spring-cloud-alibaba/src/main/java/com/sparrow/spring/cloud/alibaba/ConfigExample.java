package com.sparrow.spring.cloud.alibaba;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import java.util.Properties;
import java.util.concurrent.Executor;

public class ConfigExample {

	public static void main(String[] args) throws NacosException, InterruptedException, NacosException {
		String serverAddr = "localhost";
		String dataId = "sparrow.properties";
		String group = "sparrow-zoo";
		Properties properties = new Properties();
		properties.put(PropertyKeyConst.SERVER_ADDR, serverAddr);
		properties.put(PropertyKeyConst.NAMESPACE,"cc44e03b-3d42-4416-ae2a-64b6469a1edb");
		ConfigService configService = NacosFactory.createConfigService(properties);
		String content = configService.getConfig(dataId, group, 5000);
		System.out.println(content);
		configService.addListener(dataId, group, new Listener() {
			@Override
			public void receiveConfigInfo(String configInfo) {
				System.out.println("recieve:" + configInfo);
			}

			@Override
			public Executor getExecutor() {
				return null;
			}
		});

		boolean isPublishOk = configService.publishConfig(dataId, group, "name=zhangsan");
		System.out.println(isPublishOk);

		Thread.sleep(3000);
		content = configService.getConfig(dataId, group, 5000);
		System.out.println(content);

		//boolean isRemoveOk = configService.removeConfig(dataId, group);
		//System.out.println(isRemoveOk);
		//Thread.sleep(3000);

		content = configService.getConfig(dataId, group, 5000);
		System.out.println(content);
		Thread.sleep(Integer.MAX_VALUE);

	}
}
