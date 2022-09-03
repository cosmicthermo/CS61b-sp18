

public class NBody {
	private static int numberPlanets;

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
		

	}


}