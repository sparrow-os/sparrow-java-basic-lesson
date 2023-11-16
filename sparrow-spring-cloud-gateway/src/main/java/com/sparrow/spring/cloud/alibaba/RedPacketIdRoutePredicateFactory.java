package com.sparrow.spring.cloud.alibaba;

import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.GatewayPredicate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class RedPacketIdRoutePredicateFactory extends AbstractRoutePredicateFactory<RedPacketIdRoutePredicateFactory.Config> {
    public RedPacketIdRoutePredicateFactory() {
        super(Config.class);
    }

    //读取配置文件中的内容并配置给配置类中的属性
    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("redPackageParam", "serverSetIndex", "serverSetNum");
    }

    @Override
    public Predicate<ServerWebExchange> apply(RedPacketIdRoutePredicateFactory.Config config) {
        return new GatewayPredicate() {
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                List<String> values = serverWebExchange.getRequest().getQueryParams().get(config.redPackageParam);
                if (values == null) {
                    return false;
                }
                Iterator<String> it = values.iterator();
                if (!it.hasNext()) {
                    return false;
                }
                String value = it.next();
                if (!StringUtils.isNumeric(value)) {
                    return false;
                }
                Integer serverSetIndex = Integer.parseInt(value) % config.serverSetNum;
                return config.serverSetIndex.equals(serverSetIndex);
            }
        };
    }

    @Validated
    public static class Config {
        private String redPackageParam;
        private Integer serverSetIndex;
        private Integer serverSetNum;

        public Integer getServerSetIndex() {
            return serverSetIndex;
        }

        public void setServerSetIndex(Integer serverSetIndex) {
            this.serverSetIndex = serverSetIndex;
        }

        public String getRedPackageParam() {
            return redPackageParam;
        }

        public void setRedPackageParam(String redPackageParam) {
            this.redPackageParam = redPackageParam;
        }

        public Integer getServerSetNum() {
            return serverSetNum;
        }

        public void setServerSetNum(Integer serverSetNum) {
            this.serverSetNum = serverSetNum;
        }
    }
}
