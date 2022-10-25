package com.papiricoh.nukemod.energysystem;

public class NukeEnergy {
    private int transfer_quantity;
    private int capacity;

    public static final int LOW_QUALITY_TRANSFER_QUANTITY = 100;
    public static final int LOW_QUALITY_CAPACITY = 1000;
    public static final int MEDIUM_QUALITY_TRANSFER_QUANTITY = 400;
    public static final int MEDIUM_QUALITY_CAPACITY = 4000;
    public static final int HIGH_QUALITY_TRANSFER_QUANTITY = 1000;
    public static final int HIGH_QUALITY_CAPACITY = 10000;
    public static final int PREMIUM_QUALITY_TRANSFER_QUANTITY = 4000;
    public static final int PREMIUM_QUALITY_CAPACITY = 40000;

    public NukeEnergy(int transfer_quantity, int capacity) {
        this.transfer_quantity = transfer_quantity;
        this.capacity = capacity;
    }

    public int getEnergyCuantity() {
        return this.transfer_quantity;
    }

    public int getEnergyCapacity() {
        return this.capacity;
    }

    public int transfer_energy(NukeEnergy receiver, int energy) {
        if (energy <= this.transfer_quantity && receiver.canReceiveEnergy(energy)) {
            receiver.receiveEnergy(energy);
            this.transfer_quantity = this.transfer_quantity - energy;
            return energy;
        }
        return 0;
    }

    public int receiveEnergy(int energy) {
        this.transfer_quantity = this.transfer_quantity + energy;
        return energy;
    }

    private boolean canReceiveEnergy(int energy){
        if (energy + this.transfer_quantity > this.capacity){
            return false;
        }
        return true;
    }
}
