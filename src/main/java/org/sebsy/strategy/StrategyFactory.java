package org.sebsy.strategy;

public class StrategyFactory {
    public static Strategy getStrategy(AlgorithmTypeEnum strategyType) {
        if (strategyType == null) {
            return null;
        }
        switch (strategyType) {
            case BUBBLE_SORT:
                return new BubbleAlgorithm();
            case INSERTION_SORT:
                return new InsertionSortAlgorithm();
            case LOWEST_INDEX:
                return new LowestIndexAlgorithm();
        }
        return null;
    }
}