package src.Eredua;

public class Osasuntsu implements Egoera{
    @Override
    public void sendatu(Tamagotchi tamagotchi) {}

    @Override
    public void kakaEgin(Tamagotchi tamagotchi) {
        tamagotchi.setEgoeraGK(new Kaka());
        //tamagotchi.setKaka(true);
    }

    @Override
    public void gaixotu(Tamagotchi tamagotchi) {
        tamagotchi.setEgoeraGK(new Gaixorik());
        //tamagotchi.setGaixorik(true);
    }

    @Override
    public void eboluzionatu(Tamagotchi tamagotchi) {}

    @Override
    public void kontadoreakEguneratu(Tamagotchi tamagotchi) {}
    
}
