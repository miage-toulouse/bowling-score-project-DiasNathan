package miage.ndia.bowling;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JeuTest {

    private Jeu j;

    @Before
    public void setUp() throws Exception {
        Lancer l1 = new Lancer(1);
        Lancer l2 = new Lancer(2);
        Lancer l3 = new Lancer(0);
        this.j = new Jeu(1, l1, l2, l3);
    }

    @Test
    public void testGetQuillesTombeesVrai() {
        int score = this.j.getQuillesTombees();
        assertEquals("Le score est correct", score, 3);
    }

    @Test
    public void testGetQuillesTombeesFaux() {
        int score = this.j.getQuillesTombees();
        assertNotEquals("Le score n'est pas sense être correct", score, 4);
    }

    @Test
    public void testIsValideVrai(){
        boolean valide = this.j.isValide();
        assertTrue("Le jeu est bien valide", valide);
    }

    @Test
    public void testIsValideFauxJeuInvalide(){
        this.j.setLancer3(new Lancer(3));
        boolean valide = this.j.isValide();
        assertFalse("Le jeu n'est pas sensé être valide", valide);
    }

    @Test
    public void testIsValideFauxLancerInvalide(){
        this.j.setLancer1(new Lancer(12));
        boolean valide = this.j.isValide();
        assertFalse("Le jeu n'est pas sensé être valide", valide);
    }

}