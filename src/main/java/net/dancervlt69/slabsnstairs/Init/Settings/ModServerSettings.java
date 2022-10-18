package net.dancervlt69.slabsnstairs.Init.Settings;

import net.minecraftforge.common.ForgeConfigSpec;

public class ModServerSettings {

    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Integer> ILLUMINATED_GROWTH_STOP_LIGHT_RANGE;

    static {
        BUILDER.push("Server - Settings for Slabs 'n Stairs (inactive right now)");

        // SAMPLE_CONFIG_VALUE = BUILDER.comment("How many Samples you need?").define("Needed Samples", 5);

        ILLUMINATED_GROWTH_STOP_LIGHT_RANGE = BUILDER.comment("Set the Light Level of the illuminated Growth-Stops")
                .defineInRange("Growth Stop Light Level", 5, 1, 15);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
