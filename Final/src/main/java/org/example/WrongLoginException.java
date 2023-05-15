package org.example;

import java.io.IOException;

public class WrongLoginException extends IOException {
    public WrongLoginException() {
    }

    public WrongLoginException(String message) {
        super (message);
    }
}
