package com.scg.example;

public enum Skill {

    PROJECT_MANAGER,

    SYSTEM_ARCHITECT,

    SOFTWARE_ENGINEER,

    SOFTWARE_TESTER,

    UNKNOWN_SKILL;

    public int getRate() {
    };

//    Getter for rate property.
    public String toString() {
    };

//    Returns the friendly name for this enumerated value.
    public static Skill valueOf(String name) {
    };

//    Returns the enum constant of this type with the specified name.
    public static Skill[] values() {
    };
//    Returns an array containing the constants of this enum type, in the order they are declared.
}
