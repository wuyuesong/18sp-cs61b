public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    static final double G = 6.67e-11;
    public Planet(double xP, double yP, double xV,
              double yV, double m, String img){
                xxPos = xP;
                yyPos = yP;
                xxVel = xV;
                yyVel = yV;
                mass = m;
                imgFileName = img;
              }
    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }
    public double calcDistance(Planet p) {
        double ans;
        double dx = this.xxPos-p.xxPos;
        double dy = this.yyPos-p.yyPos;
        ans = Math.sqrt(dx*dx + dy*dy);
        return ans;
    }
    public double calcForceExertedBy(Planet p){
        double r = calcDistance(p);
        double ans = G*this.mass*p.mass/(r*r);
        return ans;
    }
    public double calcForceExertedByX(Planet p){
        double r = calcDistance(p);
        double F = calcForceExertedBy(p);
        double dx = p.xxPos - this.xxPos;
        if(dx == 0){
            return 0.0;
        }
        double ans = F*dx/r;
        return ans;
    }
    public double calcForceExertedByY(Planet p){
        double r = calcDistance(p);
        double F = calcForceExertedBy(p);
        double dy = p.yyPos - this.yyPos;
        if(dy == 0){
            return 0.0;
        }
        double ans = F*dy/r;
        return ans;
    }
    public void update(double dt,double fX,double fY) {
        double aX,aY;
        aX = fX/mass;
        aY = fY/mass;
        xxVel = xxVel + dt * aX;
        yyVel = yyVel + dt * aY;
        xxPos = xxPos + dt * xxVel;
        yyPos = yyPos + dt * yyVel;
    }
    public void draw() {
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}
