package com.entirecraft.general.integration.jei;

import java.util.List;

import com.entirecraft.general.blocks.Machines.CrM.CrMShapedRecipe;
import com.entirecraft.general.blocks.Machines.CrM.CrMShapelessRecipe;

import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.item.ItemStack;

public class CrMShapelessRecipeHandler implements IRecipeHandler<CrMShapelessRecipe>
{
	@Override
	public Class<CrMShapelessRecipe> getRecipeClass()
	{
		return CrMShapelessRecipe.class;
	}

	@Override
	public String getRecipeCategoryUid()
	{
		return GeoActivityRecipeCategoryUid.CRAFTING_MACHINE;
	}

	@Override
	public IRecipeWrapper getRecipeWrapper(CrMShapelessRecipe recipe)
	{
		return new CrMShapelessRecipeWrapper(recipe);
	}

	@Override
	public boolean isRecipeValid(CrMShapelessRecipe recipe)
	{
		if (recipe.getRecipeOutput() == null) {
			return false;
		}
		
		int inputCount = 0;
		
		for (Object input : recipe.recipeItems) {
			if (input instanceof ItemStack) {
				inputCount++;
			} else {
				return false;
			}
		}
		
		return inputCount > 0;
	}
}
