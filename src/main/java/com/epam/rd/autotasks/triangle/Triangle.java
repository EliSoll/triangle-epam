package com.epam.rd.autotasks.triangle;

class Triangle {
    private final Point a;
    private final Point b;
    private final Point c;
    double length1, length2, length3;

    public Triangle(Point a, Point b, Point c) {
        if (a == null || b == null || c == null){
            throw new IllegalArgumentException("Arguments can't be null");}
        if ((a.getX()-b.getX())*(c.getY()-b.getY())-(a.getY()-b.getY())*(c.getX()-b.getX())==0) {
        throw new IllegalArgumentException("Triangle is degenerative");}
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double area() {
        //length 1
        double xDistanceSquare = Math.pow(a.getX() - b.getX(), 2.0);
        double yDistanceSquare = Math.pow(a.getY() - b.getY(), 2.0);
        length1 = Math.sqrt(xDistanceSquare + yDistanceSquare);
        //length 2
        double xDistanceSquare2 = Math.pow(a.getX() - c.getX(), 2.0);
        double yDistanceSquare2 = Math.pow(a.getY() - c.getY(), 2.0);
        length2 = Math.sqrt(xDistanceSquare2 + yDistanceSquare2);
        //length 3
        double xDistanceSquare3 = Math.pow(c.getX() - b.getX(), 2.0);
        double yDistanceSquare3 = Math.pow(c.getY() - b.getY(), 2.0);
        length3 = Math.sqrt(xDistanceSquare3 + yDistanceSquare3);

        double s = (length1+length2+length3)/2; // semi-perimeter

        return Math.sqrt(s*(s-length1)*(s-length2)*(s-length3));
    }

    public Point centroid(){
        double xc = (((a.getX()+b.getX()+c.getX())/3));
        double yc = (((a.getY()+b.getY()+c.getY())/3));
        return new Point(xc, yc);
    }

}
