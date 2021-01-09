package net.kinokodata.eliza;

public enum Person {
    Eliza("Eliza"),
    You("あなた");

    private final String _name;

    private Person(String name) {
        this._name = name;
    }

    public String getName() {
        return this._name;
    }
}
