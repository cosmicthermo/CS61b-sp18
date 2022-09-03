

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

		// Drawing the background
		String imageToDraw = "./images/starfield.jpg";

		StdDraw.setScale(-xxMax, xxMax);
		/* Clears the drawing window. */
		StdDraw.clear();
		StdDraw.picture(0, 0, imageToDraw);

		// String planetDraw = "./images/earth.gif"

		/* Drawing all planets */
		System.out.println(allPlanets);
		for (Planet planet: allPlanets) {
			planet.drawPlanet();
			// StdDraw.show();
		}

		// /* Shows the drawing to the screen, and waits 2000 milliseconds. */
		// StdDraw.show();
		// // StdDraw.pause(2000);


	}


}