package org.example.application;

import java.util.Random;

public class TemperatureSensor implements Sensor {
    private boolean isOn;
    private final Random random;

    public TemperatureSensor() {
        this.isOn = false;
        this.random = new Random();
    }

    @Override
    public boolean isOn() {
        return this.isOn;
    }

    @Override
    public void setOn() {
        this.isOn = true;
    }

    @Override
    public void setOff() {
        this.isOn = false;
    }

    @Override
    public int read() {
        if (!this.isOn) {
            throw new IllegalStateException("Sensor is off");
        }
        return random.nextInt(61) - 30; // -30 and 30
    }

    public static void main(String[] args) {
        TemperatureSensor sensor = new TemperatureSensor();

        System.out.println("Sensor is on: " + sensor.isOn());
        try {
            System.out.println("Reading: " + sensor.read());
        } catch (IllegalStateException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        sensor.setOn();
        System.out.println("Sensor is on: " + sensor.isOn());
        System.out.println("Reading: " + sensor.read());

        sensor.setOff();
        System.out.println("Sensor is on: " + sensor.isOn());
        try {
            System.out.println("Reading: " + sensor.read());
        } catch (IllegalStateException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}