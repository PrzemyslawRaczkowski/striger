package com.raczkowski.apps.view;

import java.util.List;

public class Components implements View {

    private final List<String> components;

    public Components(List<String> components) {
        this.components = components;
    }

    @Override
    public void view() {
        for (String component : components) {
            System.out.println(component);
        }
    }
}
