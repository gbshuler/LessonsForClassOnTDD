package com.ociweb.training.tdd.lesson1;

import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;


public class CacheLookupTest {
    @Rule
    public JUnitRuleMockery mockery = new JUnitRuleMockery();

    @Mock
    ObjectCollection mockObjectCollection;

    @Test
    public void testLoadsObjectThatIsNotCached() {
        // Stub
        mockObjectCollection = mockery.mock(ObjectCollection.class);

        // Cache dummies
        final Object KEY = new Object();
        final Object VALUE = new Object();

        // SUT
        MeasuredCache cache = new MeasuredCache((ObjectCollection) mockObjectCollection);

        mockery.checking(new Expectations() {{
            oneOf(mockObjectCollection).load(KEY);
            will(returnValue(VALUE));
        }});

        Object lookupValue = cache.lookUp(KEY);  // Uncomment to pass test.  Exercises SUT
        mockery.assertIsSatisfied();
    }
}
