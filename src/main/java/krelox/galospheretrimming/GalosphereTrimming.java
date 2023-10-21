package krelox.galospheretrimming;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(GalosphereTrimming.MODID)
public class GalosphereTrimming {
    public static final String MODID = "galospheretrimming";

    public GalosphereTrimming() {
        MinecraftForge.EVENT_BUS.register(this);
    }
}
