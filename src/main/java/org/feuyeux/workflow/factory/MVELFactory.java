package org.feuyeux.workflow.factory;

import org.feuyeux.workflow.HelloEasyRules;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.mvel.MVELRuleFactory;
import org.jeasy.rules.support.reader.YamlRuleDefinitionReader;

import java.io.File;
import java.io.FileReader;
import java.net.URI;

public class MVELFactory {
    public static Rule createRule() throws Exception {
        Rule weatherRule4;
        MVELRuleFactory ruleFactory = new MVELRuleFactory(new YamlRuleDefinitionReader());
        URI res = HelloEasyRules.class.getClassLoader().getResource("weather-rule.yml").toURI();
        FileReader fileReader = new FileReader(new File(res));
        weatherRule4 = ruleFactory.createRule(fileReader);
        return weatherRule4;
    }
}
