package com.ociweb.training.tdd.lesson1;

import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;


public class TimedCacheTest {
    @Rule
    public JUnitRuleMockery mockery = new JUnitRuleMockery();

    @Mock
    ObjectLoader mockObjectLoader;

    @Test
    public void testLoadsObjectThatIsNotCached() {
        // Stub
        mockObjectLoader = mockery.mock(ObjectLoader.class);

        // Cache dummies
        final Object KEY = new Object();
        final Object VALUE = new Object();

        // SUT
        TimedCache cache = new TimedCache((ObjectLoader) mockObjectLoader);

        mockery.checking(new Expectations() {{
            oneOf(mockObjectLoader).load(KEY);
            will(returnValue(VALUE));
        }});

        Object lookupValue = cache.lookUp(KEY);  // Uncomment to pass test.  Exercises SUT
        mockery.assertIsSatisfied();
    }
}
