package edu.uw.tsp;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

import test.AccountManagerTest;
import test.BrokerTest;
import test.DaoTest;

@RunWith(JUnitPlatform.class)
@SelectClasses({ DaoTest.class, AccountManagerTest.class, BrokerTest.class })
class TestSuite {
}