//bridge pettern

//Devices (implementation)
interface Device {
    void turnOn();
    void turnOff();
    void setVolume(int level);
}

class Radio implements Device {
    public void turnOn() {
        System.out.println("Radio starts playing static/music.");
    }

    public void turnOff() {
        System.out.println("Radio turns off.");
    }

    public void setVolume(int level) {
        System.out.println("Radio volume knob turned to: " + level);
    }
}

//Task 4
class SmartLight implements Device {
    public void turnOn() {
        System.out.println("Smart Light glows bright white.");
    }

    public void turnOff() {
        System.out.println("Smart Light shuts off.");
    }

    public void setVolume(int level) {
        System.out.println("Smart Light brightness set to: " + level + "%");
    }
}

//Remotes (abstraction)
class BasicRemote {
    protected Device device;

    public BasicRemote(Device device) {
        this.device = device;
    }

    public void powerOn() {
        device.turnOn();
    }

    public void powerOff() {
        device.turnOff();
    }
}

class AdvancedRemote extends BasicRemote {
    public AdvancedRemote(Device device) {
        super(device);
    }

    public void mute() {
        System.out.println("[Remote] Mute button pressed!");
        device.setVolume(0);
    }
}

//Task 5
class PartyRemote extends BasicRemote {
    public PartyRemote(Device device) {
        super(device);
    }

    public void partyMode() {
        System.out.println("[Party Remote] Pumping up the party!");
        device.turnOn();
        device.setVolume(100);
    }
}

//Task 6
interface Weapon {
    void use();
}

class Sword implements Weapon {
    public void use() {
        System.out.println("Slash! Dealing 20 physical damage.");
    }
}

class MagicWand implements Weapon {
    public void use() {
        System.out.println("Zap! Dealing 35 magic damage.");
    }
}

abstract class Hero {
    protected Weapon weapon;

    public Hero(Weapon weapon) {
        this.weapon = weapon;
    }
}

class Knight extends Hero {
    public Knight(Weapon weapon) {
        super(weapon);
    }

    public void attack() {
        weapon.use();
    }
}

class Wizard extends Hero {
    public Wizard(Weapon weapon) {
        super(weapon);
    }

    public void attack() {
        weapon.use();
    }
}

public class main7 {
    public static void main(String[] args) {
        //Task 4
        Device light = new SmartLight();
        AdvancedRemote remote = new AdvancedRemote(light);
        remote.powerOn();
        remote.mute();
        System.out.println();

        //Task 5
        Device radio = new Radio();
        PartyRemote partyRemote = new PartyRemote(radio);
        partyRemote.partyMode();
        System.out.println();

        //Task 6
        Knight knight1 = new Knight(new Sword());
        knight1.attack();
        Knight knight2 = new Knight(new MagicWand());
        knight2.attack();
    }
}