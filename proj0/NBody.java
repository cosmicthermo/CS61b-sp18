

public class NBody {
	private static int numberPlanets;
	private static double scale = 1.15;

	public static double readRadius(String url) {
		In in = new In(url);

		numberPlanets = in.readInt();
		double radius = in.readDouble();
		return radius;
	}

	public static Planet[] readPlanets(String url) {
		In in = new In(url);
		int nub = in.readInt();
		double radius = in.readDouble();
		Planet[] arrPlanet = new Planet[nub];
		int idx = 0;


		while (!in.isEmpty()) {
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();
			String planetName = in.readString();

			Planet planet = new Planet(xxPos, yyPos, xxVel, yyVel, mass, planetName);
			arrPlanet[idx] = planet;
			idx++;
			if (idx >= nub) {
				break;
			}
					
		}

		return arrPlanet;
	}

	public static void main(String[] args) {
		
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);

		String filename = args[2];
		double radius = readRadius(filename);
		Planet[] allPlanets = readPlanets(filename);
		double xxMax = 0;
		// double yyMax = 0;
		for (Planet plt: allPlanets) {
			xxMax = Math.max(xxMax, plt.xxPos);
			xxMax = Math.max(xxMax, plt.yyPos);
		}
		xxMax = scale * xxMax;
		StdDraw.enableDoubleBuffering();

		/** Declare time variable */
		double timeVar = 0.0;
		while (timeVar < T) {
			int length = allPlanets.length;
			double[] xForces = new double[length];
			double[] yForces = new double[length];
			for (int i = 0; i < length; i++) {
				double xforce = allPlanets[i].calcNetForceExertedByX(allPlanets);
				double yforce = allPlanets[i].calcNetForceExertedByY(allPlanets);
				xForces[i] = (xforce);
				yForces[i] = (yforce);
				allPlanets[i].update(timeVar, xforce, yforce);
				// Drawing the background
				String imageToDraw = "./images/starfield.jpg";

				StdDraw.setScale(-xxMax, xxMax);
				/* Clears the drawing window. */
				StdDraw.clear();
				StdDraw.picture(0, 0, imageToDraw);

				/* Drawing all planets */
				System.out.println(allPlanets);
				for (Planet planet: allPlanets) {
					planet.drawPlanet();
					// StdDraw.show();
				}	
				StdDraw.show();
				StdDraw.pause(10);
				timeVar += dt;

			}

		}
		StdOut.printf("%d\n", allPlanets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < allPlanets.length; i++) {
		    StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
		                  allPlanets[i].xxPos, allPlanets[i].yyPos, allPlanets[i].xxVel,
		                  allPlanets[i].yyVel, allPlanets[i].mass, allPlanets[i].imgFileName);   
}

		

		// String planetDraw = "./images/earth.gif"

		
		// /* Shows the drawing to the screen, and waits 2000 milliseconds. */
		StdDraw.show();
		StdDraw.pause(2000);
		// StdDraw.enableDoubleBuffering();


	}


}