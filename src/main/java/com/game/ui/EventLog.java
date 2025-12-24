package com.game.ui;

import javafx.scene.control.TextArea;

public class EventLog extends TextArea {

    public EventLog() {
        setEditable(false);
        setPrefHeight(120);
        setWrapText(true);
        setText("Game started...\n");
    }

    public void log(String message) {
        appendText("• " + message + "\n");
    }
}
