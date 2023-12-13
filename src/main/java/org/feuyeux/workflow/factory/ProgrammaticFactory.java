package org.feuyeux.workflow.factory;

import org.jeasy.rules.api.Rule;
import org.jeasy.rules.core.RuleBuilder;

public class ProgrammaticFactory {
    public static Rule createRule() {
        return new RuleBuilder()
                .name("weather rule 2")
                .description("if it rains then take an umbrella")
                .when(facts -> facts.get("rain").equals(true))
                .then(facts -> System.out.println("2 It rains, take an umbrella!"))
                .build();
    }
}
