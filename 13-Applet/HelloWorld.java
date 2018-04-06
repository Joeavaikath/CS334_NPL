import java.applet.Applet;
import java.awt.Graphics;
 
/*
<applet code="HelloWorld" width=500 height=500>
</applet>
*/
 
// HelloWorld class extends Applet
public class HelloWorld extends Applet 
{
    // Overriding paint() method
    @Override
    public void paint(Graphics g) 
    {
        g.drawString("Hello World", 20, 20);
    }
     
}
