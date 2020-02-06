package com.raczkowski.apps.view;

public class Menu implements View {

    private final Components components;

    public Menu(Components components) {
        this.components = components;
    }

    @Override
    public void view() {
        components.view();
    }


}
