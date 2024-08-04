package com.example.modules.configuration;

public interface BaseConfiguration {
    default void configurationInfo() {
        System.out.println("""
                    No specific information. This is the default info content.
                    Please contact the author and let him improve the info content.
                """);
    }
}
