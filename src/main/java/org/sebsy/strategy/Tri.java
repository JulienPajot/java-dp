package org.sebsy.strategy;

public class Tri {

    public void exec(int typeTri, Integer[] arr) {
        AlgorithmTypeEnum type = AlgorithmTypeEnum.values()[typeTri - 1];
        Strategy strategy = StrategyFactory.getStrategy(type);
        strategy.trier(arr);
    }
}
