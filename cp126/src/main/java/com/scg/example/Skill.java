package com.scg.example;

/**
 * The Skill enum for the invoice project. This enum contains the skills that
 * are billable (or not) for the invoices. It also contains method to get the
 * rate of the listed skill and return the friendly name.
 * 
 * @author Toby Peterson
 *
 */
public enum Skill {

    /**
     * The project manager skill.
     */
    PROJECT_MANAGER(250, "Project Manager"),

    /**
     * The system architect skill.
     */
    SYSTEM_ARCHITECT(200, "System Architect"),

    /**
     * The software engineer skill.
     */
    SOFTWARE_ENGINEER(150, "Software Engineer"),

    /**
     * The software tester skill.
     */
    SOFTWARE_TESTER(100, "Software Tester"),

    /**
     * An unknown skill outside of the common listed skills.
     */
    UNKNOWN_SKILL(1, "Unknown Skill");

    /**
     * The rate property for the Skill enum.
     */
    private int rate;

    /**
     * The name property for the Skill enum.
     */
    private String name;

    /**
     * Two-parameter constructor for the Skill enum.
     * 
     * @param rate The rate for the selected skill.
     * @param name The friendly name for the selected skill.
     */
    private Skill(int rate, String name) {
        this.rate = rate;
        this.name = name;
    };

    /**
     * The getRate method for the invoice project. It is used to determine the
     * billable rate (if applicable) for the selected skill.
     * 
     * @return int The rate for the listed skill.
     */
    public int getRate() {
        return this.rate;
    };

    /**
     * The toString method for the enum Skill.
     * 
     * @return String The friendly name for the enumerated value.
     */
    public String toString() {
        return this.name;
    }
};
