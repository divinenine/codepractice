package com.headfirst.designpatterns.chapter6;

public class RemoteControl {

    Command[] onCommands;
    Command[] offComands;
    Command undoCommand;

    public RemoteControl() {
        onCommands = new Command[7];
        offComands = new Command[7];

       // Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = () -> {};
            offComands[i] = () -> {};
        }
        undoCommand = () -> {};
    }

    public void setCommand (int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offComands[slot] = offCommand;
    }

    public void onButtonWasPushed (int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    public void offButtonWasPushed (int slot) {
        offComands[slot].execute();
        undoCommand = offComands[slot];
    }

/*    public void undoButtonWasPushed() {
        undoCommand.undo();
    }*/

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("\n------ Remote Control ------\n");
        for (int i = 0; i<onCommands.length; i++) {
            sb.append("[slot " + i + "] " + onCommands[i].getClass().getSimpleName()
                    + "\t" + offComands[i].getClass().getSimpleName() + "\n");
        }
        sb.append("[undo] " + undoCommand.getClass().getSimpleName());
        return sb.toString();
    }
}
