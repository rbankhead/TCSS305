/**
 * 
 */
package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gui.SnapShopGUI;

/**
 * @author richardbankhead
 *
 */
class GUITests {
    
    private static SnapShopGUI g;
    private static SnapShopGUI s;
    
    /**
     * @throws java.lang.Exception
     */
    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        g = new SnapShopGUI();
        s = new SnapShopGUI(); //s never has start() called and is used to test calling the methods in SnapShopGUI independently of the start method()
        g.start();
    }
    
    @Test
    void testFrame() {
        assertNotNull(g.getFrame(), "Test case 1.1");
        assertEquals(g.getFrame().getTitle(),"TCSS 305 - Assignment 4 (rbank)", "Test case 1.1");
        assertTrue(g.getFrame().isResizable(), "Test case 4.4");
    }
    
    @Test
    void testFilterButtons() {
        s.makeFilterButtons();
        for(int i=0;i<g.getFilterButtons().length;i++) {
            assertNotNull(g.getFilterButtons()[i].getActionListeners(),"Test case 5.1");
            assertNotNull(s.getFilterButtons()[i].getActionListeners(),"Test case 5.1");
            
        }
        for(int i=0;i<g.getFilterButtons().length;i++) {
            g.getFilterButtons()[i].doClick();
            assertNull(g.getPixelImage(),"Test case 5.1");
        }
    }
    
    @Test
    void testMenuButtons() {
        s.makeMenuButtons();
        for(int i=0;i<g.getMenuButtons().length;i++) {
            assertNotNull(g.getMenuButtons()[i].getActionListeners(),"Test case 3.1");
            assertNotNull(s.getMenuButtons()[i].getActionListeners(),"Test case 3.1");
            
        }
    }
    @Test
    void testButtonEnable() {
        for(int i=0;i<g.getFilterButtons().length;i++) {
            assertFalse(g.getFilterButtons()[i].isEnabled(), "Test case 2.11");
        }
        g.setButtonEnable(true);
        for(int i=0;i<g.getFilterButtons().length;i++) {
            assertTrue(g.getFilterButtons()[i].isEnabled(), "Test case 2.12");
        }
        g.setButtonEnable(false);
    }
}
