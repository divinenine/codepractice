package com.headfirst.designpatterns.chapter6;

public class LightOnCommand implements Command {

    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

  /*  @Override
    public void undo() {
        light.off();
    }
*/
    @Override
    public void execute() {
        light.on();
    }
}
