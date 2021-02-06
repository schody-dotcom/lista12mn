package edu;

public class VerletIntegrator {
    private CalculateAcceleration calc;
    private ODEupdate stepper;

    public VerletIntegrator(CalculateAcceleration calc, ODEupdate stepper) {
        this.calc = calc;
        this.stepper = stepper;
    }

    public void integrator(double tStart, double tStop, double x0, double v0,  double dt) {

        int n = (int) ((tStop - tStart) / dt);
        double x = x0;
        double v = v0;
        double t = tStart;
        double aOld=calc.a(x);

        for (int i = 0; i < n; i++) {
            stepper.update(t, x, v);

            double vHalf=v+dt*aOld/2;
            x+=dt*vHalf;
            double aNew = calc.a(x);
            v+=dt*(aOld+aNew)/2;
            t+=dt;
            aOld=aNew;

        }


    }

    public void forceIntegrator(double tStart, double tStop, double x0, double v0,  double dt) {

        int n = (int) ((tStop - tStart) / dt);
        double x = x0;
        double v = v0;
        double t = tStart;
        double aOld = calc.a(x);
        double F = 24*(2/Math.pow(x,13)-1/(Math.pow(x,7)));

        for (int i = 0; i < n; i++) {
            stepper.update(t, x, v);

            double vHalf = v + dt * aOld / 2;
            x += dt * vHalf;
            double aNew = calc.a(x);
            v += dt * (aOld + aNew) / 2;
            t += dt;
            aOld = aNew;
            F = 24*(2/Math.pow(x,13)-1/(Math.pow(x,7)));

        }
    }


}
