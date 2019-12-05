package miage.ndia.bowling;

public class Partie {
    private Jeu[] listeJeux = new Jeu[10];

    public Partie(Jeu[] jeux){
        this.listeJeux = jeux;
    }

    public boolean isValide(){
        boolean res = true;

        if(this.listeJeux.length != 10){
            res = false;
        }else {
            for (int i = 0 ; i < 10 && res ; i++) {
                res = this.listeJeux[i].isValide();
            }
        }

        return res;
    }

    public int getScore(){
        int score = 0;
        Jeu jeu = null;
        Jeu jeuPlusUn = null;
        Jeu jeuPlusDeux = null;
        for(int i = 0 ; i < 10 ; i++){
            jeu = this.listeJeux[i];
            // score += this.listeJeux[i].getLancer1().getQuilles();
            if(i == 9){
                score += jeu.getQuillesTombees();
                if(this.listeJeux[i].isSpare()){
                    score += jeu.getLancer3().getQuilles();
                } else if(this.listeJeux[i].isStrike()){
                    score += jeu.getLancer2().getQuilles();
                }
            } else if(i == 8){
                jeuPlusUn = this.listeJeux[i+1];
                jeuPlusDeux = this.listeJeux[i+2];
                if(jeu.isStrike() && jeuPlusUn.isStrike()){
                    score += jeu.getQuillesTombees() + jeuPlusUn.getQuillesTombees() + jeuPlusDeux.getLancer1().getQuilles();
                }
            }

        }

        return score;
    }

    public void setJeu(int index, Jeu jeu){
        if(jeu != null) {
            this.listeJeux[index] = jeu;
        }
    }

    public Jeu[] getListeJeux() {
        return listeJeux;
    }

    public void setListeJeux(Jeu[] listeJeux) {
        this.listeJeux = listeJeux;
    }


}
