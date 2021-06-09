package edu.uw.tsp;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

import test.BrokerTest;

@RunWith(JUnitPlatform.class)
@SelectClasses({ BrokerTest.class })
class TestSuite {
}