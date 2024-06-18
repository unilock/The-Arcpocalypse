package arathain.arcpocalypse.common;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.quiltmc.qsl.entity.api.QuiltEntityTypeBuilder;

import java.util.LinkedHashMap;
import java.util.Map;

import static arathain.arcpocalypse.Arcpocalypse.MODID;

public class ArcpocalypseEntities {
	private static final Map<Identifier, EntityType<?>> ENTITY_TYPES = new LinkedHashMap<>();

	// entities
	public static final EntityType<AbyssLiftEntity> ABYSS_LIFT = register("abyss_lift", QuiltEntityTypeBuilder.<AbyssLiftEntity>create(SpawnGroup.MISC).entityFactory(AbyssLiftEntity::new).setDimensions(EntityDimensions.fixed(0.995F, 2.3F)).build());

	private static <T extends Entity> EntityType<T> register(String id, EntityType<T> type) {
		ENTITY_TYPES.put(new Identifier(MODID, id), type);
		return type;
	}

	public static void init() {
		ENTITY_TYPES.forEach((id, entityType) -> Registry.register(Registries.ENTITY_TYPE, id, entityType));
	}
}
