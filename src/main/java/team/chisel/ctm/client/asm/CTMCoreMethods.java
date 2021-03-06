/*package team.chisel.ctm.client.asm;

import javax.annotation.Nonnull;

import lombok.SneakyThrows;
import net.minecraft.block.state.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.WeightedBakedModel;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.common.MinecraftForge;
import team.chisel.ctm.api.event.TextureCollectedEvent;
import net.minecraftforge.client.model.IModel;
import team.chisel.ctm.CTM;
import team.chisel.ctm.api.model.IModelCTM;
import team.chisel.ctm.client.model.AbstractCTMBakedModel;
import team.chisel.ctm.client.util.ProfileUtil;

public class CTMCoreMethods {
    
    @SneakyThrows
    public static Boolean canRenderInLayer(@Nonnull BlockState state, @Nonnull BlockRenderLayer layer) {
        ProfileUtil.start("ctm_render_in_layer");
        IBakedModel model = Minecraft.getInstance().getBlockRendererDispatcher().getModelForState(state);
        if (model instanceof WeightedBakedModel) {
            model = ((WeightedBakedModel)model).baseModel;
        }
        
        Boolean ret;
        if (model instanceof AbstractCTMBakedModel) {
            ret = ((AbstractCTMBakedModel)model).getModel().canRenderInLayer(state, layer);
        } else {
            ret = null;
        }
        ProfileUtil.end();
        return ret;
    }
    
    public static ThreadLocal<Boolean> renderingDamageModel = ThreadLocal.withInitial(() -> false);
    
    public static void preDamageModel() {
        renderingDamageModel.set(true);
    }
    
    public static void postDamageModel() {
        renderingDamageModel.set(false);
    }

    public static void onSpriteRegister(TextureMap map, TextureAtlasSprite sprite) {
        MinecraftForge.EVENT_BUS.post(new TextureCollectedEvent(map, sprite));
	}
    
    public static IModel transformParent(IModel model) {
        if (model instanceof IModelCTM) {
            try {
                return ((IModelCTM) model).getVanillaParent();
            } catch (Throwable t) {
                CTM.logger.error("Please update Chisel!");
            }
        }
        return model;
    }
}
*/