package epi.test

class ProbUtils {
    static Closure<Boolean> newBernoulliToleranceTest(int n, double p, double sigmasOfTolerance) {
        int mu = (int)(n * p)
        int sigma = (int)(Math.sqrt(n * p * (1 - p)))
        {
            obs -> Math.abs(mu - obs) < sigma * sigmasOfTolerance
        }
    }
}
