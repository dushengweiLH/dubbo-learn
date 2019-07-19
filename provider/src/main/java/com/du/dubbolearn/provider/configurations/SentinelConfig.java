package com.du.dubbolearn.provider.configurations;

import com.alibaba.csp.sentinel.init.InitExecutor;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Collections;

/**
 * @author dushengwei@duoshengbu.com
 * @since 2019/7/19
 */
@Configuration
@Slf4j
public class SentinelConfig {
    /**
     * 方法级别测试（没起作用：0719日）
     */
    private static final String RES_KEY =
        "com.du.dubbolearn.serviceapi.service.UserService.addUser(com.du.dubbolearn.serviceapi.pojo.User)";
    /**
     * 接口级别测试，起作用
     */
    private static final String INTERFACE_RES_KEY = "com.du.dubbolearn.serviceapi.service.UserService";

    @PostConstruct
    public void init() {
        log.info("init-------------------------------------------------------------------");

        InitExecutor.doInit();

        initFlowRule();
    }

    private static void initFlowRule() {
        FlowRule flowRule = new FlowRule();
        flowRule.setResource(RES_KEY);
        flowRule.setCount(6);
        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        flowRule.setLimitApp("default");
        FlowRuleManager.loadRules(Collections.singletonList(flowRule));
    }
}
