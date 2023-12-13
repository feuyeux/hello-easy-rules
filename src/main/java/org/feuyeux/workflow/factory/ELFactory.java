package org.feuyeux.workflow.factory;

import org.jeasy.rules.mvel.MVELRule;

public class ELFactory {

    public static MVELRule createRule() {
        return new MVELRule()
                .name("weather rule 3")
                .description("if it rains then take an umbrella")
                .when("rain == true")
                .then("System.out.println(\"3 It rains, take an umbrella!\");");
    }
}
