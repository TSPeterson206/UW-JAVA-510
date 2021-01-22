package com.scg.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SkillTest {

    Skill skill1 = Skill.PROJECT_MANAGER;
    Skill skill2 = Skill.SOFTWARE_ENGINEER;
    Skill skill3 = Skill.SOFTWARE_TESTER;
    Skill skill4 = Skill.SYSTEM_ARCHITECT;
    Skill skill5 = Skill.UNKNOWN_SKILL;

    @Test
    void constructorTest() {

    }

    @Test
    void names() {

        assertEquals(skill1.toString(), "Project Manager");
        assertEquals(skill2.toString(), "Software Engineer");
        assertEquals(skill3.toString(), "Software Tester");
        assertEquals(skill4.toString(), "System Architect");
        assertEquals(skill5.toString(), "Unknown Skill");
    }

    @Test
    void rates() {
        assertEquals(skill1.getRate(), 250);
        assertEquals(skill2.getRate(), 150);
        assertEquals(skill3.getRate(), 100);
        assertEquals(skill4.getRate(), 200);
        assertEquals(skill5.getRate(), 1);
    }

}
