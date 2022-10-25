package com.papiricoh.nukemod.energysystem;

public class ControlRod {
    private int rod_material; //1: silver, 2:iridium
    private int absorption_power; //Capacity of the rod to absorb power

    public ControlRod(int rod_material, int absorption_power) {
        this.rod_material = checkRodMaterial(rod_material);
        this.absorption_power = absorption_power;
    }

    private int checkRodMaterial(int rod_material) {
        if (rod_material != 1 && rod_material != 2) {
            return 1;
        }
        return rod_material;
    }

    public int getAbsorption_power() {
        return rod_material * absorption_power;
    }

}
