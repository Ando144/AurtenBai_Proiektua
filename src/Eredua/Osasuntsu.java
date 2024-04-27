package src.Eredua;

public class Osasuntsu implements EgoeraGK{
    @Override
    public void sendatu(Tamagotchi tamagotchi) {
        tamagotchi.setEgoeraGK(new Osasuntsu());
        tamagotchi.setGaixorik(false);
        tamagotchi.setKaka(false);
    }

    @Override
    public void kakaEgin(Tamagotchi tamagotchi) {
        tamagotchi.setEgoeraGK(new Kaka());
        tamagotchi.setKaka(true);
    }

    @Override
    public void gaixotu(Tamagotchi tamagotchi) {
        tamagotchi.setEgoeraGK(new Gaixorik());
        tamagotchi.setGaixorik(true);
    }

    @Override
    public void eboluzionatu(Tamagotchi tamagotchi) {}
    
}
