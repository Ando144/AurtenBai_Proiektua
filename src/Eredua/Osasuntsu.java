package src.Eredua;

public class Osasuntsu implements EgoeraGK{
    @Override
    public void sendatu(Tamagotchi tamagotchi) {
        System.out.println("NNNNNNNNNNNNN0OOOOOOOOUUUUU");
    }

    @Override
    public void kakaEgin(Tamagotchi tamagotchi) {
        tamagotchi.setEgoeraGK(new Kaka());
        tamagotchi.setKaka(true);
        System.out.println("ME CAGAOOOOOOOOOOOOOOOOOOOOOO");
    }

    @Override
    public void gaixotu(Tamagotchi tamagotchi) {
        tamagotchi.setEgoeraGK(new Gaixorik());
        tamagotchi.setGaixorik(true);
        System.out.println("ME ENFERMAOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
    }

    @Override
    public void eboluzionatu(Tamagotchi tamagotchi) {}
    
}
