package com.example.modules.component;

public interface BaseComponent {
    default void info() {
        System.out.println("""
                    No specific information. This is the default info content.
                    Please contact the author and let him improve the info content.
                """);
    }
}
