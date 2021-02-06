package edu;

public class Main {

    public static void main(String[] args) {

        ConsoleStepper stepper = new ConsoleStepper();
        VerletIntegrator verletIntegrator = new VerletIntegrator(x -> -x, stepper);
        verletIntegrator.integrator(0, Math.PI, 1, 0, 0.01);
//        VerletIntegrator verletIntegrator = new VerletIntegrator
//                (x -> 24*(2/Math.pow(x,13)-1/(Math.pow(x,7))), stepper);
      //  verletIntegrator.integrator(0, 5, 2, 0, 0.01);
        stepper.getT_X(10);
    }
}
