package com.papiricoh.nukemod.init;

import com.papiricoh.nukemod.NukeMod;
import com.papiricoh.nukemod.tabs.NukeCreativeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NukeMod.MODID);

    public static final RegistryObject<Item> URANIUM = ITEMS.register("uranium", () -> new Item(
            new Item.Properties().tab(NukeCreativeTab.instance)));
    public static final RegistryObject<Item> URANIUM_ROD = ITEMS.register("uranium_rod", () -> new Item(
            new Item.Properties().tab(NukeCreativeTab.instance)));
    public static final RegistryObject<Item> URANIUM_POWDER = ITEMS.register("uranium_powder", () -> new Item(
            new Item.Properties().tab(NukeCreativeTab.instance)));
    public static final RegistryObject<Item> URANIUM_DOUBLE_ROD = ITEMS.register("uranium_double_rod", () -> new Item(
            new Item.Properties().tab(NukeCreativeTab.instance)));
}
