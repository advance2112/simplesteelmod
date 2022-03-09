package com.advance.simplesteel.item;

import com.advance.simplesteel.SimpleSteelMod;
import com.advance.simplesteel.util.Registration;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModItems {

    public static final RegistryObject<Item> STEEL_INGOT =
            Registration.ITEMS.register("steel_ingot",
                    () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));


    public static final RegistryObject<Item> STEEL_SWORD =
            Registration.ITEMS.register("steel_sword",
                    () -> new SwordItem(ModItemTier.STEEL, 3, -2.4f,
                            new Item.Properties()
                                    .defaultDurability(500)
                                    .tab(ItemGroup.TAB_COMBAT)
                    )
            );

    public static final RegistryObject<Item> STEEL_SHOVEL =
            Registration.ITEMS.register("steel_shovel",
                    () -> new ShovelItem(ModItemTier.STEEL, 1.5f, -3.0f,
                            new Item.Properties()
                                    .defaultDurability(500)
                                    .addToolType(ToolType.SHOVEL, 2)
                                    .tab(ItemGroup.TAB_TOOLS)
                    )
            );

    public static final RegistryObject<Item> STEEL_PICKAXE =
            Registration.ITEMS.register("steel_pickaxe",
                    () -> new PickaxeItem(ModItemTier.STEEL, 1, -2.8f,
                            new Item.Properties()
                                    .defaultDurability(500)
                                    .addToolType(ToolType.PICKAXE, 2)
                                    .tab(ItemGroup.TAB_TOOLS)
                    )
            );

    public static final RegistryObject<Item> STEEL_AXE =
            Registration.ITEMS.register("steel_axe",
                    () -> new AxeItem(ModItemTier.STEEL, 6.0f, -3.1f,
                            new Item.Properties()
                                    .defaultDurability(500)
                                    .addToolType(ToolType.AXE, 2)
                                    .tab(ItemGroup.TAB_TOOLS)
                    )
            );

    public static final RegistryObject<Item> STEEL_HOE =
            Registration.ITEMS.register("steel_hoe",
                    () -> new HoeItem(ModItemTier.STEEL, -2, -1.0f,
                            new Item.Properties()
                                    .defaultDurability(500)
                                    .addToolType(ToolType.HOE, 2)
                                    .tab(ItemGroup.TAB_TOOLS)
                    )
            );



    public static final RegistryObject<Item> STEEL_HELMET =
            Registration.ITEMS.register("steel_helmet",
                    () -> new ArmorItem(ModArmorMaterial.STEEL, EquipmentSlotType.HEAD,
                            (new Item.Properties())
                                    .tab(ItemGroup.TAB_COMBAT)
                    )
            );

    public static final RegistryObject<Item> STEEL_CHESTPLATE =
            Registration.ITEMS.register("steel_chestplate",
                    () -> new ArmorItem(ModArmorMaterial.STEEL, EquipmentSlotType.CHEST,
                            (new Item.Properties())
                                    .tab(ItemGroup.TAB_COMBAT)
                    )
            );
    public static final RegistryObject<Item> STEEL_LEGGINGS =
            Registration.ITEMS.register("steel_leggings",
                    () -> new ArmorItem(ModArmorMaterial.STEEL, EquipmentSlotType.LEGS,
                            (new Item.Properties())
                                    .tab(ItemGroup.TAB_COMBAT)
                    )
            );
    public static final RegistryObject<Item> STEEL_BOOTS =
            Registration.ITEMS.register("steel_boots",
                    () -> new ArmorItem(ModArmorMaterial.STEEL, EquipmentSlotType.FEET,
                            (new Item.Properties())
                                    .tab(ItemGroup.TAB_COMBAT)
                    )
            );




    public static void register() { }

    public enum ModItemTier implements IItemTier
    {
        STEEL(2, 500, 6.0F, 2.0F, 12, Ingredient.of(new ItemStack(ModItems.STEEL_INGOT.get())));

        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int enchantability;
        private final Ingredient repairMaterial;

        ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Ingredient repairMaterial) {
            this.harvestLevel = harvestLevel;
            this.maxUses = maxUses;
            this.efficiency = efficiency;
            this.attackDamage = attackDamage;
            this.enchantability = enchantability;
            this.repairMaterial = repairMaterial;
        }

        @Override
        public int getUses() {
            return maxUses;
        }

        @Override
        public float getSpeed() {
            return efficiency;
        }

        @Override
        public float getAttackDamageBonus() {
            return attackDamage;
        }

        @Override
        public int getLevel() {
            return harvestLevel;
        }

        @Override
        public int getEnchantmentValue() {
            return enchantability;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return repairMaterial;
        }
    }

    public enum ModArmorMaterial implements IArmorMaterial
    {
        STEEL(SimpleSteelMod.MOD_ID + ":steel", 30, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
            return Ingredient.of(ModItems.STEEL_INGOT.get());
        });

        private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
        private final String name;
        private final int durabilityMultiplier;
        private final int[] slotProtections;
        private final int enchantmentValue;
        private final SoundEvent sound;
        private final float toughness;
        private final float knockbackResistance;
        private final LazyValue<Ingredient> repairIngredient;

        private ModArmorMaterial(String name, int durabilityMultiplier, int[] slotProtections, int enchantmentValue, SoundEvent sound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
            this.name = name;
            this.durabilityMultiplier = durabilityMultiplier;
            this.slotProtections = slotProtections;
            this.enchantmentValue = enchantmentValue;
            this.sound = sound;
            this.toughness = toughness;
            this.knockbackResistance = knockbackResistance;
            this.repairIngredient = new LazyValue<>(repairIngredient);
        }

        public int getDurabilityForSlot(EquipmentSlotType p_200896_1_) {
            return HEALTH_PER_SLOT[p_200896_1_.getIndex()] * this.durabilityMultiplier;
        }

        public int getDefenseForSlot(EquipmentSlotType p_200902_1_) {
            return this.slotProtections[p_200902_1_.getIndex()];
        }

        public int getEnchantmentValue() {
            return this.enchantmentValue;
        }

        public SoundEvent getEquipSound() {
            return this.sound;
        }

        public Ingredient getRepairIngredient() {
            return this.repairIngredient.get();
        }

        @OnlyIn(Dist.CLIENT)
        public String getName() {
            return this.name;
        }

        public float getToughness() {
            return this.toughness;
        }

        public float getKnockbackResistance() {
            return this.knockbackResistance;
        }
    }
}
