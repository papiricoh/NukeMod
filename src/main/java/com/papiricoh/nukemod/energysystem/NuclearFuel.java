package com.papiricoh.nukemod.energysystem;

import java.util.Random;

public class NuclearFuel {
    private int fuel_class; //0: uranium, 1: MOX (plutonium), 2: TRIGA (Especial reactor)
    private int tick_life;//20 ticks = 1 second, min tick life 1200 (1min), max tick life 240000
    private int status; //0: Waste, 1: Final Uses, 2: Middle Life 3: Almost New, 4: Pure fuel
    private int base_output;
    private boolean boost_mode; //Toggle Boost Mode Expands random ticks

    public static final int MAX_TICK_LIFE = 240000;
    public static final int MIN_TICK_LIFE = 1200;


    public NuclearFuel(int fuel_class, int tick_life, int base_output){
        this.fuel_class = fuel_class;
        this.tick_life = tick_life;
        this.base_output = base_output;
        this.status = calculateStatus(tick_life);
        this.boost_mode = false;
    }

    public String printClass() {
        if (this.fuel_class == 1) {
            return "MOX";
        }else if (this.fuel_class == 2) {
            return "TRIGA";
        }
        return "Uranium";
    }

    public boolean toggleBoostMode() {
        this.boost_mode = !this.boost_mode;
        return this.boost_mode;
    }

    public String printStatus() {
        if (this.status == 1){
            return "Final Uses";
        } else if (this.status == 2) {
            return "Middle Life";
        } else if (this.status == 3) {
            return "Almost New";
        }else if (this.status == 4) {
            return "Pure Fuel";
        }
        return "Waste";
    }


    public int tick(boolean second_mode) { //Returns Output: output/2 == radiation
        if (!second_mode) {
            this.tick_life--;
            calculateStatus(this.tick_life);
            return calculateOutput(base_output);
        }else {
            this.tick_life = this.tick_life - 20;
            calculateStatus(this.tick_life);
            return calculateOutput(base_output) * 20;
        }
    }

    private int calculateOutput(int base_output) {
        Random random = new Random();
        double efficiency = 0;
        switch (this.status) {
            case 0: efficiency = 0;
            case 1: efficiency = 0.5;
            case 2: efficiency = 1;
            case 3: efficiency = 1.5;
            case 4: efficiency = 2;
        }

        if (this.boost_mode == true) {
            return (int) ((base_output + random.nextInt(-1000, 1000)) * efficiency);
        }
        return (int) ((base_output + random.nextInt(-100, 100)) * efficiency);
    }


    private int calculateStatus(int tick_life) {
        if (tick_life <= MIN_TICK_LIFE) {
            return 0;
        } else if (tick_life > MIN_TICK_LIFE && tick_life < MAX_TICK_LIFE / 4) {
            return 1;
        } else if (tick_life > MAX_TICK_LIFE / 4 && tick_life <= MAX_TICK_LIFE / 2) {
            return 2;
        } else if (tick_life > MAX_TICK_LIFE / 2 && tick_life <= (MAX_TICK_LIFE / 4) * 3) {
            return 3;
        } else if (tick_life > (MAX_TICK_LIFE / 4) * 3 && tick_life <= MAX_TICK_LIFE * 0.9) {
            return 4;
        }
        return 0;
    }
}
