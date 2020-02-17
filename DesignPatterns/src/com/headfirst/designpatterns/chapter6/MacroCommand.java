/*
package com.headfirst.designpatterns.chapter6;

public class MacroCommand implements Command {

    Command[] commands;

    public MacroCommand(Command[] commands) {
        this.commands = commands;
    }

    @Override
    public void undo() {
        for (int k = commands.length - 1; k >= 0; k--) {
            commands[k].undo();
        }
    }

    public void execute() {
        for (int i = 0; i < commands.length; i++) {
            commands[i].execute();
        }
    }

}
*/
