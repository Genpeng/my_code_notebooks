package ai.labrador.lambda;

public class Hero implements Comparable<Hero> {
    public String name;
    public float hp;
    public int damage;

    public Hero() {

    }

    public Hero(String name) {
        this.name = name;
    }

    public Hero(String name, float hp, int damage) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }

    @Override
    public int compareTo(Hero anotherHero) {
        if (this.damage > anotherHero.damage) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return String.format("Hero: %s, HP: %f, Damage: %d", name, hp, damage);
    }
}
