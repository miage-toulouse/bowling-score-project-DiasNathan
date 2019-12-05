package miage.ndia.bowling;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PartieTest {

    private Partie p;

    @Before
    public void setUp() throws Exception {
        Jeu[] listeJeux = new Jeu[10];
        listeJeux[0] = new Jeu(1, new Lancer(1), new Lancer(2)); //3
        listeJeux[1] = new Jeu(2, new Lancer(2), new Lancer(3)); //+ 5
        listeJeux[2] = new Jeu(3, new Lancer(4), new Lancer(5)); //+ 9
        listeJeux[3] = new Jeu(4, new Lancer(6), new Lancer(4)); //+ 10 + 8
        listeJeux[4] = new Jeu(5, new Lancer(8), new Lancer(2)); //+ 10 + 10
        listeJeux[5] = new Jeu(6, new Lancer(10), new Lancer(0));//+ 10 + 3
        listeJeux[6] = new Jeu(7, new Lancer(1), new Lancer(2)); //+ 3
        listeJeux[7] = new Jeu(8, new Lancer(3), new Lancer(4)); //+ 7
        listeJeux[8] = new Jeu(9, new Lancer(5), new Lancer(2)); //+ 7
        listeJeux[9] = new Jeu(10, new Lancer(7), new Lancer(2), new Lancer(0));//+ 9
        this.p = new Partie(listeJeux); // 91
    }

    @Test
    public void testIsValideVrai() {
        boolean valide = this.p.isValide();
        assertTrue("La partie est valide", valide);
    }

    @Test
    public void testIsValideFaux() {
        this.p.setJeu(2, new Jeu(2, new Lancer(8), new Lancer(4)));
        boolean valide = this.p.isValide();
        assertFalse("La partie n'est pas sense être valide", valide);
    }

    @Test
    public void testGetScoreVrai() {
        int score = this.p.getScore();
        assertEquals("Le score de la partie est bon", score, 91);
    }

    @Test
    public void testGetScoreFaux() {
        int score = this.p.getScore();
        assertNotEquals("Le score de la partie n'est pas cense être bon", score, 0);
    }
}