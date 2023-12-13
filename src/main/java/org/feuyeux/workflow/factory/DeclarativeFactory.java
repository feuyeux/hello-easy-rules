package org.feuyeux.workflow.factory;

import org.feuyeux.workflow.pojo.WeatherRule;

public class DeclarativeFactory {

    public static WeatherRule createWeatherRule() {
        return new WeatherRule();
    }
}
