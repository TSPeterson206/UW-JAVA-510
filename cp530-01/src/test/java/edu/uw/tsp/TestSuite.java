package edu.uw.tsp;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

import test.AccountManagerTest;
import test.AccountTest;
import test.DaoTest;

@RunWith(JUnitPlatform.class)
@SelectClasses({ AccountTest.class, DaoTest.class, AccountManagerTest.class })
class TestSuite {
}