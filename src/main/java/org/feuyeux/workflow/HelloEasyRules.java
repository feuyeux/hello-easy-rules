package org.feuyeux.workflow;

import lombok.extern.slf4j.Slf4j;
import org.feuyeux.workflow.factory.DeclarativeFactory;
import org.feuyeux.workflow.factory.ELFactory;
import org.feuyeux.workflow.factory.MVELFactory;
import org.feuyeux.workflow.factory.ProgrammaticFactory;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;

@Slf4j
public class HelloEasyRules {

    public static void main(String[] args) throws Exception {
        // define facts
        Facts facts = new Facts();
        facts.put("rain", true);

        // define rules
        Rules rules = new Rules();
        rules.register(
                // 1 in a declarative way using annotations:
                DeclarativeFactory.createWeatherRule(),
                // 2 in a programmatic way with a fluent API:
                ProgrammaticFactory.createRule(),
                // 3 using an Expression Language:
                ELFactory.createRule(),
                // 4 using a rule descriptor:
                MVELFactory.createRule()
        );

        // fire rules on known facts
        RulesEngine rulesEngine = new DefaultRulesEngine();
        rulesEngine.fire(rules, facts);
    }
}

