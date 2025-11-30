package krelox.galosphere_trimming;

import net.minecraft.DetectedVersion;
import net.minecraft.data.metadata.PackMetadataGenerator;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.minecraft.util.InclusiveRange;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Optional;

@Mod(GalosphereTrimming.MOD_ID)
public class GalosphereTrimming {
    public static final String MOD_ID = "galosphere_trimming";

    public GalosphereTrimming(IEventBus modEventBus) {
        modEventBus.addListener(this::dataSetup);
    }

    public void dataSetup(GatherDataEvent event) {
        var generator = event.getGenerator();
        var packOutput = generator.getPackOutput();

        // pack.mcmeta
        var packMeta = new PackMetadataGenerator(packOutput);
        packMeta.add(PackMetadataSection.TYPE, new PackMetadataSection(
                Component.translatable("pack." + MOD_ID + ".mod.description"),
                DetectedVersion.BUILT_IN.getPackVersion(PackType.SERVER_DATA),
                Optional.of(new InclusiveRange<>(0, Integer.MAX_VALUE))));
        generator.addProvider(true, packMeta);
    }
}