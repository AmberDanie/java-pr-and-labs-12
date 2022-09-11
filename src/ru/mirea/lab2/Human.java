package ru.mirea.lab2;

public class Human {
    private final String skinColor;
    private final String humanName;
    private final String gender;
    private final Head head;
    private final Leg leftLeg, rightLeg;
    private final Hand leftHand, rightHand;
    private final Hand leadingHand; // dominant hand pointer
    public Human(String _humanName, String _gender,
                 String _skinColor, String _hairColor,
                 String _eyesColor, boolean rightHanded) {
        head = new Head();
        leftLeg = new Leg("left");
        rightLeg = new Leg("right");
        leftHand = new Hand("left");
        rightHand = new Hand("right");

        this.humanName = _humanName;
        this.gender = _gender;
        this.skinColor = _skinColor;
        head.setHairColor(_hairColor);
        head.setEyesColor(_eyesColor);

        if (rightHanded)
            leadingHand = rightHand;
        else
            leadingHand = leftHand;
        if (gender.equals("m"))
            System.out.println("!!!!!!!!There is new man on the Earth");
        else
            System.out.println("!!!!!!!!There is new woman on the Earth");
    }
    public Human() {
        head = new Head();
        leftLeg = new Leg("left");
        rightLeg = new Leg("right");
        leftHand = new Hand("left");
        rightHand = new Hand("right");

        this.humanName = "Eve";
        this.gender = "Female";
        this.skinColor = "white";
        head.setEyesColor("brown");
        head.setHairColor("dark");
        leadingHand = rightHand;
        System.out.println("!!!!!!!!There is new woman on the Earth");
    }

    public String getSkinColor() {
        return skinColor;
    }

    public String getHumanName() {
        return humanName;
    }

    public void walk() {
        leftLeg.raiseLeg();
        leftLeg.moveForward();
        leftLeg.lowerLeg();
        rightLeg.raiseLeg();
        rightLeg.moveForward();
        rightLeg.lowerLeg();
    }
    public void talk() {
        if (!head.isMouthIsOpen())
            head.openMouth();
        System.out.println(this.getHumanName() + " said something interesting");
        head.closeMouth();
    }
    public void talk(String phrase) {
        if (!head.isMouthIsOpen())
            head.openMouth();
        System.out.println(this.getHumanName() + " said: " + phrase);
        head.closeMouth();
    }
    public void take() {
        leadingHand.moveForward();
        leadingHand.clenchHand();
        leadingHand.moveBack();
        System.out.println(this.getHumanName() + " took something");
    }
    public void eat() {
        if (!rightHand.isClenched() && !leftHand.isClenched())
            System.out.println("Take something before eat");
        else {
            leadingHand.raiseHand();
            head.openMouth();
            head.chew();
            head.closeMouth();
            leadingHand.lowerHand();
            System.out.println(this.getHumanName() + " eat something");
        }
    }
}
