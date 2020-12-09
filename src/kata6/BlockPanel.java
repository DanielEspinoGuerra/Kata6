
package kata6;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import kata6.model.Block;
import kata6.view.BlockDisplay;

class BlockPanel extends JPanel implements BlockDisplay{
    private static final int size = 100;
    private Block block;
    
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getWidth());
        
        int d = block.MAX * size;
        g.setColor(Color.black);
        for(int i = 0; i <= block.MAX; i++) {
            int c = i * size;
            g.drawLine(0, c, d, c);
            g.drawLine(c, 0, c, d);
        }
        
        if(block == null) return;
        g.setColor(Color.blue);
        g.fillRect((block.x() - 1)*size, (block.MAX - block.y())*size, size, size);
    }
    
    @Override
    public void display(Block block) {
        this.block = block;
        repaint();
    }  
    
    @Override
    public void changed() {
        repaint();
    }
}
