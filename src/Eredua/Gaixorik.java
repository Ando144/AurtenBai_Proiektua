package src.Eredua;

public class Gaixorik implements Egoera{
    @Override
    public void sendatu(Tamagotchi tamagotchi) {
        Partida.getPartida().getTamagotchi().setEgoeraGK(new Osasuntsu());
        Partida.getPartida().getTamagotchi().setGaixorik(false);
    }

    @Override
    public void kakaEgin(Tamagotchi tamagotchi) {}

    @Override
    public void gaixotu(Tamagotchi tamagotchi) {}

    @Override
    public void eboluzionatu(Tamagotchi tamagotchi) {}

    @Override
    public void kontadoreakEguneratu(Tamagotchi tamagotchi){}

}
