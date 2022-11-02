package ru.mirea.pr10;

public interface AbstractChairFactory<E> {
    VictorianChair createVictorianChair();
    MagicChair createMagicChair();
    MultifunctionalChair createMultifunctionalChair();
}
