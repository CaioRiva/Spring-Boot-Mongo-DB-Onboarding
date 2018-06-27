package com.criva.onboardingproject.context;

public class IntegrationTestsLocalThread {

    static  final class LocalContext extends ThreadLocal<IntegrationTestsLocalContext> {

        @Override
        protected IntegrationTestsLocalContext initialValue() {

            return new IntegrationTestsLocalContext();
        }
    }

    private static final ThreadLocal<IntegrationTestsLocalContext> localContext = new LocalContext();

    public static IntegrationTestsLocalContext getContext() {

        return localContext.get();
    }
}
