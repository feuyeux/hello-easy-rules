package org.feuyeux.workflow;

import lombok.extern.slf4j.Slf4j;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.core.RuleBuilder;
import org.jeasy.rules.mvel.MVELRule;
import org.jeasy.rules.mvel.MVELRuleFactory;
import org.jeasy.rules.support.reader.YamlRuleDefinitionReader;

import java.io.File;
import java.io.FileReader;
import java.net.URI;

@Slf4j
public class HelloEasyRules {

    public static void main(String[] args) throws Exception {
        // 1 in a declarative way using annotations:
        WeatherRule weatherRule1 = new WeatherRule();

        // 2 in a programmatic way with a fluent API:
        Rule weatherRule2 = new RuleBuilder()
                .name("weather rule 2")
                .description("if it rains then take an umbrella")
                .when(facts -> facts.get("rain").equals(true))
                .then(facts -> System.out.println("2 It rains, take an umbrella!"))
                .build();

        // 3 using an Expression Language:
        Rule weatherRule3 = new MVELRule()
                .name("weather rule 3")
                .description("if it rains then take an umbrella")
                .when("rain == true")
                .then("System.out.println(\"3 It rains, take an umbrella!\");");

        // 4 using a rule descriptor:
        MVELRuleFactory ruleFactory = new MVELRuleFactory(new YamlRuleDefinitionReader());
        URI res = HelloEasyRules.class.getClassLoader().getResource("weather-rule.yml").toURI();
        Rule weatherRule4 = ruleFactory.createRule(new FileReader(new File(res)));

        // define facts
        Facts facts = new Facts();
        facts.put("rain", true);

        // define rules
        Rules rules = new Rules();
        rules.register(weatherRule1, weatherRule2, weatherRule3, weatherRule4);

        // fire rules on known facts
        RulesEngine rulesEngine = new DefaultRulesEngine();
        rulesEngine.fire(rules, facts);
    }
}

