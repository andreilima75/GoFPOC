static class CPU {
    void start() {
        System.out.println("CPU start");
    }
}

static class Memory {
    void load() {
        System.out.println("Memory load");
    }
}

static class HDD {
    void read() {
        System.out.println("HDD read");
    }
}

static class ComputerFacade {
    private final CPU cpu = new CPU();
    private final Memory mem = new Memory();
    private final HDD hdd = new HDD();

    void start() {
        cpu.start();
        mem.load();
        hdd.read();
        System.out.println("Computer ready.");
    }
}

void main() {
    new ComputerFacade().start();
}
