package miage.ndia.bowling;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LancerTest {

    private Lancer l;

    @Before
    public void setUp() throws Exception {
        this.l = new Lancer(9);
    }

    @Test
    public void testGetQuillesVrai() {
        int quilles = l.getQuilles();
        assertEquals("Le nombre de quilles tombés n'est pas correct", quilles, 9);
    }

    @Test
    public void testGetQuillesFaux() {
        int quilles = l.getQuilles();
        assertNotEquals("Le nombre de quilles tombés n'est pas sensé être correct", quilles, 8);
    }

    @Test
    public void testSetQuillesVrai() {
        this.l.setQuilles(8);
        int quilles = l.getQuilles();
        assertEquals("Le nombre de quilles n'a pas été mis à jour", quilles, 8);
    }

    @Test
    public void testSetQuillesFaux() {
        this.l.setQuilles(8);
        int quilles = l.getQuilles();
        assertNotEquals("Le nombre de quilles n'est pas sensé être bon", quilles, 9);
    }

    @Test
    public void testIsValideVrai(){
        boolean valide = this.l.isValide();
        assertTrue("Le lancer est bien valide", valide);
    }

    @Test
    public void testIsValideFauxTropHaut(){
        this.l.setQuilles(12);
        boolean valide = this.l.isValide();
        assertFalse("Le lancer n'est pas sensé être valide", valide);
    }

    @Test
    public void testIsValideFauxTropBas(){
        this.l.setQuilles(0);
        boolean valide = this.l.isValide();
        assertFalse("Le lancer n'est pas sensé être valide", valide);
    }
}