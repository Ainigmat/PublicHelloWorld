package Logic;

public class Line {

	public int x,y,xEnd,yEnd;
	
	public Line(int xStart,int yStart,int xEnd,int yEnd){
		this.x=xStart;
		this.y=yStart;
		this.xEnd=xEnd;
		this.yEnd=yEnd;
	}
	public Line(double xStart,double yStart,double xEnd,double yEnd){
		this.x=(int)xStart;
		this.y=(int)yStart;
		this.xEnd=(int)xEnd;
		this.yEnd=(int)yEnd;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getXend() {
		return xEnd;
	}

	public void setXend(int xend) {
		this.xEnd = xend;
	}

	public int getYend() {
		return yEnd;
	}

	public void setYend(int yend) {
		this.yEnd = yend;
	}
	
}
