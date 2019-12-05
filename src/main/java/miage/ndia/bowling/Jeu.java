package miage.ndia.bowling;

public class Jeu {

    private int numJeu;

    private Lancer lancer1;
    private Lancer lancer2;
    private Lancer lancer3;

    public Jeu(int numJeu, Lancer l1, Lancer l2){
        this.numJeu = numJeu;
        this.lancer1 = l1;
        this.lancer2 = l2;
        this.lancer3 = new Lancer(0);
    }

    public Jeu(int numJeu, Lancer l1, Lancer l2, Lancer l3){
        this.numJeu = numJeu;
        this.lancer1 = l1;
        this.lancer2 = l2;
        this.lancer3 = l3;
    }


    public Lancer getLancer3() {
        return lancer3;
    }

    public void setLancer3(Lancer lancer3) {
        this.lancer3 = lancer3;
    }

    public Lancer getLancer2() {
        return lancer2;
    }

    public void setLancer2(Lancer lancer2) {
        this.lancer2 = lancer2;
    }

    public Lancer getLancer1() {
        return lancer1;
    }

    public void setLancer1(Lancer lancer1) {
        this.lancer1 = lancer1;
    }

    public int getNumJeu() {
        return numJeu;
    }

    public void setNumJeu(int numJeu) {
        this.numJeu = numJeu;
    }

    public boolean isValide() {
        boolean res = true;

        if(lancer1 == null || lancer2 == null || lancer3 == null){
            res = false;
        }
        else if(this.numJeu != 10 && this.lancer3.getQuilles() != 0 || this.numJeu > 10 ||this.numJeu < 1){
            res = false;
        }else if(!this.lancer1.isValide() || !this.lancer2.isValide() || this.lancer3.isValide()){
            res = false;
        }else if(getQuillesTombees() > 10 || getQuillesTombees() < 0){
            res = false;
        }

        return res;
    }

    public int getQuillesTombees() {
        return this.lancer1.getQuilles() + this.lancer2.getQuilles() + this.lancer3.getQuilles();
    }

    public boolean isSpare(){
        return this.getLancer1().getQuilles() + getLancer2().getQuilles() == 10;
    }

    public boolean isStrike(){
        return this.getLancer1().getQuilles() == 10;
    }
}
