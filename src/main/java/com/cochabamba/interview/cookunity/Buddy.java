public class Buddy {
    private int id;
    private char codeLetter;
    private String name;
    private float money;
    private boolean isActive;

    public Buddy() {
//        this.id = 0;
//        this.codeLetter = 'A';
//        this.name = "Buddy";
//        this.money = 0.0f;
//        this.isActive = true;
    }

    public Buddy(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getCodeLetter() {
        return codeLetter;
    }
    public void setCodeLetter(char codeLetter) {
        this.codeLetter = codeLetter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public static void main(String[] args) {
        // Create an instance of Buddy
        Buddy buddy = new Buddy("Ariel");

        System.out.println("Buddy ID: " + buddy.id);
        System.out.println("Buddy Code Letter: " + buddy.codeLetter);
        System.out.println("Buddy Name: " + buddy.name);
        System.out.println("Buddy Money: " + buddy.getMoney());
        System.out.println("Buddy isActive: " + buddy.isActive());
        float moreMoney = buddy.getMoney()+100.5f;
        System.out.println("Buddy More Money: " + moreMoney);
        int number = 0;
        System.out.println("Buddy Number: " + number);
    }
}
