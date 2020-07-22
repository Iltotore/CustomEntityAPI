package io.github.iltotore.customentity.v1_13_R2;

import com.mojang.datafixers.DataFixUtils;
import com.mojang.datafixers.types.Type;
import io.github.iltotore.customentity.BiomeSpawn;
import io.github.iltotore.customentity.type.CustomEntityRoot;
import io.github.iltotore.customentity.HashCustomRegistry;
import io.github.iltotore.customentity.PersistentEntity;
import io.github.iltotore.customentity.util.ReflectUtil;
import io.github.iltotore.customentity.util.ServerVersion;
import net.minecraft.server.v1_13_R2.*;
import org.apache.commons.lang.Validate;
import org.bukkit.block.Biome;
import org.bukkit.entity.Entity;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;

public class NMSEntityRegistry extends HashCustomRegistry {

    private Map<EntityTypes<?>, Object> positionMap = null;
    private Field biomeEntityType;

    @SuppressWarnings("unchecked")
    public NMSEntityRegistry() {
        try {
            Field field = EntityPositionTypes.class.getDeclaredField("a");
            field.setAccessible(true);
            this.positionMap = (Map<EntityTypes<?>, Object>) field.get(null);

            biomeEntityType = BiomeBase.BiomeMeta.class.getDeclaredField("b");
            ReflectUtil.setFinal(biomeEntityType, false);
        } catch(NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    @Override
    @SuppressWarnings("unchecked")
    public void applyRegister(CustomEntityRoot<? extends Entity> type) {
        //Creating a minecraft key with the name
        MinecraftKey baseKey = MinecraftKey.a(type.getBaseKey());
        MinecraftKey minecraftKey = MinecraftKey.a(type.getKey());
        Validate.notNull(minecraftKey, "Using an invalid name for registering a custom entity. Name: " + type.getKey());

        if(IRegistry.ENTITY_TYPE.c(minecraftKey))
            throw new IllegalArgumentException("Entity with key " + type.getKey() + " already exists !");

        //Getting the data converter type for the default entity and adding that to the custom mob.
        Map<Object, Type<?>> typeMap = (Map<Object, Type<?>>) DataConverterRegistry.a().getSchema(DataFixUtils.makeKey(1628)).findChoiceType(DataConverterTypes.n).types();
        typeMap.put(minecraftKey.toString(), typeMap.get(baseKey));
        try {
            Constructor<? extends EntityInsentient> constructor = (Constructor<? extends EntityInsentient>) type.getNMSClass(ServerVersion.v1_13_2).getConstructor(World.class);


            Function<? super World, ? extends EntityInsentient> nmsCreator = world -> {
                EntityInsentient entity = null;
                try {
                    entity = constructor.newInstance(world);
                } catch(InstantiationException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
                if(entity instanceof PersistentEntity) ((PersistentEntity) entity).setCustomType(type);
                return entity;
            };

            EnumCreatureType nmsCreatureType = EnumCreatureType.valueOf(type.getCreatureType().name());

            EntityTypes<EntityInsentient> customEntityNMSEntityType = EntityTypes.a.a((Class<? extends EntityInsentient>) type.getNMSClass(ServerVersion.v1_13_2), nmsCreator)
                    .a(type.getKey());

            IRegistry.ENTITY_TYPE.a(type.getBaseID(ServerVersion.v1_13_2), minecraftKey, customEntityNMSEntityType);

            //Is an insentient entity? Also copy the EntityPositionTypes value.
            if(type.getNMSClass(ServerVersion.v1_13_2).isAssignableFrom(EntityInsentient.class)) {
                Object entityInformation = positionMap.get(customEntityNMSEntityType);
                positionMap.put(customEntityNMSEntityType, entityInformation);
            }

            type.setHandle(customEntityNMSEntityType);
            if(type.isVanilla(ServerVersion.v1_13_2))
                overrideSpawn(EnumCreatureType.valueOf(type.getCreatureType().name()), baseKey, customEntityNMSEntityType);

            for(BiomeSpawn spawn : type.getSpawns(ServerVersion.v1_16_1))
                registerSpawn(nmsCreatureType, customEntityNMSEntityType, spawn);

        } catch(NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    private void registerSpawn(EnumCreatureType creatureType, EntityTypes<? extends EntityInsentient> customType, BiomeSpawn spawn) {
        Stream.of(spawn.getBiomes())
                .map(Biome::name)
                .map(String::toLowerCase)
                .map(MinecraftKey::a)
                .map(IRegistry.BIOME::get)
                .filter(Objects::nonNull)
                .forEach(biomeBase -> {
                    List<BiomeBase.BiomeMeta> meta = biomeBase.getMobs(creatureType);
                    if(meta == null) return;
                    meta.add(new BiomeBase.BiomeMeta(customType, spawn.getWeight(), spawn.getMin(), spawn.getMax()));
                });
    }

    @SuppressWarnings("unchecked")
    private void overrideSpawn(EnumCreatureType creatureType, MinecraftKey baseKey, EntityTypes<? extends EntityInsentient> customType) {
        IRegistry.BIOME.f()
                .map(biomeBase -> biomeBase.getMobs(creatureType))
                .filter(Objects::nonNull)
                .flatMap(List::stream)
                .filter(meta -> Objects.equals(IRegistry.ENTITY_TYPE.getKey(meta.b), baseKey))
                .forEach(meta -> meta.b = (EntityTypes<? extends EntityInsentient>) customType);
    }
}