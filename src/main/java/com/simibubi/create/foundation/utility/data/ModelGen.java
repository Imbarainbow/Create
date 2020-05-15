package com.simibubi.create.foundation.utility.data;

import com.simibubi.create.Create;
import com.tterrag.registrate.builders.ItemBuilder;
import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.util.nullness.NonNullFunction;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;

public class ModelGen {

	public static ModelFile createOvergrown(DataGenContext<Block, ? extends Block> ctx, BlockStateProvider prov,
			ResourceLocation block, ResourceLocation overlay) {
		return createOvergrown(ctx, prov, block, block, block, overlay);
	}

	public static ModelFile createOvergrown(DataGenContext<Block, ? extends Block> ctx, BlockStateProvider prov,
			ResourceLocation side, ResourceLocation top, ResourceLocation bottom, ResourceLocation overlay) {
		return prov.models()
				.withExistingParent(ctx.getName(), new ResourceLocation(Create.ID, "block/overgrown"))
				.texture("particle", side)
				.texture("side", side)
				.texture("top", top)
				.texture("bottom", bottom)
				.texture("overlay", overlay);
	}

	public static <P> NonNullFunction<ItemBuilder<BlockItem, P>, P> oxidizedItemModel() {
		return b -> b.model((ctx, prov) -> prov.withExistingParent(ctx.getName(), prov.modLoc(ModelGen.getOxidizedModel(ctx.getName(), 0)))).build();
	}

	public static String getOxidizedModel(String name, int level) {
		return "block/oxidized/" + name + "_" + level;
	}

}
