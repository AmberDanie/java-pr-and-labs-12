package ru.mirea.pr10;

public class ChairFactory implements AbstractChairFactory {
    @Override
    public VictorianChair createVictorianChair() {
        return new VictorianChair();
    }

    @Override
    public MagicChair createMagicChair() {
        return new MagicChair();
    }

    @Override
    public MultifunctionalChair createMultifunctionalChair() {
        return new MultifunctionalChair();
    }
}
