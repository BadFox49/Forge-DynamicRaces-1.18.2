package net.badfox49.dynamic_races.client.renderer;

import net.badfox49.dynamic_races.Constants;
import net.badfox49.dynamic_races.client.model.species.WolfmanModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@OnlyIn(Dist.CLIENT)
public class ClientRenderer {

    protected static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

    // Layer Definitions
    public static final ModelLayerLocation WOLFMAN =
            new ModelLayerLocation(new ResourceLocation(Constants.MOD_ID, "Wolfman"), "main");

    protected ClientRenderer() {}

    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        log.info("{} Entity Renders ...", Constants.LOG_REGISTER_PREFIX);
    }

    public static void registerEntityLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        log.info("{} Entity Layer Definitions ...", Constants.LOG_REGISTER_PREFIX);
        event.registerLayerDefinition(WOLFMAN, WolfmanModel::createBodyLayer);
    }
}