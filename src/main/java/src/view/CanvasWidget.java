/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author roman
 */
public class CanvasWidget {
    
    
    private Rectangle bounds = new Rectangle(0,0,10,10);
		private boolean moving = false;
		public CanvasWidget() {

		}
		public Rectangle getBounds() {
			return bounds;
		}
		public void setBounds(Rectangle bounds) {
			this.bounds = bounds;
		}
		protected void paint(Graphics g) {
			if ( isMoving() )
				g.setColor(Color.LIGHT_GRAY);
			else
				g.setColor(Color.DARK_GRAY);
			g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
		}
		public boolean isMoving() {
			return moving;
		}
		public void setMoving(boolean moving) {
			this.moving = moving;
		}
    
}
