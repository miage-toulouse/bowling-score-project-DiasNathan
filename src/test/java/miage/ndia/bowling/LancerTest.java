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
    public void testGetQuilles() {
        int quilles = l.getQuilles();
        assertEquals("Le nombre de quilles tombés n'est pas correct", quilles, 9);
    }

    @Test
    public void testSetQuilles() {
        this.l.setQuilles(8);
        int quilles = l.getQuilles();
        assertEquals("Le nombre de quilles n'a pas été mis à jour", quilles, 8);
    }
}