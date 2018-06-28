package com.criva.onboardingproject.context;

public class IntegrationTestLocalThread {

    static  final class LocalContext extends ThreadLocal<IntegrationTestLocalContext> {

        @Override
        protected IntegrationTestLocalContext initialValue() {

            return new IntegrationTestLocalContext();
        }
    }

    private static final ThreadLocal<IntegrationTestLocalContext> localContext = new LocalContext();

    public static IntegrationTestLocalContext getContext() {

        return localContext.get();
    }
}
