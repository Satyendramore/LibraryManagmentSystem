package com.sada.LibraryManagement.Eceptions;

public class LimitExcced  extends RuntimeException {
    public LimitExcced(String message) {
        super(message);
    }
    public LimitExcced() {
        super();
    }
}
