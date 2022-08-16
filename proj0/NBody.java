public class NBody {
    public static double readRadius(String path) {
        double ans;
        In in = new In(path);
        int r = in.readInt();
        ans = in.readDouble();
        return ans;
    }
    public static Planet[] readPlanets(String path) {
        In in = new In(path);
        int n = in.readInt();
        double r = in.readDouble();
        Planet[] ans = new Planet[n];
        for(int i = 0;i < n;i++){
            ans[i] = new Planet(in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readString());
        }
        return ans;
    }
    public static void main(String args[]) {
        double T = Double.parseDouble(args[0]),dt = Double.parseDouble(args[1]);
        String filename = args[2];
        In in = new In(filename);
        int n = in.readInt();
        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);
        String imageToDraw = "images/starfield.jpg";
        StdDraw.setScale(-radius, radius);
        StdDraw.enableDoubleBuffering();
        double now = 0.0;
        while(now < T){
            double[] xForces = new double[n];
            double[] yForces = new double[n];
            for(int i=0;i<planets.length;i++){
                for(int j=0;j<planets.length;j++){
                    if(i == j) continue;
                    xForces[i] += planets[i].calcForceExertedByX(planets[j]);
                    yForces[i] += planets[i].calcForceExertedByY(planets[j]);
                }
                planets[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.clear();
            StdDraw.picture(0, 0, imageToDraw);
            for(int i=0;i<planets.length;i++){
                planets[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            now += dt;
        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                        planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                        planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
        }
    }
}
