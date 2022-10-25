package com.papiricoh.nukemod.tabs;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import static com.papiricoh.nukemod.init.ItemInit.URANIUM;

public class NukeCreativeTab extends CreativeModeTab {
    private NukeCreativeTab(int index, String label) {
        super(index, label);
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(URANIUM.get());
    }

    public static final NukeCreativeTab instance = new NukeCreativeTab(CreativeModeTab.TABS.length, "nukemod");
}
