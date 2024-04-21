package moe.mqq.config;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class FlowRuleConfig {

    @Bean
    public void initFlowRules(){
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("add");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // Set limit QPS to 20.
        rule.setCount(1);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);

        List<DegradeRule> rules2 = new ArrayList<>();
        DegradeRule degradeRule = new DegradeRule();
        degradeRule.setResource("add");
        degradeRule.setGrade(RuleConstant.DEGRADE_GRADE_EXCEPTION_COUNT);
        degradeRule.setCount(2);
        degradeRule.setMinRequestAmount(2);
        degradeRule.setStatIntervalMs(60 * 1000);
        degradeRule.setTimeWindow(10);
        rules2.add(degradeRule);
        DegradeRuleManager.loadRules(rules2);

    }
}
