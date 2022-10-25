package com.papiricoh.nukemod.energysystem;

public class NuclearReactor {
    private boolean isOn;
    private NuclearFuel[] nuclear_fuel;
    private ControlRod[] control_rods;
    private boolean second_mode;
    private int heat;
    private int to_heat;


    private static final int MIN_HEAT = 20;
    private static final int MAX_HEAT = 600;


    public NuclearReactor() {
        this.isOn = false;
        this.nuclear_fuel = new NuclearFuel[6];
        this.control_rods = new ControlRod[8];
        this.heat = 30;
    }

    private int calculateOutputEnergy() {
        if (isOn) {
            return calculateNuclear_fuel_output() - (int) (calculateControl_rod_security() * 0.2);
        }
        return 0;
    }

    public void setSecond_mode(boolean second_mode) {
        this.second_mode = second_mode;
    }
    public boolean getSecond_mode() {
        return this.second_mode;
    }

    public int tick() {
        if (isOn) {
            return checkStatus();
        }
        return 0;
    }

    private int checkStatus() {
        //Calcular Calor desprendido
        this.heat = calculateHeat();
        if (this.heat > MAX_HEAT ){
            //CUENTA ATRAS EXPLOSION
            return 0;
        }
        return calculateOutputEnergy();
    }

    private int calculateHeat() {
        return 0; //TODO
    }

    private int calculateControl_rod_security() {
        int total_absorption = 0;
        for(int i = 0; i < control_rods.length; i++ ) {
            if (this.control_rods[i] != null) {
                total_absorption = total_absorption + this.control_rods[i].getAbsorption_power();
            }
        }
        return total_absorption;
    }

    private int calculateNuclear_fuel_output() {
        int total_output = 0;
        for (int i = 0; i < nuclear_fuel.length; i++) {
            if (this.nuclear_fuel[i] != null) {
                total_output = total_output + this.nuclear_fuel[i].tick(this.second_mode);
            }
        }
        return total_output;
    }


}
