package org.goskyer.observer;

import java.util.List;

/**
 * 未来几天温度
 * @author zhangzhiqin
 * @create 2017-12-06 11:27
 **/
public class ForecastDisplay implements Observer, DisplayElement{

    private WeatherData weatherData;

    //未来几天的温度
    private List<Float> forecastTemperatures;

    public ForecastDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("未来几天的气温");
        int count = forecastTemperatures.size();
        for (int i = 0; i < count; i++) {
            System.out.println("第" + i + "天:" + forecastTemperatures.get(i) + "℃");
        }
    }

    @Override
    public void update() {
        this.forecastTemperatures = this.weatherData.getForecastTemperatures();
        display();
    }

}