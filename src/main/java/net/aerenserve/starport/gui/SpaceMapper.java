package net.aerenserve.starport.gui;

import java.awt.Color;

import net.aerenserve.starport.engine.location.Mappable;

import org.math.plot.FrameView;
import org.math.plot.Plot3DPanel;


public class SpaceMapper {
	
	private Mappable mappable;

	public SpaceMapper(Mappable mappable) {
		this.mappable = mappable;
	}

	public void openMap() {
		Plot3DPanel plot3d = new Plot3DPanel();
		plot3d.addScatterPlot("plot", mappable.getPoints());
		double[] origin = {0,0,0};
		plot3d.getAxis(0).setOrigin(origin);
		plot3d.getAxis(1).setOrigin(origin);
		plot3d.getAxis(2).setOrigin(origin);

		FrameView fw = new FrameView(plot3d);
		fw.setBackground(Color.BLACK);
		fw.setVisible(true);
	}
}
