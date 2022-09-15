public class Planet {
	/**
	 * Create variable
	 **/
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	private static final double gFactor = 6.67e-11;

	// Constructor
	public Planet(double xP, double yP, double xV, 
			double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p) {
		this.xxPos = p.xxPos;
		this.yyPos = p.yyPos;
		this.xxVel = p.xxVel;
		this.yyVel = p.yyVel;
		this.mass = p.mass;
		this.imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet other) {
		return Math.sqrt(Math.pow(this.xxPos-other.xxPos,2) + Math.pow(this.yyPos-other.yyPos,2));
	}

	public double calcForceExertedBy(Planet other) {
		double distSquare = Math.pow(this.calcDistance(other), 2);
		return gFactor * this.mass * other.mass / distSquare;
	}
	
	public double calcForceExertedByX(Planet otherPlanet) {
		double dx = otherPlanet.xxPos - this.xxPos;
		return this.calcForceExertedBy(otherPlanet) * dx / this.calcDistance(otherPlanet);
	}
	public double calcForceExertedByY(Planet otherPlanet) {
		double dy = otherPlanet.yyPos - this.yyPos;
		return this.calcForceExertedBy(otherPlanet) * dy / this.calcDistance(otherPlanet);
	}

	public double calcNetForceExertedByX(Planet[] allPlanets) {
		double netForce = 0;
		for (Planet planet: allPlanets) {
			if (this == planet) {
				continue;
			}
			netForce += this.calcForceExertedByX(planet);
		}
		return netForce;
	}

	public double calcNetForceExertedByY(Planet[] allPlanets) {
		double netForce = 0;
		for (Planet planet: allPlanets) {
			if (this == planet) {
				continue;
			}
			netForce += this.calcForceExertedByY(planet);
		}
		return netForce;
	}

	public void update(double dt, double fX, double fY) {
		// acceleration
		double accX = fX / this.mass;
		double accY = fY / this.mass;

		// new velocity of x and y
		this.xxVel = this.xxVel + dt * accX;
		this.yyVel = this.yyVel + dt * accY;

		// new position of x y 
		this.xxPos = this.xxPos + dt * xxVel;
		this.yyPos = this.yyPos + dt * yyVel;
	}

	// Drawing one Planet
	public void draw() {
		String pathname ="./images/";
		String fileName = pathname + imgFileName;
	 	StdDraw.picture(xxPos, yyPos, fileName);
		 /* Shows the drawing to the screen. */
		StdDraw.show();
	}

}