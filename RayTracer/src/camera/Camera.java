package camera;

import java.awt.image.BufferedImage;

import org.joml.Vector3d;

import rays.Ray;
import renderer.Painter;
import utils.ID;

public class Camera {
	
	public String name = Integer.toString(ID.getID());
	
	public Ray getRay(double i, double j) {
		
		//Static viewPlane, can only move camera, not turn
		double x = pos.x - view.w/2 + i*view.xs;
		double y = pos.y - view.h/2 + j*view.ys;
		double z = pos.z;
		
		return new Ray(x, y, z, 0, 0, 1);
		
	}

	protected ViewingPlane view = new ViewingPlane();
	
	protected Painter painter;
	
	public void setPaint(Painter paint) {
		painter = paint;
	}
	
	public Vector3d pos = new Vector3d(0, 0, 0);
	public Vector3d direction = new Vector3d(0, 0, 1);
	
	public ViewingPlane getView() {
		return view;
	}
	
	public void repaint(BufferedImage img) {
		painter.repaint(img);
	}
	
	public Painter getPainter() {
		return painter;
	}
	
	public void setView(ViewingPlane view) {
		this.view = view;
		init();
	}
	
	public void init() {
		
	};
}
