package net.dancervlt69.slabsnstairs.Init.Events.Loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Random;
import java.util.function.Supplier;

public class CitrineCoinInSnowyChestsAdditionModifier extends LootModifier {

    public static final Supplier<Codec<CitrineCoinInSnowyChestsAdditionModifier>> CODEC = Suppliers.memoize(
            () -> RecordCodecBuilder.create(inst -> codecStart(inst).and(ForgeRegistries.ITEMS.getCodec()
                            .fieldOf("addition").forGetter(m -> m.addition))
                    .apply(inst, CitrineCoinInSnowyChestsAdditionModifier::new)));

    private final Item addition;

    protected CitrineCoinInSnowyChestsAdditionModifier(LootItemCondition[] conditionsIn, Item addition) {
        super(conditionsIn);
        this.addition = addition;
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if(context.getRandom().nextFloat() > 0.5F) {
            // generatedLoot.add(new ItemStack(addition, 2));
            generatedLoot.add(new ItemStack(addition, new Random().nextInt(6)));
        }
        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() { return CODEC.get(); }
}
