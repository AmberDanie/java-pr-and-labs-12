package ru.mirea.pr10;

public class Main {
    public static void main(String[] args) {
        ChairFactory factory = new ChairFactory();
        Client client = new Client();
        MultifunctionalChair first_chair = factory.createMultifunctionalChair();
        MagicChair second_chair = factory.createMagicChair();
        VictorianChair third_chair = factory.createVictorianChair();

        System.out.print("You take your multifunctional chair.\n\t");
        first_chair.cook();
        System.out.print("\t");
        first_chair.calculate(5, 7);
        System.out.print("\t");
        first_chair.jump();
        client.setChair(first_chair);
        client.sit();

        System.out.print("Now you take your magic chair.\n\t");
        second_chair.doMagic();
        client.setChair(second_chair);
        client.sit();

        System.out.print("Time for third chair.\n\t");
        third_chair.introduce();
        client.setChair(third_chair);
        client.sit();
    }
}
