package com.ngm;

import io.github.cdimascio.dotenv.Dotenv;

class Config {

    private Dotenv dotenv;
    private boolean isLoaded = false;

    public Config() {
        try {
            dotenv = Dotenv.load();
            this.isLoaded = true;
        } catch (Exception e) {
            this.isLoaded = false;
        }
    }

    public  String getStringVariable(String name) {
        return getStringVariable(name, "");
    }

    public  String getStringVariable(String name, String defaultValue) {
        // try env
        String value = System.getenv(name);

        // try dotenv
        if (value == null || value.isEmpty()) {
            if (this.isLoaded) {
                value = dotenv.get(name);
            }
        }

        // try default
        if (value == null || value.isEmpty()) {
            value = defaultValue;
        }

        return value;
    }

    public  int getIntVariable(String name) {
        return getIntVariable(name, 0);
    }

    public  int getIntVariable(String name, int defaultValue) {
        // try env
        String value = System.getenv(name);

        // try dotenv
        if (value == null || value.isEmpty()) {
            if (this.isLoaded) {
                value = dotenv.get(name);
            }
        }

        // try default
        if (value == null || value.isEmpty()) {
            return defaultValue;
        }

        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }

    }
}
